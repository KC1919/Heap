
import java.util.PriorityQueue;
public class Leet_1464 
{
    public int maxProduct(int[] nums)   //O(N) time complexity
    {
        int max=nums[0];
        int smax=0;
        
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>max)
            {
                smax=max;
                max=nums[i];
            }
            else if(nums[i]>smax)
            {
                smax=nums[i];
            }
        }
        
        return (max-1)*(smax-1);
    }

    public int maxProduct_2(int[] nums)   //O(Nlog(2)) time complexity
    {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        
        for(int ele:nums)
        {
            pq.add(ele);
            if(pq.size()>2)
                pq.remove();
        }
        
        int f=pq.remove();
        int s=pq.remove();
        
        return (f-1)*(s-1);
    }
    
}
