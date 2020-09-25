class Solution {
    public String minWindow(String s, String t) {
        if(t.length() == 0 || t.length() > s.length()) return "";
        
        Map<Character, Integer> s_count = new HashMap<>();
        Map<Character, Integer> t_count = new HashMap<>();
        
        for(int i=0; i< t.length(); i++)
            t_count.put(t.charAt(i), t_count.getOrDefault(t.charAt(i), 0) + 1);
        
        
        int left = 0;
        int  right = -1;
        int min = Integer.MAX_VALUE;
        int min_idx[] = {-1, -1};
        
        while(right < s.length()) {
            while(contains(s_count, t_count)) {
                if(right - left + 1 < min) {
                    min = right - left + 1;
                    min_idx[0] = left;
                    min_idx[1] = right;
                }
                s_count.put(s.charAt(left), s_count.get(s.charAt(left)) - 1);
                left++;
            }
            right++;
            if(right< s.length()) s_count.put(s.charAt(right), s_count.getOrDefault(s.charAt(right), 0) + 1);
        }
        
        if(min_idx[0] == -1) return "";
        
        StringBuilder builder = new StringBuilder();
        for(int i=min_idx[0]; i<= min_idx[1]; i++) 
            builder.append(s.charAt(i));
        
        return builder.toString();
    }
    
    public boolean contains(Map<Character, Integer> s_count, Map<Character, Integer> t_count) {
        
        for(Character c: t_count.keySet()) {
            if(s_count.containsKey(c)) {
                if(s_count.get(c) < t_count.get(c)) return false;
            } else return false;
        }
        return true;
    }
}
