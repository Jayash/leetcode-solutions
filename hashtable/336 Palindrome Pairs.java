class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i< words.length; i++)
            map.put(new StringBuilder(words[i]).reverse().toString(), i);
        
        for(int i=0; i< words.length; i++) {
            
            String word = words[i];
            
            for(int j=word.length() -1; j >= 0; j--) {
              if(isPallindrome(word, 0, j)) {
                    String substring = word.substring(j+1, word.length());
                    if(map.containsKey(substring)) {
                        ans.add(Arrays.asList(new Integer[]{map.get(substring), i}));
                    }
                }  
            }
            
            for(int j=0; j< word.length(); j++) {
                if(isPallindrome(word, j, word.length() -1)) {
                    String substring = word.substring(0, j);
                    if(map.containsKey(substring)) {
                        ans.add(Arrays.asList(new Integer[]{i, map.get(substring)}));
                    }
                }
            }
            
            if(map.containsKey(word) && map.get(word) != i)
                ans.add(Arrays.asList(new Integer[]{i, map.get(word)}));
            
            
        }
        return ans;
    }
    
    public boolean isPallindrome(String word, int i, int j) {
        while(i < j) {
            if(word.charAt(i) != word.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

}

/*

 abcd
 
 d c b a
 
 

*/
