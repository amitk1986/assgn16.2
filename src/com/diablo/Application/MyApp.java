package com.diablo.Application;

import com.diablo.dao.EmployeeDapImpl;

public class MyApp {

	public static void main(String[] args) {
		EmployeeDapImpl empl = new EmployeeDapImpl();
		empl.updateEmployee(1,"garry");
		empl.deleteEmployee(2);
		empl.insertEmployee();
		empl.listEmployee();
	}

}
