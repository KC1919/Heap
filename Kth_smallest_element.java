/*
Given an array arr[] and an integer K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.

Example 1:

Input:
N = 6
arr[] = 7 10 4 3 20 15
K = 3
Output : 7
Explanation :
3rd smallest element in the given 
array is 7.
Example 2:

Input:
N = 5
arr[] = 7 10 4 20 15
K = 4
Output : 15
Explanation :
4th smallest element in the given 
array is 15.
*/

import java.util.PriorityQueue;
class Kth_smallest_element
{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        if(k<l-1 || k>r+1)
            return -1;
            
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->{return b-a;});
        
        for(int i=0;i<k;i++)
        {
            pq.add(arr[i]);
        }
        
        for(int i=k;i<arr.length;i++)
        {
            if(arr[i]<pq.peek())
            {
                 pq.add(arr[i]);
                 pq.remove();
            }
               
        }
        
        return pq.peek();
        
    } 
}