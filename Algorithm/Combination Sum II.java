/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

*/

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Set<List<Integer>> temp = new HashSet<>();
        
        if(candidates == null || candidates.length == 0){
          	return new ArrayList<List<Integer>>();
        }
        
        List<Integer> r = new ArrayList<Integer>();
        
        Arrays.sort(candidates);
        
        helper(candidates, temp, r, target,0, 0);
        
        
        List<List<Integer>> res = new ArrayList<>(temp);
        
        return res;
    }
    
    
    private void helper(int[] candidates, Set<List<Integer>> res, List<Integer> r, int target, int result, int pos){
        
        if(result > target || pos > candidates.length){
            return;
        }
        
        if(result == target){
            res.add(new ArrayList<Integer>(r));
            return;
        }
        
        
        
        for(int i = pos ; i < candidates.length; i++){
            r.add(candidates[i]);
            helper(candidates, res, r, target, result + candidates[i], i + 1);
            r.remove(r.size() - 1);
        }
        
    }
}
