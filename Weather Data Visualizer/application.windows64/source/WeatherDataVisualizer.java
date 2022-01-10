import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import controlP5.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class WeatherDataVisualizer extends PApplet {

TemperatureData [] TemperatureDataArray = null;

ControlP5 cp5;
boolean Jan = true;
boolean Feb = true;
boolean Mar = true;
boolean Apr = true;
boolean May = true;
boolean Jun = true;
boolean Jul = true;
boolean Aug = true;
boolean Sep = true;
boolean Oct = true;
boolean Nov = true;
boolean Dec = true;
boolean minTemp = true;
boolean maxTemp = true;
boolean barChart = true;
boolean scatterPlot = false;
boolean sortByYear = false;
int Year = 0;
boolean snowfall = false;
float hotMonths = 0;
float coldMonths = 0;
float tempAvg = 0;
int customTemp = 0;

public void settings(){
  size(1250,600);
}

public void setup (){
  readDataFile();
  cp5=new ControlP5(this);
    
  cp5.addButton("barChart").setValue(0).setPosition(100,20).setSize(70,110);
  cp5.addButton("scatterPlot").setValue(0).setPosition(180,20).setSize(70,110);
  cp5.addToggle("Jan").setValue(1).setPosition(260,20).setSize(30,50);
  cp5.addToggle("Feb").setValue(1).setPosition(300,20).setSize(30,50);
  cp5.addToggle("Mar").setValue(1).setPosition(340,20).setSize(30,50);
  cp5.addToggle("Apr").setValue(1).setPosition(380,20).setSize(30,50);
  cp5.addToggle("May").setValue(1).setPosition(420,20).setSize(30,50);
  cp5.addToggle("Jun").setValue(1).setPosition(460,20).setSize(30,50);
  cp5.addToggle("Jul").setValue(1).setPosition(500,20).setSize(30,50);
  cp5.addToggle("Aug").setValue(1).setPosition(540,20).setSize(30,50);
  cp5.addToggle("Sep").setValue(1).setPosition(580,20).setSize(30,50);
  cp5.addToggle("Oct").setValue(1).setPosition(620,20).setSize(30,50);
  cp5.addToggle("Nov").setValue(1).setPosition(660,20).setSize(30,50);
  cp5.addToggle("Dec").setValue(1).setPosition(700,20).setSize(30,50);
  cp5.addToggle("minTemp").setValue(1).setPosition(260,90).setSize(70,40);
  cp5.addToggle("maxTemp").setValue(1).setPosition(340,90).setSize(70,40);
  cp5.addButton("sortByYear").setValue(0).setPosition(1145,20).setSize(70,50);
  cp5.addButton("Back").setValue(0).setPosition(1145,80).setSize(30,50);
  cp5.addButton("Next").setValue(0).setPosition(1185,80).setSize(30,50);
  cp5.addButton("snowfall").setValue(0).setPosition(1055,20).setSize(70,110);
  cp5.addButton("warmer").setValue(0).setPosition(948,93).setSize(50,30);
  cp5.addButton("colder").setValue(0).setPosition(775,93).setSize(50,30);
  
  barChart = true;
  scatterPlot = false;
  sortByYear = false;
  snowfall = false;
}

public void readDataFile(){
  FileIO file = new FileIO();
  TemperatureDataArray = file.readFile();
}

public void draw(){
  background(0);
  fill(150);
  stroke(255);
  rect(1135, 10, 90, 150);
  fill(255);
  stroke(255);
  rect(1054,19,71,111);
  rect(99,19,71,111);
  rect(179,19,71,111);
  rect(947,92,51,31);
  rect(774,92,51,31);

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// In each of the three "if" statements, the program goes to every month and checks if it's toggle is turned on.
// If so, then it draws either the barChart or scatterPlot for that month every year depending on which is selected.
  if(snowfall == true){
    minTemp = true;
  }
  if(sortByYear == false){
  if(minTemp == true){ // Draws the minTemp to the graph for each month
    fill(0,0,255);
    stroke(0,0,150);
    if(Jan == true){
      for(int i = 0; i < 30; i++){
        if(barChart == true){ // Creates the barChart for January
          rect((3*(12*i))+55,400,3,-8*(TemperatureDataArray[12*i].MinT));
        }
        if(scatterPlot == true){ // Creates the scatterPlot for January
          circle((3*(12*i))+55,400+(-8*(TemperatureDataArray[12*i].MinT)),2.5f);
        }
        if(snowfall == true){
          fill(255);
          stroke(150);
          rect((3*(12*i))+55,400,3,-8*(TemperatureDataArray[12*i].SnowF));
        }
      }
    }
    if(Feb == true){
      for(int i = 0; i < 30; i++){
        if(barChart == true){
          rect((3*((12*i)+1))+55,400,3,-8*(TemperatureDataArray[(12*i)+1].MinT));
        }
        if(scatterPlot == true){
          circle((3*((12*i)+1))+55,400+(-8*(TemperatureDataArray[(12*i)+1].MinT)),2.5f);
        }
        if(snowfall == true){
          fill(255);
          stroke(150);
          rect((3*((12*i)+1))+55,400,3,-8*(TemperatureDataArray[(12*i)+1].SnowF));
        }
      }
    }
    if(Mar == true){
      for(int i = 0; i < 30; i++){
        if(barChart == true){
          rect((3*((12*i)+2))+55,400,3,-8*(TemperatureDataArray[(12*i)+2].MinT));
        }
        if(scatterPlot == true){
          circle((3*((12*i)+2))+55,400+(-8*(TemperatureDataArray[(12*i)+2].MinT)),2.5f);
        }
        if(snowfall == true){
          fill(255);
          stroke(150);
          rect((3*((12*i)+2))+55,400,3,-8*(TemperatureDataArray[(12*i)+2].SnowF));
        }
      }
    }
    if(Apr == true){
      for(int i = 0; i < 30; i++){
        if(barChart == true){
          rect((3*((12*i)+3))+55,400,3,-8*(TemperatureDataArray[(12*i)+3].MinT));
        }
        if(scatterPlot == true){
          circle((3*((12*i)+3))+55,400+(-8*(TemperatureDataArray[(12*i)+3].MinT)),2.5f);
        }
        if(snowfall == true){
          fill(255);
          stroke(150);
          rect((3*((12*i)+3))+55,400,3,-8*(TemperatureDataArray[(12*i)+3].SnowF));
        }
      }
    }
    if(May == true){
      for(int i = 0; i < 30; i++){
        if(barChart == true){
          rect((3*((12*i)+4))+55,400,3,-8*(TemperatureDataArray[(12*i)+4].MinT));
        }
        if(scatterPlot == true){
          circle((3*((12*i)+4))+55,400+(-8*(TemperatureDataArray[(12*i)+4].MinT)),2.5f);
        }
        if(snowfall == true){
          fill(255);
          stroke(150);
          rect((3*((12*i)+4))+55,400,3,-8*(TemperatureDataArray[(12*i)+4].SnowF));
        }
      }
    }
    if(Jun == true){
      for(int i = 0; i < 30; i++){
        if(barChart == true){
          rect((3*((12*i)+5))+55,400,3,-8*(TemperatureDataArray[(12*i)+5].MinT));
        }
        if(scatterPlot == true){
          circle((3*((12*i)+5))+55,400+(-8*(TemperatureDataArray[(12*i)+5].MinT)),2.5f);
        }
        if(snowfall == true){
          fill(255);
          stroke(150);
          rect((3*((12*i)+5))+55,400,3,-8*(TemperatureDataArray[(12*i)+5].SnowF));
        }
      }
    }
    if(Jul == true){
      for(int i = 0; i < 30; i++){
        if(barChart == true){
          rect((3*((12*i)+6))+55,400,3,-8*(TemperatureDataArray[(12*i)+6].MinT));
        }
        if(scatterPlot == true){
          circle((3*((12*i)+6))+55,400+(-8*(TemperatureDataArray[(12*i)+6].MinT)),2.5f);
        }
        if(snowfall == true){
          fill(255);
          stroke(150);
          rect((3*((12*i)+6))+55,400,3,-8*(TemperatureDataArray[(12*i)+6].SnowF));
        }
      }
    }
    if(Aug == true){
      for(int i = 0; i < 30; i++){
        if(barChart == true){
          rect((3*((12*i)+7))+55,400,3,-8*(TemperatureDataArray[(12*i)+7].MinT));
        }
        if(scatterPlot == true){
          circle((3*((12*i)+7))+55,400+(-8*(TemperatureDataArray[(12*i)+7].MinT)),2.5f);
        }
        if(snowfall == true){
          fill(255);
          stroke(150);
          rect((3*((12*i)+7))+55,400,3,-8*(TemperatureDataArray[(12*i)+7].SnowF));
        }
      }
    }
    if(Sep == true){
      for(int i = 0; i < 30; i++){
        if(barChart == true){
          rect((3*((12*i)+8))+55,400,3,-8*(TemperatureDataArray[(12*i)+8].MinT));
        }
        if(scatterPlot == true){
          circle((3*((12*i)+8))+55,400+(-8*(TemperatureDataArray[(12*i)+8].MinT)),2.5f);
        }
        if(snowfall == true){
          fill(255);
          stroke(150);
          rect((3*((12*i)+8))+55,400,3,-8*(TemperatureDataArray[(12*i)+8].SnowF));
        }
      }
    }
    if(Oct == true){
      for(int i = 0; i < 30; i++){
        if(barChart == true){
          rect((3*((12*i)+9))+55,400,3,-8*(TemperatureDataArray[(12*i)+9].MinT));
        }
        if(scatterPlot == true){
          circle((3*((12*i)+9))+55,400+(-8*(TemperatureDataArray[(12*i)+9].MinT)),2.5f);
        }
        if(snowfall == true){
          fill(255);
          stroke(150);
          rect((3*((12*i)+9))+55,400,3,-8*(TemperatureDataArray[(12*i)+9].SnowF));
        }
      }
    }
    if(Nov == true){
      for(int i = 0; i < 30; i++){
        if(barChart == true){
          rect((3*((12*i)+10))+55,400,3,-8*(TemperatureDataArray[(12*i)+10].MinT));
        }
        if(scatterPlot == true){
          circle((3*((12*i)+10))+55,400+(-8*(TemperatureDataArray[(12*i)+10].MinT)),2.5f);
        }
        if(snowfall == true){
          fill(255);
          stroke(150);
          rect((3*((12*i)+10))+55,400,3,-8*(TemperatureDataArray[(12*i)+10].SnowF));
        }
      }
    }
    if(Dec == true){
      for(int i = 0; i < 29; i++){
        if(barChart == true){
          rect((3*((12*i)+11))+55,400,3,-8*(TemperatureDataArray[(12*i)+11].MinT));
        }
        if(scatterPlot == true){
          circle((3*((12*i)+11))+55,400+(-8*(TemperatureDataArray[(12*i)+11].MinT)),2.5f);
        }
        if(snowfall == true){
          fill(255);
          stroke(150);
          rect((3*((12*i)+11))+55,400,3,-8*(TemperatureDataArray[(12*i)+11].SnowF));
        }
      }
    }
    stroke(255);
  }
  
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
  
  if(maxTemp == true){ // Draws the maxTemp to the graph for each month
    fill(255,0,0);
    stroke(150,0,0);
    if(Jan == true){
      for(int i = 0; i < 30; i++){
        if(barChart == true){
          rect((3*(12*i))+55,400,3,-8*(TemperatureDataArray[12*i].MaxT));
        }
        if(scatterPlot == true){
          circle((3*(12*i))+55,400+(-8*(TemperatureDataArray[12*i].MaxT)),2.5f);
        }
      }
    }
    if(Feb == true){
      for(int i = 0; i < 30; i++){
        if(barChart == true){
          rect((3*((12*i)+1))+55,400,3,-8*(TemperatureDataArray[(12*i)+1].MaxT));
        }
        if(scatterPlot == true){
          circle((3*((12*i)+1))+55,400+(-8*(TemperatureDataArray[(12*i)+1].MaxT)),2.5f);
        }
      }
    }
    if(Mar == true){
      for(int i = 0; i < 30; i++){
        if(barChart == true){
          rect((3*((12*i)+2))+55,400,3,-8*(TemperatureDataArray[(12*i)+2].MaxT));
        }
        if(scatterPlot == true){
          circle((3*((12*i)+2))+55,400+(-8*(TemperatureDataArray[(12*i)+2].MaxT)),2.5f);
        }
      }
    }
    if(Apr == true){
      for(int i = 0; i < 30; i++){
        if(barChart == true){
          rect((3*((12*i)+3))+55,400,3,-8*(TemperatureDataArray[(12*i)+3].MaxT));
        }
        if(scatterPlot == true){
          circle((3*((12*i)+3))+55,400+(-8*(TemperatureDataArray[(12*i)+3].MaxT)),2.5f);
        }
      }
    }
    if(May == true){
      for(int i = 0; i < 30; i++){
        if(barChart == true){
          rect((3*((12*i)+4))+55,400,3,-8*(TemperatureDataArray[(12*i)+4].MaxT));
        }
        if(scatterPlot == true){
          circle((3*((12*i)+4))+55,400+(-8*(TemperatureDataArray[(12*i)+4].MaxT)),2.5f);
        }
      }
    }
    if(Jun == true){
      for(int i = 0; i < 30; i++){
        if(barChart == true){
          rect((3*((12*i)+5))+55,400,3,-8*(TemperatureDataArray[(12*i)+5].MaxT));
        }
        if(scatterPlot == true){
          circle((3*((12*i)+5))+55,400+(-8*(TemperatureDataArray[(12*i)+5].MaxT)),2.5f);
        }
      }
    }
    if(Jul == true){
      for(int i = 0; i < 30; i++){
        if(barChart == true){
          rect((3*((12*i)+6))+55,400,3,-8*(TemperatureDataArray[(12*i)+6].MaxT));
        }
        if(scatterPlot == true){
          circle((3*((12*i)+6))+55,400+(-8*(TemperatureDataArray[(12*i)+6].MaxT)),2.5f);
        }
      }
    }
    if(Aug == true){
      for(int i = 0; i < 30; i++){
        if(barChart == true){
          rect((3*((12*i)+7))+55,400,3,-8*(TemperatureDataArray[(12*i)+7].MaxT));
        }
        if(scatterPlot == true){
          circle((3*((12*i)+7))+55,400+(-8*(TemperatureDataArray[(12*i)+7].MaxT)),2.5f);
        }
      }
    }
    if(Sep == true){
      for(int i = 0; i < 30; i++){
        if(barChart == true){
          rect((3*((12*i)+8))+55,400,3,-8*(TemperatureDataArray[(12*i)+8].MaxT));
        }
        if(scatterPlot == true){
          circle((3*((12*i)+8))+55,400+(-8*(TemperatureDataArray[(12*i)+8].MaxT)),2.5f);
        }
      }
    }
    if(Oct == true){
      for(int i = 0; i < 30; i++){
        if(barChart == true){
          rect((3*((12*i)+9))+55,400,3,-8*(TemperatureDataArray[(12*i)+9].MaxT));
        }
        if(scatterPlot == true){
          circle((3*((12*i)+9))+55,400+(-8*(TemperatureDataArray[(12*i)+9].MaxT)),2.5f);
        }
      }
    }
    if(Nov == true){
      for(int i = 0; i < 30; i++){
        if(barChart == true){
          rect((3*((12*i)+10))+55,400,3,-8*(TemperatureDataArray[(12*i)+10].MaxT));
        }
        if(scatterPlot == true){
          circle((3*((12*i)+10))+55,400+(-8*(TemperatureDataArray[(12*i)+10].MaxT)),2.5f);
        }
      }
    }
    if(Dec == true){
      for(int i = 0; i < 29; i++){
        if(barChart == true){
          rect((3*((12*i)+11))+55,400,3,-8*(TemperatureDataArray[(12*i)+11].MaxT));
        }
        if(scatterPlot == true){
          circle((3*((12*i)+11))+55,400+(-8*(TemperatureDataArray[(12*i)+11].MaxT)),2.5f);
        }
      }
    }
    stroke(255);
  }
  
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  if(minTemp == true && barChart == true){ // Re-draws the area of minTemp that is covered up by maxTemp
    fill(0,0,255);
    stroke(0,0,150);
    if(Jan == true){
      for(int i = 0; i < 30; i++){
        if(TemperatureDataArray[12*i].MinT > 0){
          rect((3*(12*i))+55,400,3,-8*(TemperatureDataArray[(12*i)].MinT));
        }
      }
    }
    if(Feb == true){
      for(int i = 0; i < 30; i++){
        if(TemperatureDataArray[(12*i)+1].MinT > 0){
          rect((3*((12*i)+1))+55,400,3,-8*(TemperatureDataArray[(12*i)+1].MinT));
        }
      }
    }
    if(Mar == true){
      for(int i = 0; i < 30; i++){
        if(TemperatureDataArray[(12*i)+2].MinT > 0){
          rect((3*((12*i)+2))+55,400,3,-8*(TemperatureDataArray[(12*i)+2].MinT));
        }
      }
    }
    if(Apr == true){
      for(int i = 0; i < 30; i++){
        if(TemperatureDataArray[(12*i)+3].MinT > 0){
          rect((3*((12*i)+3))+55,400,3,-8*(TemperatureDataArray[(12*i)+3].MinT));
        }
      }
    }
    if(May == true){
      for(int i = 0; i < 30; i++){
        if(TemperatureDataArray[(12*i)+4].MinT > 0){
          rect((3*((12*i)+4))+55,400,3,-8*(TemperatureDataArray[(12*i)+4].MinT));
        }
      }
    }
    if(Jun == true){
      for(int i = 0; i < 30; i++){
        if(TemperatureDataArray[(12*i)+5].MinT > 0){
          rect((3*((12*i)+5))+55,400,3,-8*(TemperatureDataArray[(12*i)+5].MinT));
        }
      }
    }
    if(Jul == true){
      for(int i = 0; i < 30; i++){
        if(TemperatureDataArray[(12*i)+6].MinT > 0){
          rect((3*((12*i)+6))+55,400,3,-8*(TemperatureDataArray[(12*i)+6].MinT));
        }
      }
    }
    if(Aug == true){
      for(int i = 0; i < 30; i++){
        if(TemperatureDataArray[(12*i)+7].MinT > 0){
          rect((3*((12*i)+7))+55,400,3,-8*(TemperatureDataArray[(12*i)+7].MinT));
        }
      }
    }
    if(Sep == true){
      for(int i = 0; i < 30; i++){
        if(TemperatureDataArray[(12*i)+8].MinT > 0){
          rect((3*((12*i)+8))+55,400,3,-8*(TemperatureDataArray[(12*i)+8].MinT));
        }
      }
    }
    if(Oct == true){
      for(int i = 0; i < 30; i++){
        if(TemperatureDataArray[(12*i)+9].MinT > 0){
          rect((3*((12*i)+9))+55,400,3,-8*(TemperatureDataArray[(12*i)+9].MinT));
        }
      }
    }
    if(Nov == true){
      for(int i = 0; i < 30; i++){
        if(TemperatureDataArray[(12*i)+10].MinT > 0){
          rect((3*((12*i)+10))+55,400,3,-8*(TemperatureDataArray[(12*i)+10].MinT));
        }
      }
    }
    if(Dec == true){
      for(int i = 0; i < 29; i++){
        if(TemperatureDataArray[(12*i)+11].MinT > 0){
          rect((3*((12*i)+11))+55,400,3,-8*(TemperatureDataArray[(12*i)+11].MinT));
        }
      }
    }
  }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
  
  }
  if(sortByYear == true){
    fill(0,0,255);
    stroke(0,0,150);
    for(int i = Year*12; i < (Year*12)+12; i++){
      if(i < 359){
        rect((3*(i))+55,400,3,-8*(TemperatureDataArray[i].MinT));
      }
    }
    fill(255,0,0);
    stroke(150,0,0);
    for(int i = Year*12; i < (Year*12)+12; i++){
      if(i < 359){
        rect((3*(i))+55,400,3,-8*(TemperatureDataArray[i].MaxT));
      }
    }
    fill(0,0,255);
    stroke(0,0,150);
    for(int i = Year*12; i < (Year*12)+12; i++){
      if(i < 359){
        if(TemperatureDataArray[i].MinT > 0){
           rect((3*(i))+55,400,3,-8*(TemperatureDataArray[i].MinT));
        }
      }
    }
    fill(0);
    text(Year+1990,1164,150);
    fill(255,0,0);
    text("The highest average temperature of "+(Year+1990)+" was "+TemperatureDataArray[(12*Year)+6].MaxT+"ºC in July.", 62, 565);
    fill(0,0,255);
    text("The lowest average temperature of "+(Year+1990)+" was "+TemperatureDataArray[(12*Year)].MinT+"ºC in January.", 62, 585);
  }
  else{
    fill(0);
    text("----",1166,150);
  }
  
  if(snowfall == false){
    axis();
  }
  else{
    snowAxis();
  }

  float[] angles = {(hotMonths/12)*360, (coldMonths/12)*360};
  pieChart(100,angles);
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
public void axis(){ // Draws the x/y axis and it's labels
  fill(255);
  stroke(255);
  line(50,0,50,600); // X
  line(50,400,1250,400); // Y
  text("5",30,360);
  text("10",30,320);
  text("15",30,280);
  text("20",30,240);
  text("25",30,200);
  text("-5",25,440);
  text("-10",25,480);
  text("-15",25,520);
  text("1991",75,420);
  text("1993",147,420);
  text("1995",219,420);
  text("1997",291,420);
  text("1999",363,420);
  text("2001",435,420);
  text("2003",507,420);
  text("2005",579,420);
  text("2007",651,420);
  text("2009",723,420);
  text("2011",795,420);
  text("2013",867,420);
  text("2015",939,420);
  text("2017",1011,420);
  text("2019",1083,420);
  text("ºC",10,400);
}

public void snowAxis(){
  fill(255);
  stroke(255);
  line(50,0,50,600);
  line(50,400,1250,400);
  text("5",30,360);
  text("10",30,320);
  text("15",30,280);
  text("20",30,240);
  text("25",30,200);
  text("1991",75,420);
  text("1993",147,420);
  text("1995",219,420);
  text("1997",291,420);
  text("1999",363,420);
  text("2001",435,420);
  text("2003",507,420);
  text("2005",579,420);
  text("2007",651,420);
  text("2009",723,420);
  text("2011",795,420);
  text("2013",867,420);
  text("2015",939,420);
  text("2017",1011,420);
  text("2019",1083,420);
  text("cm",10,400);
}
    
public void barChart(){ // Changes from scatterPlot to barChart when the button is pressed
  barChart = true;
  scatterPlot = false;
  snowfall = false;
  sortByYear = false;
}

public void scatterPlot(){ // Changes from barChart to scatterPlot when the button is pressed
  barChart = false;
  scatterPlot = true;
  snowfall = false;
  sortByYear = false;
}

public void snowfall(){
  barChart = false;
  scatterPlot = false;
  snowfall = true;
  sortByYear = false;
}

public void sortByYear(){ // Changes to year view
  barChart = false;
  scatterPlot = false;
  snowfall = false;
  sortByYear = true;
}

public void Next(){
  if(Year < 29){
    Year++;
  }
  else{
    Year = 0;
  }
}

public void Back(){
  if(Year > 0){
    Year--;
  }
  else{
    Year = 29;
  }
}

public void pieChart(float diameter, float[] data) {
  float lastAngle = 0;
  for (int i = 0; i < data.length; i++) {
    if (i==0){
      fill(255,0,0);
      text("Number of months warmer than "+customTemp+"ºC = "+PApplet.parseInt(hotMonths),768,145);
    }
    else{
      fill(0,0,255);
      text("Number of months colder than "+customTemp+"ºC = "+PApplet.parseInt(coldMonths),768,165);
    }
    arc(886, 75, diameter, diameter, lastAngle, lastAngle+radians(data[i]));
    lastAngle += radians(data[i]);
  }
}

public void warmer(){
  customTemp++;
  hotMonths = 0;
  coldMonths = 0;
  checkTemp();
}

public void colder(){
  customTemp--;
  hotMonths = 0;
  coldMonths = 0;
  checkTemp();
}

public void checkTemp(){
  for(int month = 0; month < 12; month++){
    for(int year = 0; year < 29; year++){
      tempAvg += ((TemperatureDataArray[(12*year)+month].MinT)+(TemperatureDataArray[(12*year)+month].MaxT))/2;
    }
    tempAvg /= 29;
    if(tempAvg >= customTemp){
      hotMonths++;
    }
    else{
      coldMonths++;
    }
    tempAvg = 0;
  }
}
class Date{
  int Y;
  int M;

Date (int a, int b){
    Y = a;
    M = b;
  }
}
class FileIO{
   Table table;
  
   FileIO (){
     table = loadTable ("CalgaryWeather.csv", "header");
   }
   
   public TemperatureData [] readFile(){
    
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
   public Date [] ReadFile(){
    
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
class TemperatureData{
  
  int X;
  float MaxT;
  float MinT;
  float SnowF;
  
  TemperatureData (int a, float max, float min, float snow){
    X = a;
    MaxT = max;
    MinT = min;
    SnowF = snow;  
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "WeatherDataVisualizer" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
