class Solution {

    public int[] getNoZeroIntegers(int n) {
        for (int A = 1; A < n; ++A) {
            int B = n - A;
            if (
                !String.valueOf(A).contains("0") &&
                !String.valueOf(B).contains("0")
            ) {
                return new int[] { A, B };
            }
        }
        return new int[0];
    }
}
//         int[] res = {0};
//         for (int i = 1; i < n; i++) {
//             int a = i;
//             if (!containsZero(a)) {
//                 int b = n - a;
//                 if (!containsZero(b)) {
//                     res = new int[]{a, b};
//                     break;
//                 }
//             }
//         }
//         return res;
//     }

//     boolean containsZero(int num) {
//     while (num > 0) {
//         int digit = num % 10;   
//         if (digit == 0) {
//             return true;
//         }
//         num = num / 10;         
//     }
//     return false;
// }

