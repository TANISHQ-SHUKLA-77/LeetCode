class Solution {
    public List<String> commonChars(String[] words) {
        List<String> list=new ArrayList<>();
        String first=words[0];
        int[] common=new int[26];
        for(char c: first.toCharArray()) {
            common[c-'a']++;
        }
        for(int i=1;i<words.length;i++) {
            String a=words[i];
            int[] current=new int[26];
            for(char c: a.toCharArray()) {
                current[c-'a']++;
            }
            for(int j=0;j<26;j++) {
                if(common[j]>current[j]) {
                    common[j]=current[j];
                }
            }
        }
        for(int k=0;k<26;k++) {
            while(common[k]>0) {
                list.add(String.valueOf((char)(k+'a')));
                common[k]--;
            }
        }
        return list;
    }
}