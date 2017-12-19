package com.revature.reimbursement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDAO_jdbc implements EmployeeDAO {

	public void userRegistration(String firstName, String lastName, String userName, String passWord) {
		PreparedStatement ps=null;
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql="insert into employee(firstname, lastname, username, password) values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, userName);
			ps.setString(4, passWord);
			ps.executeUpdate();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Employee getEmployee(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee em = new Employee();
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from employee where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				em.setId(rs.getInt("id"));
				em.setFirstName(rs.getString("firstname"));
				em.setLastName(rs.getString("lastname"));
				em.setUserName(rs.getString("username"));
				em.setPassWord(rs.getString("password"));
				em.setAdmin(rs.getString("admin").equals("1"));
			}
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return em;
	}

	public Employee getEmployee(String userName) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee em = new Employee();
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from employee where username = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			while (rs.next()) {
				em.setId(rs.getInt("id"));
				em.setFirstName(rs.getString("firstname"));
				em.setLastName(rs.getString("lastname"));
				em.setUserName(rs.getString("username"));
				em.setPassWord(rs.getString("password"));
				em.setAdmin(rs.getString("admin").equals("1"));
			}
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		return em;
	}

}
