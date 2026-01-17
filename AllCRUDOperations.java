package jdbcCRUDOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AllCRUDOperations {
	public static void main(String[] args) {
		// demo credentials

		// com.mysql.jdbc.Driver
		// jdbc:mysql://127.0.0.1:3306/your_db_name
		// root,root

		Scanner scn = new Scanner(System.in);

// VARIABLES ....

		String driver = null, url = null, username, password, query = " ";
		int ch = 0;
		boolean isRunning;

		System.out.println("*** Registration Part ***\n");

// DATABASE REGISTRATION SECTION..........

		System.out.print("Enter a driver of database: ");
		driver = scn.nextLine();

		System.out.print("Enter an url of database: ");
		url = scn.nextLine();

		System.out.print("Enter an username: ");
		username = scn.nextLine();

		System.out.print("Enter a password: ");
		password = scn.nextLine();

		try {

			Class.forName(driver);
			System.out.println("Driver Loaded Succesfully !!\n");
			isRunning = true;

		} catch (ClassNotFoundException e) {
			System.out.println("\nError:");
			System.out.println("Invalid Credentials!!! ");
			isRunning = false;
		}

// WHILE LOOP SECTION...................................

		while (isRunning == true) {
			System.out.println("\n---------------------------");
			System.out.println("* CRUD Operations in java *");
			System.out.println("---------------------------");
			System.out.println("1 For Create:");
			System.out.println("2 For Insert");
			System.out.println("3 For Read:");
			System.out.println("4 For Update:");
			System.out.println("5 For Delete:");
			System.out.println("6 For Exit:");

			try {
				System.out.print("Enter your choice !:");
				ch = scn.nextInt();
				scn.nextLine();
			} catch (InputMismatchException e) {
				// TODO: handle exception
				System.out.println("\nError:");
				System.out.println("Please enter a valid choice between 1-6 !");
				isRunning = false;
			}

			switch (ch) {

// CREATE SECTION..........................

			case 1:
				try {
					System.out.println("\n*** CREATE Section: ***\n");

					Connection con = DriverManager.getConnection(url, username, password);
					System.out.println("Connection made Successfully !! ");
					System.out.println("Connection Id: " + con);

					Statement stmt = con.createStatement();
					System.out.println("\nStatement Created Successfully !!");
					System.out.println("Statement Id: " + stmt);

					System.out.print("\nEnter a SQL Query to execute: ");
					query = scn.nextLine();
					System.out.println("\nYour Query: " + query);

					stmt.executeUpdate(query);

					System.out.println("Statement Executed !");

					stmt.close();
					con.close();

					System.out.println("\nStatement closed Successfully !!");
					System.out.println("Connection closed Successfully !! ");

				} catch (SQLException e) {
					System.out.println("\nError:");
					System.out.println(e.getMessage());
				}
				break;

// INSERT SECTION....................................

			case 2:
				try {
					System.out.println("\n*** INSERT Section: ***");
					Connection con = DriverManager.getConnection(url, username, password);
					System.out.println("\nConnection made Successfully !! ");
					System.out.println("Connection Id: " + con);

					Statement stmt = con.createStatement();
					System.out.println("\nStatement Created Successfully !!");
					System.out.println("Statement Id: " + stmt);

					System.out.print("\nEnter a SQL Query to execute: ");
					query = scn.nextLine();
					System.out.println("\nYour Query: " + query);

					int rowAffected = stmt.executeUpdate(query);

					if (rowAffected > 0) {
						System.out.println("\nInsert Successfull !! " + rowAffected + " row(s) affected.");
					} else {
						System.out.println("Insertion Failed !!");
					}

					stmt.close();
					con.close();

					System.out.println("\nStatement closed Successfully !!");
					System.out.println("Connection closed Successfully !! ");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("\nError:");
					System.out.println(e.getMessage());
				}
				break;

// READ/SELECT SECTION............................

			case 3:
				System.out.println("\n*** READ Section: ***");
				try {
					Connection con = DriverManager.getConnection(url, username, password);
					System.out.println("\nConnection made Successfully !! ");
					System.out.println("Connection Id: " + con);

					Statement stmt = con.createStatement();
					System.out.println("\nStatement created Successfully !!");
					System.out.println("Statement Id: " + stmt + "\n");

					System.out.print("\nEnter a SQL Query to execute: ");
					query = scn.nextLine();
					System.out.println("Your Query: " + query);

					ResultSet rs = stmt.executeQuery(query);
					System.out.println("\nResultSet created Successfully !! ");
					System.out.println("ResulSet Id: " + rs);

					System.out.println("\nData from MYSQL database:");

					if (!rs.next()) {
						System.out.println("No data Found !!");
					} else {
						while (rs.next()) {
							int id = rs.getInt("id");
							String name = rs.getString("name");
							int salary = rs.getInt("Salary");

							System.out.println("------------------------");
							System.out.println("Data from table:");
							System.out.println("Id: " + id);
							System.out.println("Name: " + name);
							System.out.println("Salary: " + salary);
							System.out.println("-------------------------");
						}
					}

					rs.close();
					stmt.close();
					con.close();

					System.out.println("\nResultSet closed Successfully !! ");
					System.out.println("Statement closed Successfully !! ");
					System.out.println("Connection closed Successfully !! \n");

				} catch (SQLException e) {
					System.out.println("\nError:");
					System.out.println(e.getMessage());
				}
				break;

//UPDATE SECTION..................................

			case 4:
				System.out.println("\n*** UPDATE Section: ***");
				try {

					Connection con = DriverManager.getConnection(url, username, password);
					System.out.println("\nConnection made Successfully !! ");
					System.out.println("Connection Id: " + con);

					Statement stmt = con.createStatement();
					System.out.println("\nStatement created Successfully !!");
					System.out.println("Statement Id: " + stmt);

					System.out.print("\nEnter a SQL Query to execute: ");
					query = scn.nextLine();
					System.out.println("Your Query: " + query);

					int rowAffected = stmt.executeUpdate(query);

					if (rowAffected > 0) {
						System.out.println("\nUpdate Successful !! " + rowAffected + " row(s) affected.");
					} else {
						System.out.println("Update Failed !!");
					}

					stmt.close();
					con.close();
					System.out.println("\n--------------------------------------------------");
					System.out.println("Statement closed Successfully !! ");
					System.out.println("Connection closed Successfully !! ");

				} catch (SQLException e) {
					System.out.println("\nError:");
					System.out.println(e.getMessage());
				}
				break;

//DELETE SECTION..................................

			case 5:
				System.out.println("\n*** DELETE Section ***");
				try {

					Connection con = DriverManager.getConnection(url, username, password);
					System.out.println("\nConnection made Successfully !! ");
					System.out.println("Connection Id: " + con);

					Statement stmt = con.createStatement();
					System.out.println("\nStatement created Successfully !!" + stmt);
					System.out.println("Statement Id: " + stmt);

					System.out.print("\nEnter a SQL Query to execute: ");
					query = scn.nextLine();
					System.out.println("\nYour Query: " + query);

					int rowAffected = stmt.executeUpdate(query);

					if (rowAffected > 0) {
						System.out.println("\nDelete Successfull !! " + rowAffected + " row(s) affected.");
					} else {
						System.out.println("Deletion Failed !!");
					}

					stmt.close();
					con.close();
					System.out.println("\n--------------------------------------------------");
					System.out.println("Statement closed Successfully !! ");
					System.out.println("Connection closed Successfully !! ");

				} catch (SQLException e) {
					System.out.println("\nError:");
					System.out.println(e.getMessage());
				}
				break;

//EXIT SECTION....................................

			case 6:
				System.out.println("\nYou successfully exited an operations !");
				System.out.println("Press CTRL + F11 to start again ");
				isRunning = false;
				break;

//DEFAULT SECTION.................................

			default:
				System.out.println("\nInvalid choice! Please select choice from below:");
				break;
			}
		}
		scn.close();
	}
}
