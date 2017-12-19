package com.revature.reimbursement;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
	public Employee testcase;
	
	@Before
	public void setUp() throws Exception {
		testcase=new Employee();
		testcase.setId(0);
		testcase.setAdmin(true);
		testcase.setFirstName("jack");
		testcase.setLastName("flag");
		testcase.setUserName("user");
		testcase.setPassWord("password");
	}

	@Test
	public void testGetId() {
		assertEquals(testcase.getId(),0);
	}

	@Test
	public void testSetId() {
		testcase.setId(2);
		assertNotEquals(testcase.getId(),0);
		assertEquals(testcase.getId(),2);
	}

	@Test
	public void testGetFirstName() {
		assertEquals(testcase.getFirstName(),"jack");
	}

	@Test
	public void testSetFirstName() {
		testcase.setFirstName("james");
		assertNotEquals(testcase.getFirstName(),"jack");
		assertEquals(testcase.getFirstName(),"james");
	}

	@Test
	public void testGetLastName() {
		assertEquals(testcase.getLastName(),"flag");
	}

	@Test
	public void testSetLastName() {
		testcase.setLastName("harden");
		assertNotEquals(testcase.getLastName(),"flag");
		assertEquals(testcase.getLastName(),"harden");
	}

	@Test
	public void testGetUserName() {
		assertEquals(testcase.getUserName(),"user");
	}

	@Test
	public void testSetUserName() {
		testcase.setUserName("name");
		assertNotEquals(testcase.getUserName(),"user");
		assertEquals(testcase.getUserName(),"name");
	}

	@Test
	public void testGetPassWord() {
		assertEquals(testcase.getPassWord(),"password");
	}

	@Test
	public void testSetPassWord() {
		testcase.setPassWord("word");
		assertNotEquals(testcase.getPassWord(),"password");
		assertEquals(testcase.getPassWord(),"word");
	}

	@Test
	public void testIsAdmin() {
		assertTrue(testcase.isAdmin());
	}

	@Test
	public void testSetAdmin() {
		testcase.setAdmin(false);
		assertFalse(testcase.isAdmin());
	}

}
