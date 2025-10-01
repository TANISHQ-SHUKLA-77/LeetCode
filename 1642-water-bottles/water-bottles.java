class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = 0;
        int emptyBottle = 0;
        while (numBottles > 0) {
            count += numBottles;
            emptyBottle += numBottles;
            numBottles = emptyBottle / numExchange;
            emptyBottle = emptyBottle % numExchange;
        }
        return count;
    }
}