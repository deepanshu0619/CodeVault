import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Prefix sum 0 has occurred once
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            // We need an earlier prefix sum = sum - k
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // Store frequency of current prefix sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}