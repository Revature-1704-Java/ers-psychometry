package com.revature.reimbursement;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.revature.reimbursement.App;
public class AppTest {
	public class EDAODummy implements EmployeeDAO{
		public List<Employee> dummy_record=new ArrayList<>();
		@Override
		public void userRegistration(String firstName, String lastName, String userName, String passWord) {
			Employee em = new Employee();
			em.setFirstName(firstName);
			em.setLastName(lastName);
			em.setUserName(userName);
			em.setPassWord(passWord);
			em.setAdmin(true);
			dummy_record.add(em);
		}

		@Override
		public Employee getEmployee(int id) {
			return null;
		}

		@Override
		public Employee getEmployee(String userName) {
			Employee target=null;
			for(Employee em : dummy_record) {
				if(em.getUserName().equals(userName)) {
					target=em;
				}
			}
			return target;
		}
		
	}
	public EmployeeDAO DAO= new EDAODummy(); 
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testVerifyUser() {}

}
