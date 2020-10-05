class Solution {
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length == 0) return 0;
        
        int height = heightMap.length;
        int width = heightMap[0].length;
        int ans = 0;
        
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        for(int i=0; i< width; i++) {
            heap.offer(new int[]{0, i, heightMap[0][i]});
            heap.offer(new int[]{height - 1, i, heightMap[height-1][i]});
            heightMap[0][i] = -1;
            heightMap[height-1][i] = -1;
        }
        
        for(int i=1; i< height-1; i++) {
            heap.offer(new int[]{i, 0, heightMap[i][0]});
            heap.offer(new int[]{i, width-1, heightMap[i][width-1]});
            heightMap[i][0] = -1;
            heightMap[i][width-1] = -1;
        }
        
        
        int arr[][] = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!heap.isEmpty()) {
            
            int[] node = heap.poll();
            int i = node[0];
            int j = node[1];
            for(int l=0; l< arr.length; l++) {
                int nextI = i + arr[l][0];
                int nextJ = j + arr[l][1];
                
                if(nextI >= 0 && nextJ >=0 && nextI < height && nextJ < width) {
                    if(heightMap[nextI][nextJ] != -1) {
                        if(heightMap[nextI][nextJ] > node[2])
                            heap.offer(new int[]{nextI, nextJ, heightMap[nextI][nextJ]});
                        else {
                            ans += node[2] - heightMap[nextI][nextJ];
                            heap.offer(new int[]{nextI, nextJ, node[2]});
                        }
                        heightMap[nextI][nextJ] = -1;
                    }
                }
            }
            
        }
        
        return ans;
    }
}
