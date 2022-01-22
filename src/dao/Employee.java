package dao;

public class Employee {

	private int id;
	private String employeeName;
	private String department;
	
	public Employee() {
		
	}
	
	public Employee(int id, String employee_name, String department) {
		super();
		this.id = id;
		this.employeeName = employee_name;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employee_name) {
		this.employeeName = employee_name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", employee_name=" + employeeName + ", department=" + department + "]";
	}
	
}

