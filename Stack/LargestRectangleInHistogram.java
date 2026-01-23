import java.util.Stack;
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights){
        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;

        for(int i = 0; i < heights.length ; i++ ){
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int mid = stack.pop();
                int right = i;

                int left = stack.isEmpty() ? -1 : stack.peek() ;

                int width = right - left - 1 ;

                int area = heights[mid] * width ;

                maxArea = Math.max(area,maxArea);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int mid = stack.pop();
            int right = heights.length;

            int left = stack.isEmpty() ? -1 : stack.peek() ;
            int width = right - left -1 ;

            int area = heights[mid] * width ;

            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
}
