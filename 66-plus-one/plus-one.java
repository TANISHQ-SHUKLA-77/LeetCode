class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null) { return null; }

        if (digits.length == 1) {
            if (digits[0] == 9) {
                return new int[]{1, 0};
            } else {
                digits[0] += 1;
                return digits;
            }
        }
        
        int end = digits.length - 1;

        while (end > -1 && digits[end] == 9) {
            digits[end] = 0;
            end--;
            if (end > -1 && digits[end] != 9) {
                digits[end] += 1;
                return digits;
            }
        }
        if (end == -1) {
            int[] temp = new int[digits.length + 1];
            temp[0] = 1;
            return temp;
        }
        
        digits[end] += 1;
        return digits;
    }
}