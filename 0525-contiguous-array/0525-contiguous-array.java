class Solution {
    public int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> mp = new HashMap<>();

        int currSum = 0;
        int result = 0;

        mp.put(0, -1);

        for (int i = 0; i < nums.length; i++) {

            currSum += (nums[i] == 1) ? 1 : -1;

            if (mp.containsKey(currSum)) {
                result = Math.max(result, i - mp.get(currSum));
            } else {
                // Store only the first occurrence
                mp.put(currSum, i);
            }
        }

        return result;
    }
}