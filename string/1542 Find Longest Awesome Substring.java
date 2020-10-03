class Solution {
    public int longestAwesome(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        
        int mask = 0;
        int max = 1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0; i< s.length(); i++) {
            int digit = (int)(s.charAt(i) - '0');
            
            mask ^= (1 << digit);
            
            if(map.containsKey(mask))
                max = Math.max(max, i - map.get(mask));

            for(int j=0; j< 10; j++) {
                int temp_mask = mask ^ (1 << j);
                if(map.containsKey(temp_mask))
                    max = Math.max(max, i - map.get(temp_mask));
            }
            
            map.put(mask, map.getOrDefault(mask, i));
        }
        
        return max;
    }
    
}
