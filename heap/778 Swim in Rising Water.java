class Solution {
    public int swimInWater(int[][] grid) {
        
        if(grid == null || grid.length < 2) return 0;
        
        
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        heap.offer(new int[]{grid[0][0], 0, 0, grid[0][0]});
        
        boolean visited[][] = new boolean[grid.length][grid.length];
        visited[0][0] = true;
        int next[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        while(!heap.isEmpty()) {
            
            int[] val = heap.poll();
            int row = val[1];
            int col = val[2];
            
            for(int i=0; i < next.length; i++) {

                int nextRow = row + next[i][0];
                int nextCol = col + next[i][1];  

                if(nextRow >= 0 && nextCol >= 0 && nextRow < grid.length && nextCol < grid.length) {

                    if(!visited[nextRow][nextCol]) {
                        
                        visited[nextRow][nextCol] = true;


                        if(nextRow == grid.length - 1 && nextCol == grid.length -1)  
                            return Math.max(grid[nextRow][nextCol], val[3]);
                        
                        heap.offer(new int[]{grid[nextRow][nextCol], nextRow, nextCol, 
                                             Math.max(grid[nextRow][nextCol], val[3])});

                        
                    }
                }
            }
        }
        return 0;
    }
}
