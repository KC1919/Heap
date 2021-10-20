/*
1218. Longest Arithmetic Subsequence of Given Difference

Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.

A subsequence is a sequence that can be derived from arr by deleting some or no elements without changing the order of the remaining elements.


Example 1:

Input: arr = [1,2,3,4], difference = 1
Output: 4
Explanation: The longest arithmetic subsequence is [1,2,3,4].
Example 2:

Input: arr = [1,3,5,7], difference = 1
Output: 1
Explanation: The longest arithmetic subsequence is any single element.
Example 3:

Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
Output: 4
Explanation: The longest arithmetic subsequence is [7,5,3,1].
 */

import java.util.HashMap;
public class Leet_1218 
{
    public int longestSubsequence(int[] arr, int d) 
    {
        int max=0;
        
        HashMap<Integer,Integer>hm=new HashMap<>();
        
        for(int ele:arr)
        {
            hm.put(ele,hm.getOrDefault(ele-d,0)+1);
            max=Math.max(max,hm.get(ele));
        }
        return max;
    }
    
}
