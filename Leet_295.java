/*
295. Find Median from Data Stream

The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
 */

import java.util.ArrayList;
public class Leet_295 {
    ArrayList<Integer>list=new ArrayList<>();;
    
    public void addNum(int num) 
    {
        if(list.size()==0)
            list.add(num);
        
        else if(list.size()==1)
        {
            if(list.get(0)>num)
                list.add(0,num);
            else
                list.add(num);
        }
            
        else
        {
            int ind=find(num);
            if(num>list.get(ind))
                list.add(ind+1,num);
            else
                list.add(ind,num);
        }
        
    }
    
    public int find(int num)
    {
        int l=0, h=list.size()-1;
        int mid=-1;
        while(l<=h)
        {
            mid=(l+h)/2;
            
            if(num==list.get(mid))
                return mid;
            
            else if(num<list.get(mid))
            {
                h=mid-1;
            }
            else if(num>list.get(mid))
            {
                l=mid+1;
            }
        }
        return mid;
    }
    
    public double findMedian() {
        if(list.size()%2!=0)
        {
            return list.get(list.size()/2)*1.0;
        }
        else
        {
            double n1=list.get(list.size()/2);
            double n2=list.get(list.size()/2 - 1);
            return 1.0*((n1+n2)/2);
        }
    }
}
