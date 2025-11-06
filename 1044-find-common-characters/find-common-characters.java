class Solution {
    public List<String> commonChars(String[] words) {
        int[] currarr = new int[26];
        int[] comparearr = new int[26];
        List<String> list = new ArrayList<>();

        for(char ch : words[0].toCharArray()){
            currarr[ch - 97] = currarr[ch - 97] + 1;
        }
        if(words.length > 1){
            for(int i = 1 ; i < words.length ; i++){
                for(char ch : words[i].toCharArray()){
                    comparearr[ch - 97] = comparearr[ch - 97] + 1;
                }
                for(int j = 0 ; j < 26 ; j++){
                    currarr[j] = Math.min(currarr[j],comparearr[j]);
                    comparearr[j] = 0;
                }
            }
            for(int i = 0 ; i < 26 ; i++){
            if(currarr[i]>0){
                char ch = (char)(i+97);
                for(int j = 0 ; j <currarr[i];j++){
                    list.add(String.valueOf(ch));
                }
            }
        }
        }else{
            for (char ch : words[0].toCharArray()) {
            list.add(String.valueOf(ch));
        }
   
        }
        return list;
    }
}