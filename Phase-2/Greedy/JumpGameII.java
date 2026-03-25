class JumpGameII {
    public int jump(int[] nums) {
        int jump = 0;
        int currentEnd = 0;
        int farthestEnd = 0;

        for(int i = 0; i < nums.length - 1; i++) {
            farthestEnd = Math.max(farthestEnd, i + nums[i]);

            if(i == currentEnd) {
                jump++;
                currentEnd = farthestEnd;
            }
        }
        return jump;
    }
}
