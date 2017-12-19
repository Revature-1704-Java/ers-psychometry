package com.revature.reimbursement;

public interface EmployeeDAO {
	public void userRegistration(String firstName, String lastName, String userName, String passWord);
	public Employee getEmployee(int id);
	public Employee getEmployee(String userName);
}
