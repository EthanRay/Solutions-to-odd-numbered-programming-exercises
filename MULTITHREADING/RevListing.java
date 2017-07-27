package JavaSyugyou0719;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class RevListing extends Application{
	private TextArea taArea=new TextArea();
	public void start(Stage arg0){
		taArea.setWrapText(true);
		Thread pA=new Thread(new PrintChar('a', 100));
		Thread pB=new Thread(new PrintChar('b', 100));
		Thread p100=new Thread(new PrintNum(100));
		
		p100.start();
		pA.start();
		pB.start();
		
		Scene scene=new Scene(taArea, 250, 100);
		arg0.setTitle("Concurrent Output");
		arg0.setScene(scene);
		arg0.show();
	}
	
	class PrintChar implements Runnable{
		private char charToPrint;
		private int times;
		
		public PrintChar(char c,int t) {
			charToPrint=c;
			this.times=t;
		}
		
		public void run() {
			for (int i = 0; i < times; i++) {
				taArea.appendText(charToPrint+"");
			}
		}
	}
	class PrintNum implements Runnable{
		private int lastNum;
		public PrintNum(int i) {
			lastNum=i;
		}
		public void run() {
			for(int i=1;i<=lastNum;++i)
				taArea.appendText(" "+i);
		}
		
	}
}






































































