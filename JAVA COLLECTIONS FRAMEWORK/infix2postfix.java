package JavaSyugyou0724;

import java.util.Stack;
import java.util.StringTokenizer;



public class infix2postfix {
	
	public static String infixToPostfix(String expression) {
		String s="";
		Stack<Character>operatorStack=new Stack<Character>();
		Stack<Integer>operandStack=new Stack<Integer>();
		StringTokenizer tokens=new StringTokenizer(expression,"()+-/*%",true);
		
		while (tokens.hasMoreTokens()) {
			String token=tokens.nextToken().trim();
			if(token.length()==0){
				continue;
			}
			else if (token.charAt(0)=='+'||token.charAt(0)=='-') {
				while (!operandStack.isEmpty()&&
						(operandStack.peek().equals('+')||
						operandStack.peek().equals('-')||
						operandStack.peek().equals('*')||
						operandStack.peek().equals('/'))) {
					s+=operandStack.pop()+" ";
				}
				operatorStack.push(new Character(token.charAt(0)));
			}else if (token.charAt(0)=='*'||token.charAt(0)=='/') {
				while (!operandStack.isEmpty()&&
						(operandStack.peek().equals('*')||
						operandStack.peek().equals('/'))) {
					s+=operatorStack.pop()+" ";
				}
				operatorStack.push(new Character(token.charAt(0)));
			}else if (token.trim().charAt(0)=='(') {
				operatorStack.push(new Character('('));
			}else if(token.trim().charAt(0)==')'){
				while (!operatorStack.peek().equals('(')) {
					s+=operatorStack.pop()+" ";
				}
				operatorStack.pop();
			}else {
				s+=token+" ";
			}
		}
		
		while (!operatorStack.isEmpty()) {
			s+=operatorStack.pop()+" ";
		}
		return s;
		
	}
	
}
