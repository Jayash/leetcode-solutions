class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        if(words == null || words.length == 0) return new ArrayList<Integer>();
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(String word : words) {
            int mask = 0;
            for(int i=0; i< word.length(); i++)
                mask |= (1 << word.charAt(i) - 'a');
            
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(String puzzle : puzzles)
            res.add(getNumOfValidWords(puzzle, map));
        
        return res;
    }
    
    public int getNumOfValidWords(String puzzle, Map<Integer, Integer> map) {
        
        int mask = 0;
        int num = 0;
        
        for(int i=0; i<puzzle.length(); i++)
            mask |= (1 << puzzle.charAt(i) - 'a');
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(mask);
        Set<Integer> visited = new HashSet<>();
        visited.add(mask);
        
        while(!queue.isEmpty()) {
            int m = queue.poll();
            
            if(map.containsKey(m)) num += map.get(m);
            
            for(int i = 0; i< 26; i++) {
                if(i != puzzle.charAt(0) - 'a' && ((m & (1 << i)) != 0)) {
                    int next = m & ~(m & (1 << i));
                    if(!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
        }
        
        return num;
    }
}
