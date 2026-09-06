class Solution {

    int count = 0;

    public int countRangeSum(int[] nums, int lower, int upper) {

        long[] prefix = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        mergeSort(prefix, 0, prefix.length - 1, lower, upper);

        return count;
    }

    void mergeSort(long[] arr, int left, int right, int lower, int upper) {

        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid, lower, upper);
        mergeSort(arr, mid + 1, right, lower, upper);

        int l = mid + 1;
        int r = mid + 1;

        // Count valid ranges
        for (int i = left; i <= mid; i++) {

            while (l <= right && arr[l] - arr[i] < lower) {
                l++;
            }

            while (r <= right && arr[r] - arr[i] <= upper) {
                r++;
            }

            count += r - l;
        }

        // Merge sorted halves
        long[] temp = new long[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }
}