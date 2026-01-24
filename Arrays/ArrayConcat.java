public class ArrayConcat {
    public int[] getConcatnation(int[] nums){
        int n = nums.length;
        int[] result = new int[2*n];

        for(int i = 0; i < n; i++){
            result[i] = nums[i];
            result[n + i] = nums[i];
        }
        return result;
    }
}
