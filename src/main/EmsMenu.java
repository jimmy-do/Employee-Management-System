package main;

import java.util.Scanner;

import dao.Employee;
import dao.EmployeeDAOImplementation;

public class EmsMenu {
	
	public void mainMenu() {
		
		Scanner scanner = new Scanner(System.in);
		
			while (true) {
			System.out.println("Welcome to the EMS Application");
			System.out.println("Select an option:");
			System.out.println("1. View Employees \n2. Add Employee \n3. Delete Employee \n4. Edit Employee \n5. Exit the EMS");
			
			int userInput = scanner.nextInt();
			
			switch (userInput) {
			
			case 1:
				viewEmployees();
				break;
			case 2:
				addEmployee();
				break;
			case 3:
				deleteEmployee();
				break;
			case 4:
				updateEmployee();
			case 5:
				exitProgram();
				System.exit(0);
			default:
				enterValidException();
			}
		}
	}

	public void viewEmployees() {
		
		EmployeeDAOImplementation runner = new EmployeeDAOImplementation();
		System.out.println(runner.getAllEmployees());
	}
	
	public void addEmployee() {

		EmployeeDAOImplementation runner = new EmployeeDAOImplementation();
		Employee employee = new Employee();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter employee name to add into database: ");
		String employeeName = scanner.nextLine();
		employee.setEmployeeName(employeeName);
		
		System.out.println("Please enter employee department: ");
		String employeeDepartment = scanner.nextLine();
		employee.setDepartment(employeeDepartment);
		
		runner.addEmployee(employee);
	}
	
	public void deleteEmployee() {
		EmployeeDAOImplementation runner = new EmployeeDAOImplementation();
		Employee employee = new Employee();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter employee ID to delete from database: ");
		int employeeId = scanner.nextInt();
		employee.setId(employeeId);
		
		runner.deleteEmployee(employee);
	}

	public void updateEmployee() {
		
		EmployeeDAOImplementation runner = new EmployeeDAOImplementation();
		Employee employee = new Employee();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter employee ID you wish to edit: ");
		int employeeId = scanner.nextInt();
		employee.setId(employeeId);
		scanner.nextLine();

		System.out.println("Please enter employee name to update to database: ");
		String employeeName = scanner.nextLine();
		employee.setEmployeeName(employeeName);
		
		System.out.println("Please enter employee department to update to database: ");
		String employeeDepartment = scanner.nextLine();
		employee.setDepartment(employeeDepartment);
		
		runner.updateEmployee(employee);	
	}
	
	public String exitProgram() {
		return "Exiting EMS program...";
	}
	
	public void enterValidException() {
		System.out.println("Not a valid option. Please enter a valid option: ");
	}
}
