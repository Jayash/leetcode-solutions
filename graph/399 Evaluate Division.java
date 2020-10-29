class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double ans[] = new double[queries.size()];
        if(ans.length == 0) return ans;
        
        int index = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for(List<String> equation: equations) {
            if(!map.containsKey(equation.get(0))) {
                map.put(equation.get(0), index);
                index++;
            }
            if(!map.containsKey(equation.get(1))) {
                map.put(equation.get(1), index);
                index++;
            }
        }
        
        double grid[][] = new double[map.size()][map.size()];
        
        for(int i=0; i< equations.size(); i++) {
            List<String> equation = equations.get(i);
            grid[map.get(equation.get(0))][map.get(equation.get(1))] = values[i];
            grid[map.get(equation.get(1))][map.get(equation.get(0))] = 1.0/values[i];
        }
        
        for(int i=0; i < queries.size(); i++) {
            if(!map.containsKey(queries.get(i).get(0)) || !map.containsKey(queries.get(i).get(1)))
                ans[i] = -1.0;
            else ans[i] = dfs(map.get(queries.get(i).get(0)), map.get(queries.get(i).get(1)), 
                        new boolean[grid.length], 1, grid);
        }
        return ans;
    }
    
    public double dfs(int src, int dest, boolean[] visited, double value, double[][] grid) {
        if(src == dest) return value;
        if(visited[src]) return -1.0;
        if(grid[src][dest] != 0.0) return value * grid[src][dest];
        visited[src] = true;
        double ans = -1.0;
        for(int i=0; i< grid.length; i++) {
            if(grid[src][i] != 0.0)
                ans = dfs(i, dest, visited, value * grid[src][i], grid);
            
            if(ans != -1.0) break;
        }
        return ans;
    }

}
