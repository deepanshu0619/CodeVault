import java.util.*;

class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        // Separate negative and non-negative numbers
        for (int num : nums) {
            if (num < 0) {
                neg.add(num * num);
            } else {
                pos.add(num * num);
            }
        }

        // Reverse the negative squares
        Collections.reverse(neg);

        int[] ans = new int[nums.length];
        int i = 0, j = 0, k = 0;

        // Merge the two sorted lists
        while (i < neg.size() && j < pos.size()) {
            if (neg.get(i) <= pos.get(j)) {
                ans[k++] = neg.get(i++);
            } else {
                ans[k++] = pos.get(j++);
            }
        }

        // Add remaining elements
        while (i < neg.size()) {
            ans[k++] = neg.get(i++);
        }

        while (j < pos.size()) {
            ans[k++] = pos.get(j++);
        }

        return ans;
    }
}