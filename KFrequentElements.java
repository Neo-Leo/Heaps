/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/top-k-frequent-elements/
 */ 

public class KFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); 
        // O(n)
        for(int elem : nums){
            if(!hm.containsKey(elem)){
                hm.put(elem,1);
            } else {
                int count = hm.get(elem);
                hm.put(elem,count+1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b){
                return a.getValue() - b.getValue();    
            }
        }); 
        
        int i = 1; 
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            // O(klogk)
            if(i<=k) {
                pq.offer(entry);
            } else {
                //O((n-k)logk)
                pq.offer(entry);
                pq.poll();        
            }
            i++;        
        }
        
        
        List<Integer> resultList = new LinkedList<Integer>();
        while(pq.size()>0){
            resultList.add(pq.poll().getKey());
        }
        return resultList;
    }
}