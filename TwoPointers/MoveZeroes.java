public class MoveZeroes {
    public void moveZeroes(int[] nums){
        int k = 0;
        for (int i : nums) {
            if (i != 0)
                nums[k++] = i;
        }
        while (k < nums.length)
            nums[k++] = 0;

    }
}
