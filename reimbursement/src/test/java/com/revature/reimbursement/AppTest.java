package com.revature.reimbursement;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.revature.reimbursement.App;
public class AppTest {
	public class EDAODummy implements EmployeeDAO{

		@Override
		public void userRegistration(String firstName, String lastName, String userName, String passWord) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Employee getEmployee(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Employee getEmployee(String userName) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testVerifyUser() {}

}
