class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates.length == 0) return result;
        //Arrays.sort(candidates);
        
        combinationSum(candidates, target, result, 0, new ArrayList<Integer>());
        
        return result;
    }
    
    public void combinationSum(int[] candidates, int target, List<List<Integer>> result, int idx, List<Integer> current) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        if(target < 0) return;
        
        for(int i=idx; i<candidates.length; i++) {
            current.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], result, i, current);
            current.remove(current.size() -1);
        }
    }
}
