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
    	
    		int choice=0;
    		//System.out.println("1. Add Employee");
    		//System.out.println("2. Punch Attendance");
			//choice = Integer.valueOf(scan.nextLine());
			choice = args[0].equals("id") ? 2 : 1;
    		switch(choice) {
    		case 1:
    			System.out.print("Name :");
    			String name = scan.nextLine();
    			System.out.print("Age :");
    			int age = Integer.valueOf(scan.nextLine());
    			System.out.print("OverTimeRate :");
    			float ovrTimeR = Float.valueOf(scan.nextLine());
    			System.out.print("Salary Per Day :");
    			float SalaryPerDay = Float.valueOf(scan.nextLine());
    			obj.addEmptoOrg(p, name , age  , ovrTimeR , SalaryPerDay);
    			obj.saveData("Organisation", p);
    			break;
    		case 2:
    			System.out.print("Enter Emp Id :");
    			//int empId = Integer.valueOf(scan.nextLine());
    			int empId = Integer.parseInt(args[1]);
    			p.punch("empId"+empId);
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