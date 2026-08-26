class Solution {
    public boolean circularArrayLoop(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            // Try every index as starting point
            int slow = i;
            int fast = i;

            boolean forward = nums[i] > 0;

            while (true) {

                // Move slow one step
                slow = nextIndex(nums, slow, forward);

                // If direction changes, invalid
                if (slow == -1) {
                    break;
                }

                // Move fast first step
                fast = nextIndex(nums, fast, forward);

                if (fast == -1) {
                    break;
                }

                // Move fast second step
                fast = nextIndex(nums, fast, forward);

                if (fast == -1) {
                    break;
                }

                // Cycle found
                if (slow == fast) {

                    // Cycle must contain more than one element
                    if (slow == nextIndex(nums, slow, forward)) {
                        break;
                    }

                    return true;
                }
            }
        }

        return false;
    }

    private int nextIndex(int[] nums, int index, boolean forward) {

        // Direction must remain the same
        if ((nums[index] > 0) != forward) {
            return -1;
        }

        int n = nums.length;

        int next = (index + nums[index]) % n;

        if (next < 0) {
            next += n;
        }

        // Self-loop is not allowed
        if (next == index) {
            return -1;
        }

        return next;
    }
}