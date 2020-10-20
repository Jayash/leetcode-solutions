class Solution {
    public String removeDuplicateLetters(String s) {
        if(s.length() == 0) return s;
        
        int last_index[] = new int[26];
        boolean used[] = new boolean[26];
        for(int i=0; i< s.length(); i++)
            last_index[s.charAt(i) - 'a'] = i;
        
        List<Character> stack = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< s.length(); i++) {
            
            if(!used[s.charAt(i) - 'a']) {
                

                while(!stack.isEmpty()) {
                    if(stack.get(stack.size() - 1) > s.charAt(i)) {

                        if(last_index[stack.get(stack.size() - 1) - 'a'] > i) {
                            used[stack.get(stack.size() - 1) - 'a'] = false;
                            stack.remove(stack.size() - 1);
                        } else break;
                    } else break;
                }
                
                stack.add(s.charAt(i));
                used[s.charAt(i) - 'a'] = true;
                
            }
            
            
        }
        for(Character c  :stack)
            sb.append(c);
        
        return sb.toString();
    }
}
