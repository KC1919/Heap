import java.util.*;
class Leet_692
{
    public List<String> topKFrequent(String[] words, int k) 
    {
        HashMap<String,Integer>hm=new HashMap<>();
        
        for(int i=0;i<words.length;i++)
            hm.put(words[i],hm.getOrDefault((words[i]),0)+1);
        
        PriorityQueue<String>pq=new PriorityQueue<>((a,b)->{
            if(hm.get(a)==hm.get(b))  //if the frequency of both the words is same,then the word which is lexicographically bigger will be returned
                return b.compareTo(a);
            
            return hm.get(a)-hm.get(b); //the wrod with less frequency will be returned
        });
        
        for(Map.Entry<String,Integer> ele:hm.entrySet())
        {
            pq.add(ele.getKey()); //adding the word to the PriorityQueue
            if(pq.size()>k)   //once k words have been added, then we start removing based on the priority queue removal criteria
                pq.remove();
        }

        // and at the end we are left with top k most frequent words in the priority queue
        
        List<String>list=new ArrayList<>();
        
        while(pq.size()>0)   //we add those words to the list and return
            list.add(0,pq.remove());
        
        return list;
    }
}