package JavaSyugyou0724;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class PointCardGame24 extends Application{
	private ArrayList<Integer>list=new ArrayList<Integer>();
	private ImageView imageView1=new ImageView();
	private ImageView imageView2=new ImageView();
	private ImageView imageView3=new ImageView();
	private ImageView imageView4=new ImageView();
	private TextField tfExpression=new TextField();
	
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		for(int i=0;i<52;++i){
			list.add(i);
		}
		VBox vBox=new VBox(5);
		ArrayList<Integer>list2=new ArrayList<Integer>();
		for(int i=1;i<=52;++i){
			list2.add(i);
		}
		refresh();
		
		HBox hBox=new HBox(5);
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(imageView1,imageView2,imageView3,imageView4);
		
		Label lblStatus=new Label();
		Button btShuffle=new Button("Shuffle");
		HBox hBoxTop=new HBox(5);
		hBoxTop.setAlignment(Pos.CENTER_RIGHT);
		hBoxTop.getChildren().addAll(lblStatus,btShuffle);
		
		HBox hBoxBottom=new HBox(5);
		hBoxBottom.setAlignment(Pos.CENTER);
	    Button btVerify = new Button("Verify");
	    hBoxBottom.getChildren().addAll(
	     new Label("Enter an expression: "), tfExpression, btVerify);
	    
	    vBox.getChildren().addAll(hBoxTop, hBox, hBoxBottom);
	    
	    // Create a scene and place it in the stage
	    Scene scene = new Scene(vBox, 370, 160);
	    primaryStage.setTitle("Exercise20_13"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	    
	    btShuffle.setOnAction(e->refresh());
	    btVerify.setOnAction(e -> {
	        if (!correctNumbers()) {
	          lblStatus.setText("The numbers in the expression don't \nmatch the numbers in the set ");
	        } else {
	          // Check whether the expression evaluates to 24.
	          if (evaluate()) {
	            lblStatus.setText("Correct");
	          } else {
	            lblStatus.setText("Incorrect result");
	          }
	        }
	    });
	}
	
	 private boolean correctNumbers() {
		    // Get the card values from the expression
		    String[] values = tfExpression.getText().trim().split("[()+-/* ]");
		    //String[] values = jtfExpression.getText().trim().split("[+|-|\\*|/| |(|)]");
		    ArrayList<Integer> valueList = new ArrayList<>();
		    
		    ArrayList<Integer> currentCardValues = new ArrayList<>();
		    currentCardValues.add((list.get(0) - 1) % 13 + 1);
		    currentCardValues.add((list.get(1) - 1) % 13 + 1);
		    currentCardValues.add((list.get(2) - 1) % 13 + 1);
		    currentCardValues.add((list.get(3) - 1) % 13 + 1);

		    for (int i = 0; i < values.length; i++)
		      if (values[i].length() > 0)
		        valueList.add(Integer.parseInt(values[i]));

		    Collections.sort(valueList);
		    Collections.sort(currentCardValues);

		    if (valueList.equals(currentCardValues))
		      return true;
		    else
		      return false;
		  }
	
	private void refresh() {
		Collections.shuffle(list);
		imageView1.setImage(new Image("file:C:/Users/Ethan/workspace/image/card/"+list.get(0)+".png"));
		imageView2.setImage(new Image("file:C:/Users/Ethan/workspace/image/card/"+list.get(1)+".png"));
		imageView3.setImage(new Image("file:C:/Users/Ethan/workspace/image/card/"+list.get(2)+".png"));
		imageView4.setImage(new Image("file:C:/Users/Ethan/workspace/image/card/"+list.get(3)+".png"));
	}
	
	private boolean evaluate() {
		return EvaluateExpression.evaluateExpression(tfExpression.getText().trim())==24;
	}
	
	private static class EvaluateExpression{
		 public static int evaluateExpression(String expression){
			 
			 Stack<Integer> operandStack=new Stack<Integer>();
			 Stack<Character> operatorStack=new Stack<Character>();
			 
			 StringTokenizer tokens=new StringTokenizer(expression,"()+-/*",true);
			 
			 while (tokens.hasMoreElements()) {
				String token=tokens.nextToken().trim();
				if(token.length()==0)
					continue;
				else if (token.charAt(0)=='+'||token.charAt(0)=='-') {
					while (!operatorStack.isEmpty()&&
							(operatorStack.peek()=='+'||operatorStack.peek()=='-'
							||operatorStack.peek()=='*'||operatorStack.peek()=='/')) {
						processAnOperator(operandStack, operatorStack);
					}
					operatorStack.push(token.charAt(0));
				}else if (token.charAt(0)=='*'||token.charAt(0)=='/') {
					while (!operatorStack.isEmpty()
				              && (operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
						processAnOperator(operandStack, operatorStack);
					}
					operatorStack.push(token.charAt(0));
				}else if (token.trim().charAt(0)=='(') {
					operatorStack.push('(');
				}else if (token.trim().charAt(0)==')') {
					while (operatorStack.peek()!='(') {
						processAnOperator(operandStack, operatorStack);
					}
					operatorStack.pop();
				}else{
					operandStack.push(new Integer(token));
				}
			}
			 
			while (!operatorStack.isEmpty()) {
				processAnOperator(operandStack, operatorStack);
			}
			 return operandStack.pop();
			 
		 }
		 
		public static void processAnOperator(Stack<Integer> operandStack,Stack<Character> operandStack2) {
			char op=operandStack2.pop();
			int op1=operandStack.pop();
			int op2=operandStack.pop();
			if(op=='+')
				operandStack.push(op2+op1);
			else if(op=='-')
				operandStack.push(op2-op1);
			else if(op=='*')
				operandStack.push(op2*op1);
			else if(op=='/')
				operandStack.push(op2/op1);
		}
			
		}
	
	}
	


















































































































































