class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if(words.length == 0) return ans;
        
        int wordLength = words[0].length();
        
        TrieNode root = new TrieNode();
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String word: words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        
        for(String word: map.keySet())
            addToTrie(word, root);
        
        List<String> matches = new ArrayList<>();
        for(int i=0; i <= s.length() - wordLength; i++)
            matches.add(find(s, root, i, wordLength));
        
        int totalWordChar = words.length * wordLength;
        for(int i=0; i <= s.length() - totalWordChar; i++) {
            if(check(s, wordLength, matches, words.length, i, map)) ans.add(i);
        }
        return ans;
    }
    
    public boolean check(String s, int wordLength, List<String> matches, 
                         int totalWords, int i, Map<String, Integer> map) {
        
        if(matches.get(i) == null) return false;
        Map<String, Integer> clone = new HashMap<>();
        for(int j = 0; j < totalWords; j++) {
            if(matches.get(i) == null) return false;
            
            clone.put(matches.get(i), clone.getOrDefault(matches.get(i), 0) + 1);
            
            i += wordLength;
        }
        
        return map.equals(clone);
    }
    
    public String find(String s, TrieNode root, int i, int wordLength) {
        TrieNode node = root;
        for(int j=i; j< i+wordLength; j++) {
            if(node.trie.containsKey(s.charAt(j))) 
                node = node.trie.get(s.charAt(j));
            else break;
        }
        return node.word;
    }
    
    public void addToTrie(String word, TrieNode root) {
        TrieNode node = root;
        for(int j=0; j< word.length(); j++) {
            if(!node.trie.containsKey(word.charAt(j)))
                node.trie.put(word.charAt(j), new TrieNode());
            node = node.trie.get(word.charAt(j));
        }
        node.word = word;
    }
}

class TrieNode {
    Map<Character, TrieNode> trie = new HashMap<>();
    String word;
}
