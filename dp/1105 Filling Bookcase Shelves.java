class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        if(books == null || books.length == 0) return 0;
        
        int[] dp = new int[books.length];
        
        dp[0] = books[0][1];
        
        // 1, 3, 4, 
        
        for(int i=1; i< books.length; i++) {
            
            dp[i] = dp[i-1] + books[i][1];
            int height = books[i][1];
            int width = books[i][0];
            
            for(int j= i-1; j >=0 ; j--) {
                if(width + books[j][0] > shelf_width) break;
                
                height = Math.max(height, books[j][1]);
                width = width + books[j][0];
                
                if(j != 0) dp[i] = Math.min(dp[i], dp[j-1] + height);
                else dp[i] = Math.min(dp[i], height);
            }
            
        }
        
        return dp[books.length-1];
    }
}
