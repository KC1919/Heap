/*
1424. Diagonal Traverse II

Given a list of lists of integers, nums, return all elements of nums in diagonal order as shown in the below images.
 

Example 1:

Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,4,2,7,5,3,8,6,9]
Example 2:



Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
Example 3:

Input: nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
Output: [1,4,2,5,3,8,6,9,7,10,11]
Example 4:

Input: nums = [[1,2,3,4,5,6]]
Output: [1,2,3,4,5,6]
 */

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
public class Leet_1424 {
    
    public int[] findDiagonalOrder(List<List<Integer>> nums) 
    {
        HashMap<Integer,List<Integer>>hm=new HashMap<>();
        int len=0;
        
        for(int i=0;i<nums.size();i++)
        {
            for(int j=0;j<nums.get(i).size();j++)
            {
                int idx=i+j;
                hm.putIfAbsent(idx,new ArrayList<>());
                int ele=nums.get(i).get(j);
                List<Integer>temp=hm.get(idx);
                temp.add(0,ele);
                hm.put(idx,temp);
                len++;
            }
        }
        
        int ans[]=new int[len];
        int k=0;
        
        for(int i=0;i<hm.size();i++)
        {
            List<Integer>list=hm.get(i);
            
            while(list.size()>0)
            {
                ans[k++]=list.remove(0);
            }
        }
        
        return ans;
    }
}
