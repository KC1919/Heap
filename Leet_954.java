/*
954. Array of Doubled Pairs

Given an integer array of even length arr, return true if it is possible to reorder arr such that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2, or false otherwise.

 

Example 1:

Input: arr = [3,1,3,6]
Output: false
Example 2:

Input: arr = [2,1,2,6]
Output: false
Example 3:

Input: arr = [4,-2,2,-4]
Output: true
Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
Example 4:

Input: arr = [1,2,4,16,8,4]
Output: false
 */

import java.util.*;
public class Leet_954 {
    public boolean canReorderDoubled(int[] ar) 
    {
        HashMap<Integer,Integer>hm=new HashMap<>();
        int k=0;
        int n=ar.length;
        Integer arr[]=new Integer[n]; //making an array to store the elements and sort them, treating all the elements as positive
        
        for(int ele:ar)
        {
            hm.put(ele,hm.getOrDefault(ele,0)+1); //mapping the element in the hashmap, with their frequency
            arr[k++]=ele;   //and also putting the element in the Integer array to sort them customly
        }
        
        //this will sort the array treating all the elements as positive
        //if the array is like [-4,2,-8,1] and we do normal sorting,
        //the array would become [-8,-4,1,2],
        //but as we are treating all the elements as positive and then sorting on that basis
        //so the output array after getting sorted would become [1,2,(-4),(-8)]
        //so this will help us assure to get twice the number ahead of the current number

        Arrays.sort(arr,(a,b)->{return Math.abs(a)-Math.abs(b);});
        
        for(int ele:arr)
        {
            if(hm.get(ele)==0) //we check if the elements frequency has become 0
                continue;      //we continue to the next element
            
            if(hm.getOrDefault(2*ele,0)<=0)  //we check if the 2*ele is no found in the hashmap
                return false;    //we return false, means all elements can't be paired
           
            //if not so
            hm.put(ele,hm.get(ele)-1);  //then we decrease the frequency of "ele" by 1
            hm.put(2*ele,hm.get(2*ele)-1); //and also decrese the frequency of "2*ele" by 1, as they both have paired up, so cant be taken by any other element
        }
        
        return true;
    }
}
