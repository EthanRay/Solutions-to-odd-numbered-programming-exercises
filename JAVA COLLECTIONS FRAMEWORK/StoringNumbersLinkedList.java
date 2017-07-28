package JavaSyugyou0721;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StoringNumbersLinkedList extends JApplet{
	private LinkedList list = new LinkedList();
	  private JTextField jtfNumber = new JTextField(8);
	  private JTextArea jtaNumbers = new JTextArea();
	  private JButton jbtSort = new JButton("Sort");
	  private JButton jbtShuffle = new JButton("Shuffle");
	  private JButton jbtReverse = new JButton("Reverse");
	  
	  public StoringNumbersLinkedList() {
		  JPanel panel=new JPanel();
		  panel.add(new JLabel("Enter a number:"));
		  panel.add(jtfNumber);
		  
		  JScrollPane jsp=new JScrollPane(jtaNumbers);
		  JPanel panel2=new JPanel();
		  panel2.add(jbtSort);
		  panel2.add(jbtShuffle);
		  panel2.add(jbtReverse);
		  
		  add(panel,BorderLayout.NORTH);
		  add(jsp,BorderLayout.CENTER);
		  add(panel2,BorderLayout.SOUTH);
		  
		  jtfNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!list.contains(new Integer(jtfNumber.getText()))) {
					jtaNumbers.append(jtfNumber.getText()+" ");
					list.add(new Integer(jtfNumber.getText()));
				}
			}
		});
		  
		  jbtSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Collections.sort(list);
				display();
			}
		});
		  
		  jbtShuffle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Collections.shuffle(list);
				display();
			}
		});
		  jbtReverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Collections.reverse(list);
				display();
			}
		});
	  }
	   
	  private void display() {
		jtaNumbers.setText(null);
		ListIterator iterator=list.listIterator();
		while (iterator.hasNext()) {
			jtaNumbers.append(iterator.next()+" ");
		}
	}
	  
	  public static void showStroing() {
		StoringNumbersLinkedList appet=new StoringNumbersLinkedList();
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(3);
		frame.setTitle("StoringNumbersLinkedList");
		frame.add(appet,BorderLayout.CENTER);
		appet.init();
		appet.start();
		frame.setSize(600,160);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
























































































