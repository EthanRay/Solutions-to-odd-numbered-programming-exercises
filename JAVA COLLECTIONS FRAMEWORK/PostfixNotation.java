package JavaSyugyou0724;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class PostfixNotation {
	
	public static void processAnOperator(char op,Stack<Integer> operandStack) {
		if (op=='+') {
			int op1=((Integer)(operandStack.pop())).intValue();
			//int op2=((Integer)(operandStack.pop())).intValue();
			int op2=operandStack.pop();
			System.out.println(op1+" "+op2);
			operandStack.push(new Integer(op1+op2));
		}else if (op=='-') {
			int op1=((Integer)(operandStack.pop())).intValue();
			int op2=((Integer)(operandStack.pop())).intValue();
			operandStack.push(new Integer(op1-op2));
		}
		else if (op=='*') {
			int op1=((Integer)(operandStack.pop())).intValue();
			int op2=((Integer)(operandStack.pop())).intValue();
			operandStack.push(new Integer(op1*op2));
		}else if (op=='/') {
			int op1=((Integer)(operandStack.pop())).intValue();
			int op2=((Integer)(operandStack.pop())).intValue();
			operandStack.push(new Integer(op1/op2));
		}
	}
	
	public static int evaluateExpression(String expression) {
		Stack<Integer> operandStack=new Stack<Integer>();
		StringTokenizer tokens=new StringTokenizer(expression, "+-*/%", true);
		
		while (tokens.hasMoreElements()) {
			String token=tokens.nextToken().trim();
			if (token.length()==0) {
				continue;
			}else if (token.charAt(0) == '+' || token.charAt(0) == '-' ||
			        token.charAt(0) == '*' || token.charAt(0) == '/') {
				processAnOperator(token.charAt(0), operandStack);
			}else {
				operandStack.push(new Integer(token));
			}
		}
		return ((Integer)(operandStack.pop())).intValue();
	}
	
	
	public static void main(String[] args) {
		while (true) {
			Scanner scanner=new Scanner(System.in);
			String expression=scanner.nextLine();
			try {
				//System.out.println(expression);
				System.out.println(evaluateExpression(expression));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
