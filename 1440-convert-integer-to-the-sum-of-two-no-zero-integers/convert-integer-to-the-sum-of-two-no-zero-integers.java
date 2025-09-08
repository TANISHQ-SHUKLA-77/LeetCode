class Solution {

    public int[] getNoZeroIntegers(int n) {

        int[] ans = {0};
        for (int i = 1; i < n; i++) {
            int a = i;
            if (!check(a)) {

                int b = n - a;

                if (!check(b)) {

                    ans = new int[]{a, b};

                    break;
                }
            }
        }
        return ans;
    }

    boolean check(int num) {
    while (num > 0) {

        int digit = num % 10; 

        if (digit == 0) return true;
        
        num = num / 10; 

             
    }
    return false;   
}

}

