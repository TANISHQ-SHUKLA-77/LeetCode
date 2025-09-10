class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {

        int n=quiet.length;
        int res[]=new int[n];
        ArrayList<ArrayList<Integer>> list=new ArrayList();

        for(int i=0;i<n;i++){
            list.add(new ArrayList());
            res[i]=i;
        }
        int indg[]=new int [n];

        for(int it[]:richer){
            int u=it[0];
            int v=it[1];
            list.get(u).add(v);
            indg[v]++;
        }

        Queue<Integer> q=new LinkedList();
        for(int i=0;i<n;i++){
            if(indg[i]==0) q.add(i);
        }

        while(!q.isEmpty()){
            int curr=q.peek();
            q.remove();

            for(int i:list.get(curr)){
                if(quiet[res[curr]]<quiet[res[i]]){
                    res[i]=res[curr];
                }
                indg[i]--;
                if(indg[i]==0) q.add(i);
            }
        }

        return res;

        
    }
}