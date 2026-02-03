class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int turtoil = nums[0];
        int hare = nums[0];

        do{
            turtoil = nums[turtoil];
            hare = nums[nums[hare]];
        }while(turtoil != hare);

        turtoil = nums[0];

        while (turtoil != hare) {
            turtoil = nums[turtoil];
            hare = nums[hare];
        }
        return turtoil;
    }
}
