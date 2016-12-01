/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */ 

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) return null; 
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val; 
            }
        });
        
        for(ListNode node : lists){ //Takes O(k) to build a heap, assuming k elements in a heap
            if(node != null)
                pq.offer(node);
        }
        ListNode head = null, prev=null, curr=null; 
        while(!pq.isEmpty()){
            curr = pq.poll();
            if(head == null){
                head = curr; 
            } else {
                prev.next = curr; 
            }
            prev = curr; 
            
            if(curr.next != null){
                pq.offer(curr.next); 
            }
        }
        return head;
    }
}   