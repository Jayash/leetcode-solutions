class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null) return intervals;
        if(intervals.length == 0) return new int[][]{newInterval};
        
        List<int[]> ans = new ArrayList<>();
        int i=0;
        boolean inserted = false;
        while(i < intervals.length) {
            if(inserted) {
                if(ans.get(ans.size() -1)[1] < intervals[i][0]) {
                    ans.add(intervals[i]);
                } else {
                    int[] last = ans.remove(ans.size() -1);
                    ans.add(new int[]{last[0], Math.max(intervals[i][1], last[1])});  
                }
                i++;
            } else {
                if(intervals[i][0] < newInterval[0]) {
                    if(ans.size() == 0 || ans.get(ans.size() - 1)[1] < intervals[i][0])
                        ans.add(intervals[i]);
                    else {
                        int[] last = ans.remove(ans.size() -1);
                        ans.add(new int[]{last[0], Math.max(intervals[i][1], last[1])});  
                    }
                    i++;
                } else {
                    if(ans.size() == 0 || ans.get(ans.size() - 1)[1] < newInterval[0])
                        ans.add(newInterval);
                    else {
                        int[] last = ans.remove(ans.size() -1);
                        ans.add(new int[]{last[0], Math.max(newInterval[1], last[1])});
                    }
                    inserted = true;
                }
            }
        }
        
        if(!inserted) {
            if(ans.size() == 0 || ans.get(ans.size() - 1)[1] < newInterval[0])
                ans.add(newInterval);
            else {
                int[] last = ans.remove(ans.size() -1);
                ans.add(new int[]{last[0], Math.max(newInterval[1], last[1])});
            }
        }
        
        return ans.toArray(new int[ans.size()][2]);
    }
}
