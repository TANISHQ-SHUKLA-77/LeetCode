class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        int totalCost = 0;

        for(int i=1; i<colors.length(); i++){

            if(colors.charAt(i) == colors.charAt(i-1)){

                totalCost += Math.min(neededTime[i], neededTime[i-1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i-1]);
            }
        }

        return totalCost;
    }
}