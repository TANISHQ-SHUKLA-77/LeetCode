class Solution {
    public int triangleNumber(int[] nums) {
        int MAX = Arrays.stream(nums).max().getAsInt();
        int oc[] = new int[MAX+1], sum[] = new int[MAX+1];
        for(var x : nums){
            if(x > 0)
            oc[x]++;
        }
        for(int i = 0; i<=MAX; i++){
            sum[i] = oc[i];
            if(i>0)
            sum[i] += sum[i-1];
        }
        print(oc);
        print(sum);
        int ans = 0;
        for(int i = 1; i<=MAX; i++){
            if(oc[i] > 1){

                ans += (sum[Math.min(MAX, i+i-1)] - sum[i]) * oc[i] * (oc[i] - 1) / 2;
                if(oc[i] > 2){

                    ans += oc[i] * (oc[i] - 1) * (oc[i] - 2) / 6;
                }
            }
            for(int j = i+1; j<=MAX; j++){
                if(oc[i] * oc[j] == 0)continue;

                int third = sum[Math.min(MAX, i+j-1)] - sum[j];
                ans += oc[i] * oc[j] * third;
                if(oc[j] > 1){

                    ans += oc[i] * oc[j] * (oc[j] - 1) / 2;
                }
            }
        }
        return ans;
    }
    private static void print(Object ...args){
        // System.out.println(Arrays.deepToString(args));
    }

}