package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionManager;

public class EmployeeDAOImplementation implements EmployeeDao {

	private Connection connection = ConnectionManager.getConnection();
	
	
	public List<Employee> getAllEmployees() {
		
		List<Employee> employees = new ArrayList<Employee>();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM employees");
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString("employee_name"); 
				String department = rs.getString("department");
				
				Employee employee = new Employee(id, name, department);
				employees.add(employee);
			}	
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	
	public Employee getEmployeeById(int id) {
		Employee employee = new Employee();
		
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = ?");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				employee.setId(rs.getInt(1));
				employee.setEmployeeName(null); 
				employee.setDepartment(rs.getString("department"));
			}	
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	
	public Employee getEmployeeByName(String name) {
		Employee employee = new Employee();
		
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees WHERE name = ?");
			statement.setString(1, name);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				employee.setId(rs.getInt(1));
				employee.setEmployeeName(null); 
				employee.setDepartment(rs.getString("department"));
			}	
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	
	public boolean addEmployee(Employee employee) {
		
		int count = 0;
		try {
			PreparedStatement statement = connection.prepareStatement("INSERT INTO employees "
					+ "(employee_name, department) "
					+ "VALUES (?,?)");
			
			statement.setString(1, employee.getEmployeeName());
			statement.setString(2, employee.getDepartment());
			
			count = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (count == 1) return true;
		return false;
	}

	
	public boolean updateEmployee(Employee employee) {
		
		int count = 0;
		
		try {
			
			PreparedStatement statement = connection.prepareStatement("UPDATE employees SET employee_name = ?, department = ? WHERE id = ?");
			
			statement.setString(1, employee.getEmployeeName());
			statement.setString(2, employee.getDepartment());
			statement.setInt(3, employee.getId());
			
			count = statement.executeUpdate();
			statement.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if (count == 1) return true;
		return false;
	}

	
	public boolean deleteEmployee(Employee employee) {
		
		int count = 0;
		
		try {
			
			PreparedStatement statement = connection.prepareStatement("DELETE FROM employees WHERE id = ?");
			statement.setInt(1, employee.getId());
			count = statement.executeUpdate();
			statement.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if (count == 1) return true;
		return false;
	}

}
