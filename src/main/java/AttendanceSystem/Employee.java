package AttendanceSystem;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Employee{
    public String name;
    public int age;
    public String empId;
    public float overtimeRate;
    public float salaryPerDay;
    //protected Date inTime;
    public long inTimeStr;
    //protected Date outTime;
    public long outTimeStr;
    public Boolean isWorking;
    public List<Long> inTimeList;
    public List<Long> outTimeList;
	public List<Long> hrsWorked;
	public HashMap<String,Float> temperatureList;
	public float temperature;
  //  public int workingHrs;
	private long startDay;
	   // public int totalDays;
    public int totalHrsWorked;
  //  public int overTimeHrs;
    public float salary;
  //  public int daysWorked;

    Employee(String name, int age, String empId , float overtimeRate, float salaryPerDay){
        this.name = name;
        this.age = age;
        this.empId = empId;
        this.overtimeRate = overtimeRate;
        this.salaryPerDay = salaryPerDay;
        isWorking = false;
        inTimeList = new ArrayList<Long>();
        outTimeList = new ArrayList<Long>();
		hrsWorked = new ArrayList<Long>();
		temperatureList = new HashMap<String,Float>();
 //       workingHrs = 8;
        startDay = new Date().getTime();
    }
    
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public float getOvertimeRate() {
		return overtimeRate;
	}

	public void setOvertimeRate(float overtimeRate) {
		this.overtimeRate = overtimeRate;
	}

	public float getSalaryPerDay() {
		return salaryPerDay;
	}

	public void setSalaryPerDay(float salaryPerDay) {
		this.salaryPerDay = salaryPerDay;
	}

	public Boolean getIsWorking() {
		return isWorking;
	}

	public void setIsWorking(Boolean isWorking) {
		this.isWorking = isWorking;
	}

	public List<Long> getInTimeList() {
		return inTimeList;
	}

	public void setInTimeList(List<Long> inTimeList) {
		this.inTimeList = inTimeList;
	}

	public List<Long> getOutTimeList() {
		return outTimeList;
	}

	public void setOutTimeList(List<Long> outTimeList) {
		this.outTimeList = outTimeList;
	}

	public List<Long> getHrsWorked() {
		return hrsWorked;
	}

	public void setHrsWorked(List<Long> hrsWorked) {
		this.hrsWorked = hrsWorked;
	}

	public Long getStartDay() {
		return startDay;
	}

	public void setStartDay(Long startDay) {
		this.startDay = startDay;
	}

	public void setTemperature(Float temperature){
		temperatureList = new HashMap<String,Float>();
		temperatureList.put(new Date().toString(), temperature);
	}
	public float getTemperature(){
		return temperature;
	}

	public HashMap<String,Float> getTemperatureList() {
		return temperatureList;
	}

	public void setTemperatureList(HashMap<String,Float> temperatureList) {
		this.temperatureList = temperatureList;
	}
	public float getSalary() {
		return salary;
	}

	public void setSalary() {
		this.salary = totalHrsWorked*salaryPerDay;
	}

   
    public boolean attendancePunch(Float temp) {
    	if(isWorking) {
    		//exit
    		Date outTime = new Date();
    		outTimeStr = outTime.getTime();
			outTimeList.add(outTimeStr);
			temperatureList.put(outTime.toString(), temp);
    		isWorking = false;
    		System.out.println(name + " | Out Time :" + outTime.toString());
    	}else {
    		Date inTime = new Date();
    		inTimeStr = inTime.getTime();
			inTimeList.add(inTimeStr);
			temperatureList.put(inTime.toString(), temp);
    		isWorking = true;
    		System.out.println(name + " | In Time :" + inTime.toString());
		}
		temperature = temp;
    	return isWorking;
    }
    
    public void getHrs(int index) {
		
		hrsWorked = new ArrayList<Long>();
		
		long diff = 0;
		diff = outTimeList.get(index) - inTimeList.get(index);
		long diffHours = diff / (60 * 60 * 1000);
		System.out.println(diffHours);
    	
		hrsWorked.add(diffHours);
		//System.out.println(diff);
		
	}
	
	public void calHrsWorked(){
		int count = outTimeList.size() < inTimeList.size() ? outTimeList.size() : inTimeList.size(); 
		System.out.println(count);
		for(int i =0 ; i < count ; i++){
			
			getHrs(i);
		}
	}


	public void getTotalHrs() {
		totalHrsWorked =0;
		for(int i =0 ; i< hrsWorked.size() ; i++){
    	     totalHrsWorked  = totalHrsWorked +  Integer.parseInt(hrsWorked.get(i).toString());
		}
    } 
    
    
