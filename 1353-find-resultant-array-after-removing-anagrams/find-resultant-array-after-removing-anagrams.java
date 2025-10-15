class Solution {
   public String sorted(String temp)
   {
    char[] t=temp.toCharArray();
    Arrays.sort(t);
    return String.valueOf(t);
   }
    public List<String> removeAnagrams(String[] words) {
     Stack<String>st=new Stack();
     List<String>list=new ArrayList<>();
     list.add(words[0]);
     st.push(sorted(words[0]));
     for(int i=1;i<words.length;i++)
     {
        if((!st.peek().equals(sorted(words[i]))))
        {
            list.add(words[i]);
            st.push(sorted(words[i]));
        } 
     }
     return list;
    }
}