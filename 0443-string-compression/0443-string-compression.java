class Solution {
    public int compress(char[] chars) {
        int readIndex = 0;
        int writeIndex = 0;

        while (readIndex < chars.length) {

            char currentChar = chars[readIndex];
            int count = 0;

            // Count consecutive same characters
            while (readIndex < chars.length &&
                   chars[readIndex] == currentChar) {
                count++;
                readIndex++;
            }

            // Write the character
            chars[writeIndex] = currentChar;
            writeIndex++;

            // Write count only if > 1
            if (count > 1) {
                String countStr = String.valueOf(count);

                for (int i = 0; i < countStr.length(); i++) {
                    chars[writeIndex] = countStr.charAt(i);
                    writeIndex++;
                }
            }
        }

        return writeIndex;
    }
}