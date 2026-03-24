class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for(int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            int jump = i + nums[i];
            maxReach = Math.max(maxReach, jump);
        }
        return true;
    }
}
