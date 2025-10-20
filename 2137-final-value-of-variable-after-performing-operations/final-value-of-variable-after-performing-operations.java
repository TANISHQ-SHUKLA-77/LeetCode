class Solution {
    private int n;
    public int finalValueAfterOperations(String[] operations) {
        n = operations.length;
        int negatives = 0;
        int positives = 0;
        for(int i = 0; i < n; i++) {
            if(operations[i].charAt(0) == '+' || operations[i].charAt(operations[i].length() - 1) == '+') {
                positives++;
            } else {
                negatives++;
            }
        }

        return positives - negatives;
    }
}