import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class pde extends PApplet {

//obiekty
Brush[] buttons = {
  new Brush(1,50,550,20),
  new Brush(2,102,550,15),
  new Brush(3,154,550,10),
  new Brush(4,206,550,5),
  new Brush(5,258,550,3)
};

Cursor crs = new Cursor();

//zmienne
int menuBarSize = 100;
int selectedButton = 0;
  //1 - brush size 20
  //2 - brush size 15 etc

//setup
public void setup(){
  
}

//draw
public void draw(){
  for(int z = 0; z < 5; z++){
    buttons[z].drawSelf();
  }
}

public void mouseDragged(){
  fill(0);
  ellipse(mouseX, mouseY, buttons[crs.selectedSize].size, buttons[crs.selectedSize].size);
}

public void mouseClicked(){
  if(mouseY>=550){
    crs.selectedSize = (mouseX-50)/52;
  }
}

class Cursor{

  int selectedSize = 0;

  //Cursor(Buttons )

}

class Buttons{ //wszystkie opcje

  int posx;
  int posy;
  int id;

}

class Brush extends Buttons{

  int size;

  Brush(int pid, int pposx, int pposy, int psize){
    id = pid;
    size = psize;
    posx = pposx;
    posy = pposy;
  }

  public void drawSelf(){
    fill(255);
    rect(posx,posy,50,25);
    ellipse(posx+25,posy+12.5f,size,size);
  }

  public void action(){


  }
}

class save extends Buttons{

  public void action(){
    frame.setSize(width, height - menuBarSize);
    save("lol.png");
    frame.setSize(width, height + menuBarSize);
  }

}
  public void settings() {  size(800,600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "pde" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
