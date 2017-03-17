/*

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(nums == null || nums.length == 0){
            return res;
        }
        
        boolean[] checked = new boolean[nums.length];
        
        
        Arrays.sort(nums);
        
        helper(nums, new ArrayList<Integer>(), res, checked);
        
        return res;
        
    }
    
    private void helper(int[] nums,List<Integer> r, List<List<Integer>> res, boolean[] checked){
        
        if(r.size() == nums.length){
            
            res.add(new ArrayList<Integer>(r));
            
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            
            if(checked[i] || (i > 0 && nums[i] == nums[i - 1] && !checked[i - 1])){
                continue;
            }

            
            r.add(nums[i]);
            checked[i] = true;
            helper(nums, r, res, checked);
            checked[i] = false;
            r.remove(r.size() - 1);
                
            
        }
    }
}
