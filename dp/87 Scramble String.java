class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1 == null) return s2 == null;
        if(s1.length() != s2.length()) return false;
        
        return isScramble(s1, s2, new HashSet<String>());
    }
    
    public boolean isScramble(String s1, String s2, Set<String> visited) {
        
        if(s1.equals(s2)) return true;
        
        if(visited.contains(s1 + "-" + s2) || visited.contains(s2 + "-" + s1)) return false;
        
        for(int i=1; i< s1.length(); i++) {
            String newS1Left = s1.substring(0, i);
            String newS1Right = s1.substring(i, s1.length());
            
            int idx = s1.length() - i;
            
            String newS2Right = s2.substring(idx, s2.length());
            String newS2Left = s2.substring(0, idx);
            
            if(isScramble(newS1Left, newS2Right, visited) && 
               isScramble(newS1Right, newS2Left, visited)) return true;
            
            newS1Left = s1.substring(0, i);
            newS1Right = s1.substring(i, s1.length());
            
            newS2Right = s2.substring(i, s2.length());
            newS2Left = s2.substring(0, i);
            
            
            if(isScramble(newS1Left, newS2Left, visited) && 
               isScramble(newS1Right, newS2Right, visited)) return true;
            
            
        }
        
        
        visited.add(s1 + "-" + s2);
        visited.add(s2 + "-" + s1);
        
        return false;
    }
}
