class Solution {
    public int totalMoney(int n) {

        int q = n / 7 ; 
        int r = n % 7 ; 

        long full = 7L * q * (q + 7) / 2 ; 
        
        long rem = 1L * r * (q + 1) + 1L * r * (r - 1) / 2 ;

        return (int)(full + rem) ;
    }
}