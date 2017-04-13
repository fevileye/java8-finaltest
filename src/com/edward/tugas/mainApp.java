package com.edward.tugas;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class mainApp {
	
	public static void cls()
	{
		for (int i=0;i<5;i++)
		{
			System.out.println();
		}
	}
	
	public static List<String> initialize(List<String> EmployeeName){
		
		File f=new File("./Employee.txt");
		if (f.exists())
		{
			
			System.out.println("File Found");
				try {
					EmployeeName=Files.lines(Paths.get("./Employee.txt")).collect(Collectors.toList());
				} catch (IOException e) {
					// TODO2 Auto-generated catch block
					e.printStackTrace();
				}
		}
		else
		{
			System.out.println("File Not Found");
		}
		
		return EmployeeName;
	}
	
	public static void close(List<String> EmployeeName){
		
		 Charset characterSet=Charset.defaultCharset();
		  try(PrintWriter writer=new PrintWriter(Files.newBufferedWriter(Paths.get("./Employee.txt"), characterSet))){
			  for (int i=0;i<EmployeeName.size();i++)
			  {
				  writer.printf("%s%n", EmployeeName.get(i));
			  }
		  }
		  catch(IOException ioe){
			  System.err.printf("IOException : %s%n",ioe);
		  }
		  
	}
	
	public static List<String> view(List<String> EmployeeName){
		EmployeeName=EmployeeName.stream().sorted().map(e->e.toUpperCase()).collect(Collectors.toList());
		EmployeeName.stream().forEach(System.out::println);
		
		return EmployeeName;
	}
	
	public static List<String> delete(List<String> EmployeeName,String cari){
		
		for (int i=0;i<EmployeeName.size();i++)
		{
			if (EmployeeName.get(i).compareTo(cari)==0)
			{
				EmployeeName.remove(i);
			}
		}
		
		return EmployeeName;
	}
	
	public static boolean tambah(List<String> EmployeeName, String value)
	{
		EmployeeName.add(value);
		
		return (EmployeeName.get(EmployeeName.size()-1).compareTo(value)==0);
	}
	
	
	public static long dataTotal(List<String> EmployeeName){
		
		
		return EmployeeName.stream().count();
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int choice=0;
		String tempName;
		
		List<String> EmployeeName=new ArrayList<String>();
		
		EmployeeName=initialize(EmployeeName);
		do
		{
		cls();
		System.out.println("Mitrais Employee Information");
		System.out.println("==============================");
		System.out.println("1. Add Employee Data");
		System.out.println("2. Delete Employee Data");
		System.out.println("3. List Employee Data");
		System.out.println("4. Show numbers of employee");
		System.out.println("5. Exit");
		System.out.println("Your choice : ");
		choice=sc.nextInt();
		
			switch(choice)
			{
			case 1:
				System.out.println("Input the name of Employee : ");
				tempName=sc.next();
				tambah(EmployeeName,tempName);
				break;
			case 2:
				System.out.println("The name you want to delete : ");
				tempName=sc.next();
				delete(EmployeeName,tempName);
				break;
			case 3:
				view(EmployeeName);
				break;
			case 4:
				System.out.println("Numbers of data : ");
				System.out.println(dataTotal(EmployeeName));
				break;
			case 5:
				close(EmployeeName);
				break;
			}
			
		}
		while(choice!=5);
		
	}
}
