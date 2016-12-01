/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 */ 

class Elem {
    int first; 
    int second;
    int sum; 
    Elem(int first, int second){
        this.first = first; 
        this.second = second; 
    }
}

public class KPairWithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new LinkedList<int[]>(); 
        if(nums1 == null || nums1.length == 0|| nums2 == null || nums2.length == 0) return list;
        PriorityQueue<Elem> pq = new PriorityQueue<Elem>( new Comparator<Elem>(){
            public int compare(Elem e1, Elem e2) {
                return e1.sum - e2.sum; 
            }
        }); 
        
        for(int i=0; i<=Math.min(nums1.length-1,k-1); i++) {
            Elem e = new Elem(i,0);
            e.sum = nums1[e.first] + nums2[e.second];
            pq.offer(e);
        }
        
        while(k >= 1 && !pq.isEmpty()){
            Elem e = pq.poll(); 
            int[] arr = new int[2];
            arr[0] = nums1[e.first];
            arr[1] = nums2[e.second];
            list.add(arr);
            if(e.second <= nums2.length-2){
                e = new Elem(e.first,e.second+1);
                e.sum = nums1[e.first] + nums2[e.second]; 
                pq.offer(e); 
            }
            k--; 
        }
    return list;
    }
}