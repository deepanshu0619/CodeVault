class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> have = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            have.put(ch, have.getOrDefault(ch, 0) + 1);
        }

        int count = 0;
        boolean odd = false;

        for (int freq : have.values()) {
            if (freq % 2 == 0) {
                count += freq;
            } else {
                count += freq - 1;
                odd = true;
            }
        }

        if (odd) {
            count++;
        }

        return count;
    }
}