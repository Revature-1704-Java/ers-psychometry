package com.revature.reimbursement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDAO_jdbc implements ReimbursementDAO {

	public void requestReimbursement(int usr_id, String purpose, double amount) {
		PreparedStatement ps=null;
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql="insert into reimbursement(employeeid, amount, purpose) values(?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, usr_id);
			ps.setDouble(2, amount);
			ps.setString(3, purpose);
			ps.executeUpdate();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	public List<Reimbursement> getAllRequest() {
		PreparedStatement ps=null;
		List<Reimbursement> results= new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql="select * from reimbursement";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Reimbursement r=new Reimbursement();
				r.setId(rs.getInt("id"));
				r.setEmployeeId(rs.getInt("employeeid"));
				r.setAmount(rs.getDouble("amount"));
				r.setPurpose(rs.getString("purpose"));
				r.setStatus(rs.getString("status"));
				results.add(r);
			}
			rs.close();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return results;
	}

	public List<Reimbursement> getEmployeeRequest(int usr_id) {
		PreparedStatement ps=null;
		List<Reimbursement> results= new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql="select * from reimbursement where employeeid=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, usr_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Reimbursement r=new Reimbursement();
				r.setId(rs.getInt("id"));
				r.setEmployeeId(rs.getInt("employeeid"));
				r.setAmount(rs.getDouble("amount"));
				r.setPurpose(rs.getString("purpose"));
				r.setStatus(rs.getString("status"));
				results.add(r);
			}
			rs.close();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return results;
	}

	public void deleteRequest(int r_id) {
		PreparedStatement ps=null;
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql="delete from reimbursement where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, r_id);
			ps.executeUpdate();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
