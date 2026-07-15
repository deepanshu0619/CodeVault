class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> h = new HashSet<>();
        int l=0;
        int max=0;
        for(int i=0;i<s.length();i++){
         while(h.contains(s.charAt(i))){
            h.remove(s.charAt(l));
            l++;
         }
         h.add(s.charAt(i));
         max = Math.max(max,i-l+1);
        }
        return max;
    }
}