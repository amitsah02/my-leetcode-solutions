import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            // operator case
            if (token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/")) {

                int b = stack.pop();
                int a = stack.pop();

                int result = 0;

                if (token.equals("+")) {
                    result = a + b;
                } else if (token.equals("-")) {
                    result = a - b;
                } else if (token.equals("*")) {
                    result = a * b;
                } else { // "/"
                    result = a / b; // truncates toward zero automatically
                }

                stack.push(result);

            } 
            // operand case
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
