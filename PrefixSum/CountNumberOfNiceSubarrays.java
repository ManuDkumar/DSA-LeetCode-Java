class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            prefixSum += num % 2;

            count += map.getOrDefault(prefixSum - k, 0);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
