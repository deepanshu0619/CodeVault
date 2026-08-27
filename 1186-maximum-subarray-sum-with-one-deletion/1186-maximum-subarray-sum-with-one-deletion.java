class Solution {
    public int maximumSum(int[] arr) {
        long noDelete = arr[0];
        long oneDelete = Long.MIN_VALUE / 2;
        long ans = arr[0];

        for (int i = 1; i < arr.length; i++) {
            long deleteCurrent = noDelete;

            noDelete = Math.max(noDelete + arr[i], arr[i]);

            oneDelete = Math.max(oneDelete + arr[i], deleteCurrent);

            ans = Math.max(ans, Math.max(noDelete, oneDelete));
        }

        return (int) ans;
    }
}