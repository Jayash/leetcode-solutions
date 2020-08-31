class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if(beginWord == null || endWord == null) return res;
        if(beginWord.length() != endWord.length()) return res;
        
        Set<String> wordSet = new HashSet<>();
        for(String word: wordList)
           wordSet.add(word); 
        
        Queue<List<String>> queue = new LinkedList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        queue.offer(list);
        
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            boolean flag = false;
            List<String> toAddInVisited = new ArrayList<>();
            while(size-- > 0) {
                List<String> words = queue.poll();
                
                String word = words.get(words.size() -1);

                List<String> nextWords = findNextWords(wordSet, word, visited);

                for(String nextWord: nextWords) {
                    toAddInVisited.add(nextWord);
                    List<String> clone = new ArrayList<String>(words);
                    if(nextWord.equals(endWord))  {
                        flag = true;
                        clone.add(endWord);
                        res.add(clone);
                    } else {
                        clone.add(nextWord);
                        queue.offer(clone);
                    }
                }
                        
            }
            
            visited.addAll(toAddInVisited);
            
            if(flag) break;
            
        }
        
        return res;
    }
    
    public List<String> findNextWords(Set<String> wordSet, String word, Set<String> visited) {
        
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder(word);
        for(int i=0; i< word.length(); i++) {
            
            for(char c='a'; c<= 'z'; c++) {
                String nextWord = sb.substring(0, i) + c + sb.substring(i+1);
                
                if(wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                    res.add(nextWord);
                }
            }
            
        }
        
        return res;
    }

}


/*

    hit hot dot lot
            dog
            log
            lot log cog
            
    hit hot lot log cog
        


*/
