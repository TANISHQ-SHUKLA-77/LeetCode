class Solution {
    public int smallestNumber(int n) {
        
        int bitRequired = (int)(Math.log(n) / Math.log(2)) + 1;

        return (1 << bitRequired) - 1;
    }
}