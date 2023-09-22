import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeesToHR {
	private String user="postgres";
	private String password="1437";
	private String url="jdbc:postgresql://localhost/EmployeeTerminatorBot";
	
	private void connect() throws Exception
	{
		try(Connection con=DriverManager.getConnection(url,user,password);)
		{
			Statement st=con.createStatement();
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("These are the HR_ID's present in HR_Details table");
			String s1="select HR_id from HR_details";
			ResultSet set1=st.executeQuery(s1);
			while(set1.next())
			{
				System.out.println(set1.getString(1));
			}
			System.out.println("Enter the HR_ID (which you want to get the employees reporting to that HR_id) from the HR_Details table which are displayed above");
			int hrid=Integer.parseInt(br.readLine());
			String s="select emp.employee_id,emp.name\r\n"
					+ "	from employee_details emp join manager_details man\r\n"
					+ "	on emp.manager_id=man.manager_id\r\n"
					+ "	join hr_details hr on hr.hr_id=man.hr_id\r\n"
					+ "	where hr.hr_id="+hrid+" ";
			ResultSet set=st.executeQuery(s);
			ResultSetMetaData metaData = set.getMetaData();
		    int columnCount = metaData.getColumnCount();
		    System.out.println("This are the Employees (with employee_ID AND name) those are reporting to the HR_ID = "+hrid);
			while(set.next())
			{
				for(int j=1;j<=columnCount;j++)
				{
					System.out.print(set.getString(j)+"          ");
				}
				System.out.println();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		EmployeesToHR etHR=new EmployeesToHR();
		etHR.connect();

	}

}
