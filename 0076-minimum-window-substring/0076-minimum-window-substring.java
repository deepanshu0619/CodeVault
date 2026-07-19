class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0)
            return "";

        // Frequency array for characters in t
        int[] freq = new int[128];
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0, right = 0;
        int required = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char r = s.charAt(right);

            // If this character is needed
            if (freq[r] > 0) {
                required--;
            }

            freq[r]--;
            right++;

            // Try shrinking the window
            while (required == 0) {

                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char l = s.charAt(left);
                freq[l]++;

                // If removing this character makes window invalid
                if (freq[l] > 0) {
                    required++;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}