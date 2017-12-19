package com.revature.reimbursement;

import java.util.List;
import java.util.Scanner;

public class App 
{
	public static EmployeeDAO EDAO=new EmployeeDAO_jdbc();
	public static ReimbursementDAO RDAO=new ReimbursementDAO_jdbc();
    public static void main( String[] args )
    {
    	Scanner sc=new Scanner(System.in);
    	String username, password;
    	do {
    		System.out.println("Employee Reimbursement System");
            System.out.println("Login");
            System.out.print("Enter Username: ");
            username = sc.nextLine();
            System.out.print("Enter Password: ");
            password = sc.nextLine();
    	}while(!verify_user(username,password));
    	Employee current_user=EDAO.getEmployee(username);
    	if(current_user.isAdmin()){
    		display_admin_view(current_user);
    	}else {
    		display_user_view(current_user);
    	}
    	System.out.println("Enter 1 to add a reimbursement request, anything else to terminate the program");
    	System.out.println("What would you like to do?");
    	int command=sc.nextInt();
    	process_command(command,current_user,sc);
    	System.out.println("Thank you for using the ERS.");
    	sc.close();
    }
    
	private static void process_command(int command, Employee current_user, Scanner sc) {
		switch(command) {
			case 1:
				add_reimbursement_requerst(current_user, sc);
				break;
			default:
				break;
		}
		
	}
	private static void add_reimbursement_requerst(Employee current_user, Scanner sc) {
		int e_id=current_user.getId();
		double amount=0.0;
		String purpose;
		System.out.println("Enter the reason for your reimbursement request: ");
		sc.nextLine();
		purpose=sc.nextLine();
		System.out.println("Enter the amount of your request: ");
		amount=sc.nextDouble();
		RDAO.requestReimbursement(e_id, purpose, amount);
	}

	
	private static void display_user_view(Employee current_user) {
		List<Reimbursement> requests= RDAO.getEmployeeRequest(current_user.getId());
		System.out.printf("|%10s||%10s||%10s||%20s||%10s|\n","r_id","employeeid","amount","purpose","status");
		for(Reimbursement r : requests) {
			System.out.printf("|%10s||%10s||%10s||%20s||%10s|", r.getId(),r.getEmployeeId(),r.getAmount(),r.getPurpose(),r.getStatus());
			System.out.println();
		}
	}

	private static void display_admin_view(Employee current_user) {
		List<Reimbursement> requests= RDAO.getAllRequest();
		System.out.printf("|%10s||%10s||%10s||%20s||%10s|\n","r_id","employeeid","amount","purpose","status");
		for(Reimbursement r : requests) {
			System.out.printf("|%10s||%10s||%10s||%20s||%10s|\n", r.getId(),r.getEmployeeId(),r.getAmount(),r.getPurpose(),r.getStatus());
		}
		
	}

	static boolean verify_user(String username, String password) {
		Employee em=EDAO.getEmployee(username);
		return password.equals(em.getPassWord());
	}
}
