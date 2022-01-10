class FileIO{
   Table table;
  
   FileIO (){
     table = loadTable ("CalgaryWeather.csv", "header");
   }
   
   TemperatureData [] readFile(){
    
     TemperatureData [] TemperatureDataArray = null;
     int i = 0;
     for (TableRow row : table.rows()) {
     Date r1=new Date(row.getInt("Year"),row.getInt("Month"));

       TemperatureData d = new TemperatureData (r1.M,row.getFloat("Max Temperature"),row.getFloat("Min Temperature"),row.getFloat("Snow Fall"));
       
       if (TemperatureDataArray == null)
         TemperatureDataArray = new TemperatureData [1];
       else
         TemperatureDataArray = (TemperatureData []) expand(TemperatureDataArray, TemperatureDataArray.length+1);
         
       TemperatureDataArray[i] = d;
        i++;
     }
     return TemperatureDataArray;
   }
   Date [] ReadFile(){
    
     Date [] dateArray = null;
     int i = 0;
     for (TableRow row : table.rows()) {
       
       Date d = new Date (row.getInt("Year"), row.getInt("Month"));
       if (dateArray == null)
         dateArray = new Date [1];
       else
         dateArray = (Date []) expand(dateArray, dateArray.length+1);
         
        dateArray[i] = d;
        i++;
     }
     return dateArray;
   }
}
