class Solution {
    public String shortestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        
        String rev = new StringBuilder(s).reverse().toString();
        String newS = s + "#" + rev;
        
        int table[] = new int[newS.length()];
        Arrays.fill(table, -1);
        int i = 1;
        int j = 0;
        while(i < newS.length()) {
            if(newS.charAt(i) == newS.charAt(j)) {
                table[i] = j;
                j++;
                i++;
            } else {
                if(j > 0) j = table[j-1] + 1;
                else i++;
            }
        }
        
        return rev.substring(0, s.length() - table[newS.length() -1] - 1) + s;
        
    }
}


/*   a  a  c  e  c  a  a  a
     0  1  2  3  4  5  6  7
    -1  0 -1 -1 -1  0  1  1

    aaacecaa
    
    aacecaaa


    abacd # dcaba

*/
