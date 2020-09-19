class Solution {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        if(edges == null || edges.length == 0) return new int[]{0};
        
        Map<Integer, Tree> tree = new HashMap<>();
        
        for(int i=0; i< N; i++)
            tree.put(i, new Tree(i));
        
        for(int[] edge: edges) {
            tree.get(edge[0]).child.add(edge[1]);
            tree.get(edge[1]).child.add(edge[0]);
        }
        
        int ans[] = new int[N];
        sumOfDistancesInTree(0, tree, ans, -1);
        calculateForEachNode(0, ans, tree, -1);
        return ans;
    }
    
    public void sumOfDistancesInTree(int n, Map<Integer, Tree> tree, int ans[], int prev) {
        tree.get(n).parent = prev;
        for(int next: tree.get(n).child) {
            if(next != prev) {
                sumOfDistancesInTree(next, tree, ans, n);
                ans[n] += ans[next] + tree.get(next).numberOfChildren + 1;
                tree.get(n).numberOfChildren += tree.get(next).numberOfChildren + 1;
            }
        }
    }
    
    public void calculateForEachNode(int n, int[] ans, Map<Integer, Tree> tree, int prev) {
        
        for(int i: tree.get(n).child) {
            if(i != prev) {
                Tree node = tree.get(i);
                int parent_sumOfOtherSide = ans[node.parent] - (ans[i] + node.numberOfChildren + 1);
                int parent_numberOfOtherChild = tree.get(node.parent).numberOfChildren - 
                                                                    (node.numberOfChildren + 1);
                ans[i] += parent_sumOfOtherSide + parent_numberOfOtherChild + 1;
                node.numberOfChildren += parent_numberOfOtherChild + 1;
                calculateForEachNode(i, ans, tree, n);
            }
        }
    }
     
}

class Tree {
    List<Integer> child;
    int node;
    int numberOfChildren;
    int parent;
    public Tree(int node) {
        child = new ArrayList<>();
        this.node = node;
    }
}
