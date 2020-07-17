package AttendanceSystem;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class MyMain {
	public static Organisation org1;

    public synchronized static void main(String[] args) {

		
		//Organisation o = new Organisation();
	//	obj.addEmptoOrg(o ,"name", 0, 5.5f, 250);
//		o.punch("empId0", 0.0f );
		//o.addEmp();
//		obj.saveData("Organisation", o);


    	DatabaseReference ref;
    	Firebase obj = new Firebase();
		ref = obj.setRef("/");

    	String JSONstr = obj.convertToJSON(obj.retriveData("/Organisation"));
    	Gson g = new Gson(); 
		
	

    	Organisation p =  g.fromJson(JSONstr, Organisation.class);
    	//System.out.println(JSONstr);
    	
    	//obj.addEmptoOrg(p, "XYZD", 63, 5.2f, 120);

    	//p.punch("empId3");
    	
    	//obj.SleepThread(100000);
    	Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to Attendance System");
    	
    		int choice=3;
    		//System.out.println("1. Add Employee");
    		//System.out.println("2. Punch Attendance");
			//choice = Integer.valueOf(scan.nextLine());
			if(args[0].equals("id")){
				choice = 2;
			}else if(args[0].equals("add")){
				choice = 1;
			}else if(args[0].equals("hw")){
				choice = 3;
			}else if(args[0].equals("sal")){
				choice = 4;
			}else{
				choice = 0;
			}
			switch(choice) {
    		case 1:
    			System.out.print("Name :");
    			String name = scan.nextLine();
    			System.out.print("Age :");
    			int age = Integer.valueOf(scan.nextLine());
    			System.out.print("Salary Per hr :");
    			float SalaryPerDay = Float.valueOf(scan.nextLine());
    			obj.addEmptoOrg(p, name , age  , 5.6f , SalaryPerDay);
    			obj.saveData("Organisation", p);
    			break;
    		case 2:
    			System.out.print("Enter Emp Id :");
				//int empId = Integer.valueOf(scan.nextLine());
				int empId = 0;
				Float temp = 25.0f;
				try{
				empId = Integer.parseInt(args[1]);
				temp = Float.parseFloat(args[2]);
				}catch(Exception e){
					System.out.println("No temp input");
				}
				p.punch("empId"+empId , temp );
				obj.saveData("Organisation", p);
				break;
			case 3:
				System.out.println("Calculating HrsWorked");
				p.calHWOrg();
				obj.saveData("Organisation", p);
				break;
			case 4:
				System.out.println("Calculating Salary");
				p.calSalaryOrg();
				obj.saveData("Organisation", p);
				break;
    		default:
    			System.out.println("Invalid Option");
    			break;
    		
    		//obj.saveData("Organisation", p);
		}
			System.out.print("press 1 to exit");
			int exit= Integer.valueOf(scan.nextLine());
			if(exit ==1){
				System.out.print("exiting");
			}
    	
    }
    
    
    
    
}