/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
Show Company Tags
Show Tags
Show Similar Problems


*/


public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(nums == null || nums.length == 0){
            return res;
        }
    
        List<Integer> r = new ArrayList<>();
        
        boolean[] checked = new boolean[nums.length];
        
        dfs(nums, 0 , res, r, checked);
        
        return res;
        
    }
    
    private void dfs(int[] nums, int pos, List<List<Integer>> res, List<Integer> r, boolean[] checked){
        

        if(r.size() == nums.length){
            res.add(new ArrayList<Integer>(r));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            
            if(checked[i] == false){
            
                r.add(nums[i]);
                checked[i] = true;
                dfs(nums, i + 1, res, r, checked);
                r.remove(r.size() - 1);
                checked[i] = false;
            }
        }
    }
}
