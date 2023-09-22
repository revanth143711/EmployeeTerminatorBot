import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeesToManager {
	private String user="postgres";
	private String password="1437";
	private String url="jdbc:postgresql://localhost/EmployeeTerminatorBot";
	
	private void connect() throws Exception
	{
		try(Connection con=DriverManager.getConnection(url,user,password);)
		{
			Statement st=con.createStatement();
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("These are the managerId's present in Manager_Details table");
			String s1="select Manager_id from Manager_details";
			ResultSet set1=st.executeQuery(s1);
			while(set1.next())
			{
				System.out.println(set1.getString(1));
			}
			System.out.println("Enter the Manager_id (which you want to get the employees reporting to that Manager_id) from the Manager_Details table which are displayed above");
			int managerId=Integer.parseInt(br.readLine());
			String s="select emp.employee_id as employeeID,emp.name AS name\r\n"
					+ "	from employee_details emp join manager_details man\r\n"
					+ "	on emp.manager_id=man.manager_id\r\n"
					+ "	where man.manager_id="+managerId+"";
			ResultSet set=st.executeQuery(s);
			ResultSetMetaData metaData = set.getMetaData();
		    int columnCount = metaData.getColumnCount();
		    System.out.println("This are the Employees (with employee_ID AND name) those are reporting to the Manager_ID = "+managerId);
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
		EmployeesToManager etm=new EmployeesToManager();
		etm.connect();

	}

}
