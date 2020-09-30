class Solution {
    public int findKthNumber(int m, int n, int k) {
          
        int low = 1;
        int high = m*n;
        
        while(low < high) {
            int mid = low + (high - low)/2;
            if(count(mid, m, n) >= k) high = mid;
            else low = mid + 1;
        }
        return low;
    }
    
    public int count(int mid, int m, int n) {
        
        int count = 0;
        for(int i=1; i <= m; i++) {
            
            while(mid < n*i) n--;
            
            if(n != 0) count += n;
            else break;
            
        }
        return count;
    }
}
