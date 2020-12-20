class Solution {
    public int hIndex(int[] citations) {
        
        if(citations.length == 0) return 0;
        if(citations.length == 1) return citations[0] == 0 ? 0 : 1;
        
        int l = 0;
        int r = citations.length - 1;
        while(l <= r) {
            int mid = l + (r - l)/2;
            
            if(citations[mid] == citations.length - mid) return citations[mid];
            
            if(citations[mid] > citations.length - mid) r = mid - 1;
            else l = mid + 1;
        }
        
        return citations.length - l;
        
    }
}
