
class Solution {
    public String longestPalindrome(String s) {
        int m = s.length();
        char[] ch = s.toCharArray();
        int[][] arr = new int[m][4]; 

        arr[0][0] = 0;
        arr[0][1] = 0;
        arr[0][2] = 0;
        arr[0][3] = 1;
        int currMax = 0;
        int[][] rra = new int[m][4];
        rra[0][0] = 0;
        rra[0][1] = 0;
        rra[0][2] = 0;
        rra[0][3] = 0;
        int maxCurr = 0;
        
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                int count = 0;
                int count2 = 0;
                
                arr[i][0] = i;
                arr[i][1] = 0;
                arr[i][2] = 0;
                count += 1;
                arr[i][3] = count;
                currMax = Math.max(arr[i][3], currMax);

                int r = i + 1;
                if ((r < m) && (ch[i] == ch[r])) {
                    rra[i][0] = i;
                    rra[i][1] = 0;
                    rra[i][2] = r;
                    count2 += 2;
                    rra[i][3] = count2;
                    r += 1;
                }
                while (r < m) {
                    if (ch[i] == ch[r]) {
                        rra[i][0] = i;
                        rra[i][1] = 0;
                        rra[i][2] = r;
                        count2 += 1;
                        rra[i][3] = count2;
                        r += 1;
                    } else {
                        break;
                    }
                } 

                maxCurr = Math.max(rra[i][3], maxCurr);
                
                continue;
            } 

            int L = i - 1;
            int R = i + 1;
            int count = 0;
            int count2 = 0;

            arr[i][0] = i;
            arr[i][1] = i;
            arr[i][2] = i;
            count += 1;
            arr[i][3] = count;


            while ((L >= 0 && R < m) && ch[L] == ch[R]) {
                arr[i][0] = i;
                arr[i][1] = L;
                arr[i][2] = R;
                count += 2;
                arr[i][3] = count;
                if (L - 1 >= 0) {
                    L -= 1;
                } else {
                    break;
                }
                if (R + 1 < m) {
                    R += 1;
                } else {
                    break;
                }
            } 

            currMax = Math.max(arr[i][3], currMax);

            int r = i + 1;
            int t = i - 1;
            if ((r < m) && (ch[i] == ch[r])) {
                rra[i][0] = i;
                rra[i][1] = i;
                rra[i][2] = r;
                count2 += 2;
                rra[i][3] = count2;
                r += 1;
            }
            while ((t >= 0 && r < m)) {
                if (ch[t] == ch[r]) {
                    rra[i][1] = t;
                    rra[i][2] = r;
                    count2 += 2;
                    rra[i][3] = count2;
                    r += 1;
                    t -= 1;
                } else {
                    break;
                }
            } 

            maxCurr = Math.max(rra[i][3], maxCurr);
        } 

        int u = currMax;
        int v = maxCurr;
        if (u >= v) {
            int ind = 0;
            for (int i = 0; i < m; i++) {
                if (arr[i][3] == currMax) {
                    ind = i;
                    break;
                }
            } 
            
            StringBuilder sb = new StringBuilder();
            for (int i = arr[ind][1]; i <= arr[ind][2]; i++) {
                sb.append(s.charAt(i));
            }

            return sb.toString();
        } else {
            int ind = 0;
            for (int i = 0; i < m; i++) {
                if (rra[i][3] == maxCurr) {
                    ind = i;
                    break;
                }
            } 

            StringBuilder sb = new StringBuilder();
            for (int i = rra[ind][1]; i <= rra[ind][2]; i++) {
                sb.append(s.charAt(i));
            } 

            return sb.toString();
        } 
    } 
} 

//use manacher's algorithm