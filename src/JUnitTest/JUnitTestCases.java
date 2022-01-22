package JUnitTest;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import dao.*;
import connection.*;


public class JUnitTestCases {
	
	@Test
	public void setAndGetNameTest() {
		String expectedEmployeeName1 = "Jimmy";
		Employee employee1 = new Employee();
		employee1.setEmployeeName(expectedEmployeeName1);
		
		String expectedEmployeeName2 = "Dani";
		Employee employee2 = new Employee();
		employee2.setEmployeeName(expectedEmployeeName2);
		
		String expectedEmployeeName3 = "Step";
		Employee employee3 = new Employee();
		employee3.setEmployeeName(expectedEmployeeName3);
		
		assertEquals(expectedEmployeeName1, employee1.getEmployeeName());
		assertEquals(expectedEmployeeName2, employee2.getEmployeeName());
		assertEquals(expectedEmployeeName3, employee3.getEmployeeName());
	}
	
	@Test
	public void setAndGetDepartmentTest() {
		String expectedDepartment = "Engineering";
		Employee employee = new Employee();
		employee.setDepartment(expectedDepartment);
		
		assertEquals(expectedDepartment, employee.getDepartment());
	}
	
	@Test
	void switchCase5String() {
		EmsMenu newMenu = new EmsMenu();
		String expected = newMenu.exitProgram();
		String actual = "Exiting EMS program...";
		assertEquals(expected,actual);
	}
}
