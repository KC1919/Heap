/*
451. Sort Characters By Frequency

Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

 

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 */

 import java.util.*;
public class Leet_451 
{
    public String frequencySort(String s) 
    {
        class Pair
        {
            char c;
            int freq;
            
            Pair(char c, int freq)
            {
                this.c=c;
                this.freq=freq;
            }
        }
        
        HashMap<Character,Integer>hm=new HashMap<>();
        
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{return b.freq-a.freq;});
        
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            
            if(hm.containsKey(ch))
            {
                hm.put(ch,hm.get(ch)+1);
            }
            else
                hm.put(ch,1);
        }
        
        for(Map.Entry<Character,Integer>ele:hm.entrySet())
        {
            pq.add(new Pair(ele.getKey(),ele.getValue()));
        }
        
        StringBuilder sb=new StringBuilder();
        
        while(pq.size()>0)
        {
            Pair rem=pq.remove();
            while(rem.freq!=0)
            {
                sb.append(rem.c);
                rem.freq--;
            }
            
        }
        
        return sb.toString();
    }
}
