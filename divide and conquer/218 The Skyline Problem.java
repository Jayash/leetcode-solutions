class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        if(buildings.length == 0) return ans;
        return divide(buildings, 0, buildings.length - 1);
    }
    
    public List<List<Integer>> divide(int[][] buildings, int i, int j) {
        if(i == j) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<Integer>(Arrays.asList(buildings[i][0], buildings[i][2])));
            ans.add(new ArrayList<Integer>(Arrays.asList(buildings[i][1], 0)));
            return ans;
        }
        
        List<List<Integer>> left = divide(buildings, i, i + (j-i)/2);
        List<List<Integer>> right = divide(buildings, i + (j - i)/2 + 1, j);
        return merge(left, right);
    }
    
    public List<List<Integer>> merge(List<List<Integer>> left, List<List<Integer>> right) {
        List<List<Integer>> ans = new ArrayList<>();
        
        int l = 0;
        int r = 0;
        int skyline = 0;
        int h1 = 0;
        int h2 = 0;
        int curLocation = 0;
        while(l < left.size() && r < right.size()) {
            
            if(left.get(l).get(0) < right.get(r).get(0)) {
                h1 = left.get(l).get(1);
                curLocation = left.get(l).get(0);
                l++;
            } else if(left.get(l).get(0) > right.get(r).get(0)) {
                h2 = right.get(r).get(1);
                curLocation = right.get(r).get(0);
                r++;
            } else {
                h1 = left.get(l).get(1);
                h2 = right.get(r).get(1);
                curLocation = right.get(r).get(0);
                l++; r++;
            }
            
            if(skyline != Math.max(h1, h2)) {
                skyline = Math.max(h1, h2);
                ans.add(new ArrayList<Integer>(Arrays.asList(curLocation, skyline)));
            }
        }
        
        while(l < left.size()) {
            ans.add(left.get(l));
            l++;
        }
        while(r < right.size()) {
            ans.add(right.get(r));
            r++;
        }
        return ans;
    }
}

/*

    






*/
