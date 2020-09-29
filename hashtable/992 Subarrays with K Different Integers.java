class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        if(A == null || A.length == 0) return 0;
        
        Window window1 = new Window();
        Window window2 = new Window();
        
        int ans = 0, left1 = 0, left2 = 0, right = 0;
        
        while(right < A.length) {
            
            int x = A[right];
            window1.add(x);
            window2.add(x);
            
            while(window1.unique > K)
                window1.remove(A[left1++]);
            while(window2.unique >= K)
                window2.remove(A[left2++]);
            
            ans += left2  - left1;
                
            right++;
        }
        
        return ans;
    }
}

class Window {
    Map<Integer, Integer> count;
    int unique;
    
    public Window() {
        count = new HashMap<>();
        unique = 0;
    }
    
    public void add(int i) {
        if(!count.containsKey(i) || count.get(i) == 0) unique++;
        count.put(i, count.getOrDefault(i, 0) + 1);
    }
    
    public void remove(int i) {
        if(count.get(i) == 1) unique--;
        count.put(i, count.get(i) - 1);
    }
}


