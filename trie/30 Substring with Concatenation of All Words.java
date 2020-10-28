class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if(words.length == 0) return ans;
        
        int wordLength = words[0].length();
        
        TrieNode root = new TrieNode();
        
        for(int i=0; i < words.length; i++) {
            addToTrie(words[i], root, i);
        }
        List<Set<Integer>> matches = new ArrayList<>();
        for(int i=0; i <= s.length() - wordLength; i++) {
            matches.add(find(s, root, i, wordLength));
        }
        
        int totalWordChar = words.length * wordLength;
        for(int i=0; i <= s.length() - totalWordChar; i++) {
            if(check(s, wordLength, matches, words.length, i)) ans.add(i);
        }
        return ans;
    }
    
    public boolean check(String s, int wordLength, List<Set<Integer>> matches, int totalWords, int i) {
        
        if(matches.get(i).isEmpty()) return false;
        Set<Integer> set = new HashSet<>();
        while(i <= s.length() - wordLength) {
            if(matches.get(i).isEmpty()) return false;
            
            boolean flag = true;
            for(int j: matches.get(i)) {
                if(!set.contains(j)) {
                    flag = false;
                    set.add(j);
                    break;
                }
            }
            if(flag) return false;
            if(set.size() == totalWords) return true;
            
            i += wordLength;
        }
        
        return false;
    }
    
    public Set<Integer> find(String s, TrieNode root, int i, int wordLength) {
        TrieNode node = root;
        for(int j=i; j< i+wordLength; j++) {
            if(node.trie.containsKey(s.charAt(j))) 
                node = node.trie.get(s.charAt(j));
            else break;
        }
        return node.index;
    }
    
    public void addToTrie(String word, TrieNode root, int i) {
        TrieNode node = root;
        for(int j=0; j< word.length(); j++) {
            if(!node.trie.containsKey(word.charAt(j)))
                node.trie.put(word.charAt(j), new TrieNode());
            node = node.trie.get(word.charAt(j));
        }
        node.index.add(i);
    }
    
    
}

class TrieNode {
    Map<Character, TrieNode> trie = new HashMap<>();
    Set<Integer> index = new HashSet<>();
}
