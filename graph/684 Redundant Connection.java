class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        if(edges == null || edges.length == 0) return new int[0];
        int n = edges.length;
        
        int dsu[] = new int[n+1];
        
        Arrays.fill(dsu, -1);
        int ans[] = new int[]{-1, -1};
        
        for(int[] edge: edges) {
            int find1 =  find(dsu, edge[0]);
            int find2 = find(dsu, edge[1]);
            
            if(find1 != -1 && find1 == find2)  ans = edge;
            else union(dsu, find1, find2);
        }
        
        return ans;
    }
    
    public int find(int[] dsu, int i) {
        while(dsu[i] > 0) i = dsu[i];
        return i;
    }
    
    public void union(int[] dsu, int find1, int find2) {
        if(Math.abs(dsu[find1]) > Math.abs(dsu[find2])) {
            dsu[find1] = -1 * (Math.abs(dsu[find1]) + Math.abs(dsu[find2]));
            dsu[find2] = find1;
        } else {
            dsu[find2] = -1 * (Math.abs(dsu[find1]) + Math.abs(dsu[find2])); 
            dsu[find1] = find2;
        }
    }

}


// 1 2 3    1 2      3      1 2 3     
