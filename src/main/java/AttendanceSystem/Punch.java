package AttendanceSystem;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class Punch{

    String name;
    String temperature;
    String Id;
    long EpochTime;


    Punch(String name, String temperature, String Id){
        this.name = name;
        this.Id = Id;
        this.temperature = temperature;
        this.EpochTime = new Date().getTime();
    }

    void setName(String name) { this.name = name; } 
    String getName() { return this.name; }
    void setTemperature(String temperature) { this.temperature = temperature; } 
    String getTemperature() { return this.temperature; }
    void setId(String Id) { this.Id = Id; } 
    String getId() { return this.Id; }
    void setEpochTime(long EpochTime) { this.EpochTime = EpochTime; } 
    long getEpochTime() { return this.EpochTime; }


}