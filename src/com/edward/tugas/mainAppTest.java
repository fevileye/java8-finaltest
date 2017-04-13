package com.edward.tugas;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class mainAppTest {
	
	@Test
	public void tambah() throws Exception{
		List<String> EmployeeName=new ArrayList<String>();
		assertEquals(mainApp.tambah(EmployeeName, "Andi"), true);
	}
	
	@Test
	public void view() throws Exception{
		List<String> EmployeeName=new ArrayList<String>();
		EmployeeName.add("Budi");
		EmployeeName.add("Santi");
		
		List<String> EmployeeView=new ArrayList<String>();
		EmployeeView.add("BUDI");
		EmployeeView.add("SANTI");
		assertEquals(mainApp.view(EmployeeName), EmployeeView);
	}
	
	@Test
	public void delete() throws Exception{
		List<String> EmployeeName=new ArrayList<String>();
		EmployeeName.add("Budi");
		EmployeeName.add("Santi");
		
		List<String> EmployeeDelete=new ArrayList<String>();
		EmployeeDelete.add("Santi");
		
		assertEquals(mainApp.delete(EmployeeName, "Budi"),EmployeeDelete);
	}
	
	@Test
	public void dataTotal() throws Exception{
		List<String> EmployeeName=new ArrayList<String>();
		EmployeeName.add("Budi");
		EmployeeName.add("Santi");
		
		assertEquals(mainApp.dataTotal(EmployeeName),2);
	}
}
