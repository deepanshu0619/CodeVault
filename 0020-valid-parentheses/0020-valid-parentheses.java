class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.empty()) return false;

                char top = st.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return st.empty();
    }
}



// static class Solution {
//     public boolean isValid(String s) {
//         Stack<Character> st = new Stack<>();

//         for (char ch : s.toCharArray()) {

//             if (st.empty() || ch == '(' || ch == '{' || ch == '[') {
//                 st.push(ch);
//                 continue;
//             }

//             if (ch == ')') {
//                 if (st.peek() == '(')
//                     st.pop();
//                 else
//                     return false;
//             } 
//             else if (ch == '}') {
//                 if (st.peek() == '{')
//                     st.pop();
//                 else
//                     return false;
//             } 
//             else if (ch == ']') {
//                 if (st.peek() == '[')
//                     st.pop();
//                 else
//                     return false;
//             }
//         }

//         return st.empty();
//     }
// }