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


/***********************************************************************************************************/
// using TreeSet

class Solution {
    public int findRotateSteps(String ring, String key) {
        if(key == null || key.length() == 0) return 0;
        
        Map<Character, TreeSet<Integer>> map = new HashMap<>();
        
        for(int i=0; i< ring.length(); i++) {
            if(map.containsKey(ring.charAt(i))) {
                map.get(ring.charAt(i)).add(i);
            } else {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(i);
                map.put(ring.charAt(i), set);
            }
        }
        
        return solve(key, 0, map, 0, ring, new int[key.length()][ring.length()]) + key.length();
    }
    
    public int solve(String key, int i, Map<Character, TreeSet<Integer>> map,
                     int curr, String ring, int[][] memo) {
        if(i == key.length()) return 0;
        
        if(memo[i][curr] != 0) return memo[i][curr];

        TreeSet<Integer> set = map.get(key.charAt(i));
        int appendForLeft = 0;
        int appendForRight = 0;
        Integer goLeft = set.floor(curr);
        if(goLeft == null) {
            goLeft = set.last();
            appendForLeft = curr + ring.length() - goLeft;
        } else appendForLeft = curr - goLeft;
        Integer goRight = set.ceiling(curr);
        if(goRight == null) {
            goRight = set.first();
            appendForRight = goRight + ring.length() - curr;
        } else appendForRight = goRight - curr;
        
        int ans = 0;
        if(goLeft == goRight) {
            ans =  appendForRight > appendForLeft ? appendForLeft + solve(key, i+1, map, goLeft, ring, memo) : 
                        appendForRight + solve(key, i+1, map, goRight, ring, memo);
        } else {
           ans = Math.min(appendForLeft + solve(key, i+1, map, goLeft, ring, memo), 
                         appendForRight + solve(key, i+1, map, goRight, ring, memo)); 
        }
        
        memo[i][curr] = ans;
        return ans;
    }
}
