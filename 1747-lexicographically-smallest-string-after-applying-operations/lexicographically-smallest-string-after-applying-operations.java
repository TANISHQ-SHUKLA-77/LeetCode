class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> seen = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        
        queue.offer(s);
        String smallest = s;

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (seen.contains(curr)) continue;

            seen.add(curr);

            if (curr.compareTo(smallest) < 0) {
                smallest = curr;
            }
            
            String additionString = add(curr, a);
            String rotationString = rotate(curr, b);

            for (String newString : List.of(additionString, rotationString)) {
                queue.offer(newString);
            }
        }

        return smallest;
      
    }

    private String add(String s, int a) {
        StringBuilder builder = new StringBuilder(s);
        for (int i = 1; i < s.length(); i+=2) {
            int newDigit = (s.charAt(i) - '0' + a) % 10;
            builder.setCharAt(i, (char) ('0' + newDigit));
        }

        return builder.toString();
    }

    private String rotate(String s, int b) {
        int n = s.length();
        return s.substring(n - b) + s.substring(0, n - b);
    }
}