class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int totalGap = 2*(numRows - 1);
        
        StringBuilder zigzag = new StringBuilder();

        int leftGap = totalGap;
        int rightGap = 0;
        for (int row = 0; row < numRows; row++) {
            int i = row;
            while (i < s.length()) {
                if (leftGap != 0) {
                    zigzag.append(s.charAt(i));
                    i += leftGap;
                }
                if (rightGap != 0 && i < s.length()) {
                    zigzag.append(s.charAt(i));
                    i += rightGap;
                }
            }
            leftGap -= 2;
            rightGap += 2;
        }
        
        return zigzag.toString();
    }
}