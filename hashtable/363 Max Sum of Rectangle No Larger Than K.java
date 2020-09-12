//O(n^2 * mlog(m))
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int t) {
        
        if(matrix == null || matrix.length == 0) return 0;
        
        int columnTotal[][] = new int[matrix.length][matrix[0].length];
        
        for(int i=0; i< matrix[0].length; i++)
            for(int j=0; j< matrix.length; j++)
                columnTotal[j][i] = j == 0 ? matrix[j][i] : columnTotal[j-1][i] + matrix[j][i];
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i< matrix.length; i++) {
            for(int j=i; j< matrix.length; j++) {
                
                int sum = 0;
                TreeSet<Integer> set = new TreeSet<>();
                
                for(int k=0; k < matrix[0].length; k++) {
                    
                    sum += i == 0 ? columnTotal[j][k] : columnTotal[j][k] - columnTotal[i-1][k];

                    int area  = sum;
                    
                    if(area == t) return t;
                    
                    Integer find = set.ceiling(area - t);
                        
                    if(find != null) {
                        if((area - t > 0 && find > 0) || (area - t < 0 && find < 0))
                            area = sum - find;
                    }

                    set.add(sum);
                    
                    if(area > max && area <= t) max = area;
                }
            }
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }
}

/*


        1  0  2  5  4 -2 -4 
    r1  4 -4  7  3  5 -6  3
        3  8  9  1  3 -3  9
    r2 -5  3 -5  9  2  3  5
    
    
    5 -4 -3  4
   -3 -4  4  5
    5  1  5 -4


*/
