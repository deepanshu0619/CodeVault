class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            int length = sb.length();
            // If the current character matches the last added character, remove it
            if (length > 0 && sb.charAt(length - 1) == c) {
                sb.deleteCharAt(length - 1);
            } else {
                // Otherwise, append the current character
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}