
class Solution {

    static void solve(int[] candidates, int target, int index,
                      List<List<Integer>> ans, List<Integer> output) {

        // Base case: target becomes zero
        if (target == 0) {
            ans.add(new ArrayList<>(output));
            return;
        }

        if (index >= candidates.length || target < 0) {
            return;
        }

        // Include the current element
        output.add(candidates[index]);
        solve(candidates, target - candidates[index], index, ans, output);

        // Backtrack
        output.remove(output.size() - 1);

        // Exclude the current element
        solve(candidates, target, index + 1, ans, output);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        solve(candidates, target, 0, ans, output);

        return ans;
    }
}
