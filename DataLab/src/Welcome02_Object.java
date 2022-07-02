import java.util.ArrayList;
import java.util.Scanner;

import core.data.*;

public class Welcome02_Object {
   public static void main(String[] args) {
	   DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/index.xml").load();
	      ArrayList<WeatherStation> allstns = ds.fetchList("WeatherStation", "station/station_name", 
	             "station/station_id", "station/state",
	             "station/latitude", "station/longitude");
	      System.out.println("Total stations: " + allstns.size());
	      
	      Scanner sc = new Scanner(System.in);
	      System.out.println("Enter a state abbreviation: ");
	      String state = sc.next();
	      System.out.println("Stations in " + state);
      String id1 = "KATL";
      DataSource ds1 = DataSource.connect("http://weather.gov/xml/current_obs/" + id1 + ".xml"); 
      ds1.setCacheTimeout(15 * 60);  
      ds1.load();
      //ds1.printUsageString();

      Observation ob1 = ds1.fetch("Observation", "weather", "temp_f", "wind_degrees");
      System.out.println(id1 + ": " + ob1);
      
      String id2 = "KSAV";
      DataSource ds2 = DataSource.connect("http://weather.gov/xml/current_obs/" + id2 + ".xml"); 
      ds2.setCacheTimeout(15 * 60);  
      ds2.load();
      
      Observation ob2 = ds2.fetch("Observation", "weather", "temp_f", "wind_degrees");
      System.out.println(id2 + ": " + ob2);
      
      if (ob1.colderThan(ob2)) {
         System.out.println("Colder at " + id1);
      } else {
         System.out.println("Colder at " + id2);
      }
      
      //ds.load();
      Observation coldest = ob1;
      WeatherStation coldestWS=ds.fetch("WeatherStation", "station/station_name", 
              "station/station_id", state,
              "station/latitude", "station/longitude");
      
     
       
       for(WeatherStation ws : allstns) {
    	   id1 = ws.getId();
           ds1 = DataSource.connect("http://weather.gov/xml/current_obs/" + id1 + ".xml");   
           ds1.load();
           if(ds1.isConnected()) {
        	   ob1 = ds1.fetch("Observation", "weather", "temp_f", "wind_degrees");
           }
           
           
           if(ob1.colderThan(coldest)) {
        	   coldest=ob1;
        	   coldestWS=ws;
           }
           
           
       }
       
      System.out.println(coldestWS.getId()+" is the coldest in "+state);
       
      
      
   }
}


/* Represents a weather observation */
class Observation {
   float temp;    // in fahrenheit
   int windDir;   // in degrees
   String description;
   
   Observation(String description, float temp, int windDir) {
      this.description = description;
      this.temp = temp;
      this.windDir = windDir;
   }
   
   /* determine if the temperature of this observation is colder than 'that's */
   public boolean colderThan(Observation that) {
      return this.temp < that.temp;
   }
   
   /* produce a string describing this observation */
   public String toString() {
      return (temp + " degrees; " + description + " (wind: " + windDir + " degrees)");
   }
}