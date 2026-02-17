import java.util.Stack;
public class RemoveKDigits {
    public String removeKdigits(String num, int k){
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        char[] numbers = num.toCharArray();

        for (char number : numbers) {
            while (! stack.isEmpty() && k > 0 && stack.peek() - '0' > number - '0') {
                stack.pop();
                k--;
            }
            stack.push(number);
        }
        while (k != 0) {
            stack.pop();
            k--;
        }
        for (char ch : stack) {
            sb.append(ch);
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString(); 
    }
}
