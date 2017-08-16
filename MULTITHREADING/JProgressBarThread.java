package JavaSyugyou0814;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class usingJProgressBar extends JApplet implements Runnable{
	boolean isStandalone=false;
	JProgressBar jProgressBar1=new JProgressBar();
	FlowLayout flowLayout1=new FlowLayout();
	int num=0;
	Thread thread;
	
	public static void main(String[] args) {
		usingJProgressBar applet=new usingJProgressBar();
		applet.isStandalone=true;
		JFrame frame = new JFrame();
	    frame.setTitle("Exercise29_12");
	    frame.add(applet, BorderLayout.CENTER);
	    applet.init();
	    applet.start();
	    frame.setSize(400,320);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null); // Center the frame
	    frame.setVisible(true);
	}
	
	public void init() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jbInit() {
		setSize(new Dimension(400,300));
		setLayout(flowLayout1);
		add(jProgressBar1, null);
		
		thread=new Thread(this);
		thread.start();
	}
	
	public void run() {
		while (true) {
			try {
				num++;
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			jProgressBar1.setValue((int)(num));
		}
	}

}


























































