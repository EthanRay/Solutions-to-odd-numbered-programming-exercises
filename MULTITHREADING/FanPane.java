package JavaSyugyou0719;

import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;

public class FanPane extends Pane{
	private double w = 200;
	private double h = 200;
	private double radius = Math.min(w, h) * 0.45;
	private Arc arc[]=new Arc[4];
	private double startAngle=30;
	private Circle circle=new Circle(w/2,h/2,radius);
	
	private int sleepTime=50;
	private Thread thread=new Thread(()->{
		 try {
		      while (true) {
		        Platform.runLater(() -> move());
		        Thread.sleep(sleepTime);
		      }
		    }
		    catch (InterruptedException ex) {
		    }
	});
	
	
	public FanPane() {
		circle.setStroke(Color.BLACK);
		circle.setFill(Color.WHITE);
		
		getChildren().add(circle);
		 for (int i = 0; i < 4; i++) {
		      arc[i] = new Arc(w / 2, h / 2, radius * 0.9, radius * 0.9, startAngle + i * 90, 35);
		      arc[i].setFill(Color.RED); // Set fill color
		      arc[i].setType(ArcType.ROUND);
		      getChildren().addAll(arc[i]); 
		    } 
		 thread.start();
	}
	
	private double increment = 5;
	  
	  public void reverse() {
	    increment = -increment;
	  }
	  
	  public void move() {
	    setStartAngle(startAngle + increment);
	  }
	    
	  public void setStartAngle(double angle) {
	    startAngle = angle;
	    setValues();
	  }
	  
	  public void setValues() {
	    radius = Math.min(w, h) * 0.45;
	    circle.setRadius(radius);
	    circle.setCenterX(w / 2);
	    circle.setCenterY(h / 2);
	         
	    for (int i = 0; i < 4; i++) {
	      arc[i].setRadiusX(radius * 0.9);
	      arc[i].setRadiusY(radius * 0.9);
	      arc[i].setCenterX(w / 2);
	      arc[i].setCenterY(h / 2);
	      arc[i].setStartAngle(startAngle + i * 90);
	    }     
	  }
	  
	  public void setW(double w) {
	    this.w = w;
	    setValues();
	  }
	  
	  public void setH(double h) {
	    this.h = h;
	    setValues();
	  }

	@SuppressWarnings("deprecation")
	public void pause() {
		thread.suspend();
	}

	public void play() {
		thread.resume();
	}
}
