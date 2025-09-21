class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int balance=0;
        for(char ch : s.toCharArray()){
            if(ch=='('){
                if(balance>0) {
                    sb.append(ch);
                }
                balance++;
            }
            else{
                balance--;
                if(balance>0) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}