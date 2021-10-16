/*
347. Top K Frequent Elements

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */

import java.util.*;

public class Leet_347 
{

    public int[] topKFrequent(int[] nums, int k) 
    {
        class Pair {
            int val;
            int freq;

            Pair(int val, int freq) {
                this.val = val;
                this.freq = freq;
            }
        }

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) 
        {
            if (!hm.containsKey(nums[i]))
                hm.put(nums[i], 1);

            else
                hm.put(nums[i], hm.get(nums[i]) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return a.freq - b.freq;
        });

        int j = 0;

        for (Map.Entry<Integer, Integer> ele : hm.entrySet()) 
        {
            pq.add(new Pair(ele.getKey(), ele.getValue()));
        }

        while (pq.size() != k) 
        {
            pq.remove();
        }

        int res[] = new int[k];

        while (pq.size() > 0) 
        {
            res[j++] = pq.remove().val;
        }

        return res;
    }
}
