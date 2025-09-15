class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();
        for (char ch : brokenLetters.toCharArray()) set.add(ch);

        int res = 0;
        boolean valid = true;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                if(valid) res++;
                valid = true;
            }
            else if (set.contains(ch)) valid = false;
        }

        if (valid) res++;
        return res;
    }
}