class Solution {
    Set<Character> starting = new HashSet<>();
    public boolean isSolvable(String[] words, String result) {
        
        int total_char[] = new int[26];
        
        for(String word: words) {
            for(int i=0; i< word.length(); i++) {
                total_char[word.charAt(i) - 'A'] = 1;
                if(i == 0) starting.add(word.charAt(i));
            }
        }
        for(int i=0; i<result.length(); i++) {
            total_char[result.charAt(i) - 'A'] = 1;
            if(i == 0) starting.add(result.charAt(i));
        }
        
        String uniqueString = "";
        for(int i=0; i< 26; i++) {
            if(total_char[i] > 0)
                uniqueString = uniqueString + (char)('A' + i);
        }
        return backtrack(uniqueString, words, result, 0, new boolean[10], new int[26]); 
    }
    
    public boolean backtrack(String uniqueString, String[] words, String result, 
                                int i, boolean[] used, int[] map) {
        
        if(i == uniqueString.length()) {
            if(check(map, words, result)) return true;
            else return false;
        }
        
        for(int j=0; j<=9; j++) {
            if(!used[j]) {
                if(j == 0 && starting.contains(uniqueString.charAt(i)))
                    continue;
                map[uniqueString.charAt(i) - 'A'] = j;
                used[j] = true;
                if(backtrack(uniqueString, words, result, i+1, used, map)) 
                        return true;
                used[j] = false;
            }
        }
        return false;
    }
    
    public boolean check(int map[], String[] words, String result) {
        
        int left = 0;
        int right = 0;
        
        for(String word: words) {
            int add = 0;
            for(int i=0; i< word.length(); i++) {
                add = add*10 + map[word.charAt(i) - 'A'];
            }
            left += add;
        }
        for(int i=0; i<result.length(); i++)
            right = right*10 + map[result.charAt(i) - 'A'];
        
        return left == right;
    }
}

/*
    THISOFUNY

    THIS IS TOO = FUNNY
    T = 2         F = 1
    H = 1         U = 1
    I = 2         N = 2
    S = 2         Y = 1
    O = 2


    T = 0 - 9
    H = 0 - 9
    I = 0 - 9
    S = 0 - 9
    0 = 0 - 9 
    


*/















