package JavaSyugyou0719;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/*
 * new Image("file:C:/Users/Ethan/workspace/image/card/"+list.get(0)+".png")
 */

public class runingFan extends Application{
	public void start(Stage arg0) throws Exception {
		FanPane fan=new FanPane();
		HBox hBox=new HBox(5);
		Button btPause=new Button("Pause");
		Button btResume=new Button("Resume");
		Button btReverse=new Button("Reverse");
		
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(btPause, btResume,btReverse);
		
		BorderPane pane=new BorderPane();
		pane.setCenter(fan);
		pane.setBottom(hBox);
		
		Scene scene=new Scene(pane,200,250);
		arg0.setTitle("Running Fan");
		arg0.setScene(scene);
		arg0.show();
		
		Timeline ani=new Timeline(
			new KeyFrame(Duration.millis(100),
			e->fan.move()));
		ani.setCycleCount(Timeline.INDEFINITE);
		ani.play();
		
		scene.widthProperty().addListener(e->fan.setW(fan.getWidth()));
		scene.heightProperty().addListener(e->fan.setH(fan.getHeight()));
		
		btPause.setOnAction(e->ani.pause());
		btResume.setOnAction(e->ani.play());
		btReverse.setOnAction(e->fan.reverse());
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}


































































