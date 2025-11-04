// this is really not a easy level sol its medium level and many explanations are there in submitted sol pls refer

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n-k+1];
        
        for(int i = 0 ; i<= n-k ; i++)
        {
            int[] freq = new int[51]; 

            for(int j = i; j<i+k ;j++){
                freq[nums[j]]++;
            }
            answer[i] = getXSum(freq,x);
        }
       
       return answer;
    }

    public int getXSum(int[] freq, int x){

        int[][] arr = new int[51][2];

        for(int i = 1 ; i< 51 ; i++){
            arr[i][0] = i; 
            arr[i][1] = freq[i]; 
        }

        Arrays.sort(arr , (a,b) -> {
            if(b[1] == a[1]) return b[0] - a[0];
            return b[1] - a[1];
        });

        int sum = 0;
        int count = 0;

        for(int i = 0 ; i < 51 && count < x;i++){
            sum += arr[i][0] * arr[i][1];
            count++;
        }

        return sum;
    }
}