class Solution {
    public int findRotateSteps(String ring, String key) {
        if(key == null || key.length() == 0) return 0;
        
        Map<Character, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i< ring.length(); i++) {
            if(map.containsKey(ring.charAt(i))) {
                map.get(ring.charAt(i)).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(ring.charAt(i), list);
            }
        }
        int memo[][] = new int[key.length()][ring.length()];
        return solve(key, 0, map, 0, ring, memo) + key.length();
    }
    
    public int solve(String key, int i, Map<Character, List<Integer>> map, int curr, 
                     String ring, int[][] memo) {
        if(i == key.length()) return 0;
        if(memo[i][curr] != 0) return memo[i][curr];
        List<Integer> list = map.get(key.charAt(i));
        
        int ans = Integer.MAX_VALUE;
        
        for(int pos: list) {
            int len = ring.length();
            int minDis = Math.min(Math.min(Math.abs(pos-curr),
                            Math.abs(curr-(pos+len))), Math.abs((curr+len)-pos));
            
            ans = Math.min(ans, minDis + solve(key, i+1, map, pos, ring, memo));
            
        }
        
        
        memo[i][curr] = ans;
        return ans;
    }
}
