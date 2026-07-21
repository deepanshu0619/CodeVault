class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (p.length() > s.length())
            return ans;

        int[] freq = new int[26];

        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0;
        int required = p.length();

        for (int right = 0; right < s.length(); right++) {

            char r = s.charAt(right);

            if (freq[r - 'a'] > 0)
                required--;

            freq[r - 'a']--;

            // Keep window size equal to p.length()
            if (right - left + 1 > p.length()) {

                char l = s.charAt(left);

                if (freq[l - 'a'] >= 0)
                    required++;

                freq[l - 'a']++;

                left++;
            }

            if (required == 0)
                ans.add(left);
        }

        return ans;
    }
}