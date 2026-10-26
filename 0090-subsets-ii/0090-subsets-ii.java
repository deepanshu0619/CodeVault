class Solution {
     static void solve(int nums[], int index, List<Integer> output,
                      List<List<Integer>> ans) {

        if (index >= nums.length) {
            ans.add(new ArrayList<>(output));
            return;
        }

        int currValue = nums[index];

        // Include
        output.add(currValue);
        solve(nums, index + 1, output, ans);

        // Backtrack
        output.remove(output.size() - 1);

        while(index+1<nums.length && nums[index]==nums[index+1]){
            index++;
        }
        // Exclude
        solve(nums, index + 1, output, ans);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int index=0;
        List<Integer> output = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        solve(nums, index, output, ans);

        return ans;
    }
}