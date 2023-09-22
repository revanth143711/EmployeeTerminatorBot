-- Database: EmployeeTerminatorBot

-- DROP DATABASE IF EXISTS "EmployeeTerminatorBot";

--  drop table Employee_Details;
-- 	drop table Manager_Details;
-- 	drop table HR_Details;
	
	CREATE DATABASE "EmployeeTerminatorBot";
	
	create table HR_Details
	(
	HR_ID INT NOT NULL,
	name varchar,
	email varchar,
	Contact_Number char(10),
	Department varchar,
	PRIMARY KEY(HR_ID)
	);
	
	insert into HR_Details (HR_ID,name,email,Contact_Number,Department)
	values 
	(1,'Harika','Harika@gmail.com','9988923437','IT'),
	(2,'Revanth','Revanth@gmail.com','7900896645','Business Intelligence');
	
	create table Manager_Details
	(
	Manager_ID INT NOT NULL,
	name varchar,
	email varchar,
	Contact_Number varchar,
	Department varchar,
	HR_id int,
	PRIMARY KEY(Manager_ID),
	foreign key(HR_ID) REFERENCES HR_Details(HR_ID)
	);
	
	insert into Manager_Details (Manager_ID,name,email,Contact_Number,Department,HR_ID)
	values 
	(11,'Suman','Suman@gmail.com','8765423437','IT',1),
	(12,'Raju','Raju@gmail.com','9664579008','Business Intelligence',2),
	(13,'Rahul','Rahul@gmail.com','8982487654','IT',1),
	(14,'Sravanthy','Sravanthy@gmail.com','9900899889','Business Intelligence',2),
	(15,'Harika','Harika@gmail.com','9234377689','IT',1);
	
	create table Employee_Details
	(
	Employee_ID INT NOT NULL,
	name varchar,
	email varchar,
	Contact_Number varchar,
	Department varchar,
	Manager_ID int,
	PRIMARY KEY(Employee_ID),
	FOREIGN KEY(Manager_ID) REFERENCES Manager_details(Manager_ID)
	);
	
	insert into Employee_Details (Employee_ID,name,email,Contact_Number,Department,Manager_ID)
	values 
	(111,'Shashank','Shashank@gmail.com','8982487654','IT',11),
	(112,'Suraaj','Suraaj@gmail.com','9900811010','Business Intelligence',12),
	(113,'Kamalesh','Kamalesh@gmail.com','7452487689','IT',13),
	(114,'Sairaj','Sairaj@gmail.com','9900719889','Business Intelligence',12),
	(115,'Kavya','Kavya@gmail.com','8034377689','IT',13),
	(116,'Rajini','Rajini@gmail.com','8765423400','IT',15),
	(117,'Hemanth','Hemanth@gmail.com','9664889008','Business Intelligence',14),
	(118,'Nachika','Nachika@gmail.com','7782487654','IT',11),
	(119,'Keerthi','Keerthi@gmail.com','8900899889','Business Intelligence',12),
	(120,'Jagruthi','Jagruthi@gmail.com','7234377339','IT',11),
	(121,'Pallavi','Pallavi@gmail.com','6900895689','Business Intelligence',14);
		
	select * from Manager_Details;
	select * from HR_Details;
	select * from Employee_Details;

	select emp.employee_id,emp.name
	from employee_details emp join manager_details man
	on emp.manager_id=man.manager_id
	where man.manager_id=11
	
	select hr.hr_id,emp.employee_id
	from employee_details emp join manager_details man
	on emp.manager_id=man.manager_id
	join hr_details hr on hr.hr_id=man.hr_id
	where hr.hr_id=1;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	