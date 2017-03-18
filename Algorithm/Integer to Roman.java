/*

Total Accepted: 97008
Total Submissions: 223167
Difficulty: Medium
Contributors: Admin
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

Show Company Tags
Show Tags
Show Similar Problems


*/


public class Solution {
    public String intToRoman(int num) {
        
        
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90 ,50, 40, 10, 9 ,5 , 4, 1};
        
        String[] strs = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < nums.length; i++){
            
            while(num >= nums[i]){
                
                num -= nums[i];
                
                sb.append(strs[i]);
                
            }
            
        }
        
        return sb.toString();
    }
}

/*
Total Accepted: 136359
Total Submissions: 307521
Difficulty: Easy
Contributors: Admin
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

*/




public class Solution {
    public int romanToInt(String s) {
        
        int[] nums = new int[s.length()];
        
        for(int i = 0; i < nums.length; i++){
            
        switch(s.charAt(i)){
        case 'M':
					nums[i]=1000;
					break;
				case 'D':
					nums[i]=500;
					break;
				case 'C':
					nums[i]=100;
					break;
				case 'L':
					nums[i]=50;
					break;
				case 'X' :
					nums[i]=10;
					break;
				case 'V':
					nums[i]=5;
					break;
				case 'I':
					nums[i]=1;
					break;
            }
            
        }
        
        int num = 0;
        
        for(int i = 0; i < nums.length - 1; i++){
            
            if(nums[i] < nums[i + 1]){
                num -= nums[i];
            }else{
                num += nums[i];
            }
        }
        
        num += nums[nums.length - 1];
        
        return num;
    }
}
