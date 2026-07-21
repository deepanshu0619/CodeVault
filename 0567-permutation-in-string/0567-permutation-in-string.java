class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;

        int[] freq = new int[26];

        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0;
        int required = s1.length();

        for (int right = 0; right < s2.length(); right++) {

            char r = s2.charAt(right);

            if (freq[r - 'a'] > 0)
                required--;

            freq[r - 'a']--;

            // Keep window size equal to s1.length()
            if (right - left + 1 > s1.length()) {

                char l = s2.charAt(left);

                if (freq[l - 'a'] >= 0)
                    required++;

                freq[l - 'a']++;

                left++;
            }

            if (required == 0)
                return true;
        }

        return false;
    }
}