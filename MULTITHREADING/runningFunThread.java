package JavaSyugyou0719;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class runningFunThread extends Application{
	public void start(Stage arg0) throws Exception {
		FanPane fan=new FanPane();
		HBox hBox = new HBox(5);
	    Button btPause = new Button("Pause");
	    Button btResume = new Button("Resume");
	    Button btReverse = new Button("Reverse");
	    hBox.setAlignment(Pos.CENTER);
	    hBox.getChildren().addAll(btPause, btResume, btReverse);
	    
	    BorderPane pane = new BorderPane();
	    pane.setCenter(fan);
	    pane.setBottom(hBox);
	    
	    Scene scene=new Scene(pane,200,200);
	    arg0.setTitle("RF_Thread");
	    arg0.setScene(scene);
	    arg0.show();
	    
	    scene.widthProperty().addListener(e -> fan.setW(fan.getWidth()));
	    scene.heightProperty().addListener(e -> fan.setH(fan.getHeight()));
	    
	    btPause.setOnAction(e -> fan.pause());
	    btResume.setOnAction(e -> fan.play());
	    btReverse.setOnAction(e -> fan.reverse());
	}
	public static void main(String[] args) {
		launch(args);
	}
}















































































