class Solution {
    public int candy(int[] ratings) {
        if(ratings.length < 2) return ratings.length;
        
        int candy[] = new int[ratings.length];
        
        if(ratings[1] >= ratings[0]) candy[0] = 1;
        
        for(int i=1; i< ratings.length - 1; i++) {
            if(ratings[i] <= ratings[i-1] && ratings[i] <= ratings[i+1]) candy[i] = 1;
            else if(ratings[i] > ratings[i-1]) candy[i] = candy[i-1] + 1;
        }
        
        if(ratings[ratings.length-2] >= ratings[ratings.length -1]) candy[ratings.length - 1] = 1;
        else candy[ratings.length - 1] = candy[ratings.length -2] + 1;
        
        for(int i=ratings.length-2; i>0; i--) {
            if(ratings[i] > ratings[i+1]) candy[i] = Math.max(candy[i], candy[i+1] + 1);
        }
        
        if(ratings[1] < ratings[0]) candy[0] = candy[1] + 1;
        
        int ans = 0;
        
        for(int i=0; i < candy.length; i++) ans += candy[i];
        
        return ans;
    }
}
