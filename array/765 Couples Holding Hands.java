class Solution {
    public int minSwapsCouples(int[] row) {
        if(row == null || row.length < 3) return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< row.length; i++)
            map.put(row[i], i);
        
        int ans = 0;
        for(int i=0; i< row.length; i+=2) {
            if(row[i]%2 == 0) {
                if(row[i+1] != row[i] + 1) {
                    ans++;
                    swap(row, i+1, map.get(row[i] + 1), map);
                }
            } else {
                if(row[i+1] != row[i] - 1) {
                    ans++;
                    swap(row, i+1, map.get(row[i] - 1), map);
                }
            }
        }
        return ans;
    }
    
    public void swap(int[] row, int i, int j, Map<Integer, Integer> map) {
        int temp = row[i];
        row[i] = row[j];
        row[j] = temp;
        map.put(row[i], i);
        map.put(row[j], j);
    }
}

/*

  3 5 7 9 0 1 2 4 6 8


*/
