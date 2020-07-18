package coursera.datastruct.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        
        boolean isBalanced = true;
        Stack<Character> opening_brackets_stack = new Stack<>();
        Stack<Integer> bracket_indices = new Stack<>();
        
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);
            if (next == '(' || next == '[' || next == '{') {
            	opening_brackets_stack.push(next);
            	bracket_indices.push(position);
            }
            else {
            	if(opening_brackets_stack.isEmpty()) {
            		if(next == '}' || next == ']' || next == ')') {
            			System.out.println(position + 1);
            			isBalanced = false;
            			break;
            		}
            	} 
            	if(next == ')' || next == ']' || next == '}') {
            		char top = opening_brackets_stack.pop();
            		int index = bracket_indices.pop();
            		if(next == ')' && top != '(') {
            			System.out.println(position + 1);
            			isBalanced = false;
            			break;
            		}
            		else if(next == ']' && top != '[') {
            			System.out.println(position + 1);
            			isBalanced = false;
            			break;
            		}
            		else if(next == '}' && top != '{') {
            			System.out.println(position + 1);
            			isBalanced = false;
            			break;
            		}
            	}
            }
        }
        if(isBalanced && opening_brackets_stack.empty())
        	System.out.println("Success");
        else if(isBalanced && !opening_brackets_stack.empty()) {
        	System.out.println(bracket_indices.pop() + 1);
        }
    }
}
