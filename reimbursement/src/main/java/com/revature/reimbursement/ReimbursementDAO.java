package com.revature.reimbursement;

import java.util.List;

public interface ReimbursementDAO {
	public void requestReimbursement(int usr_id, String purpose, double amount);
	public List<Reimbursement> getAllRequest();
	public List<Reimbursement> getEmployeeRequest(int usr_id);
	public void deleteRequest(int usr_id);
}
