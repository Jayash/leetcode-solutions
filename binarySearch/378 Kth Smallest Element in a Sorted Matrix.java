class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0) return 0;
        int n = matrix.length - 1;
        int l = matrix[0][0];
        int r = matrix[n][n];
        while(l < r) {
            int mid = l + (r-l)/2;
            int count = count(matrix, mid);
            if(count < k) l = mid+1;
            else r = mid;
        }
        return l;
    }
    
    public int count(int[][] matrix, int mid) {
        
        int count = 0;
        int j = matrix.length -1;
        for(int i=0; i< matrix.length; i++) {
            while(j >= 0 && matrix[i][j] > mid) j--;
            
            if(j < 0) break;
            
            count += j + 1;
        }
        
        return count;
    }
}
