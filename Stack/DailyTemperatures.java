import java.util.Stack;
import java.util.Arrays;
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures){
        int[] result = new int[temperatures.length];
        Arrays.fill(result,0);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < temperatures.length ; i++){
            while(! stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        
        return result;
    }
}
