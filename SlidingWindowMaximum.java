/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/sliding-window-maximum/
 */ 


public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k==0) return new int[0];
        int n = nums.length; 
        int[] res = new int[n-k+1]; 
        Deque<Integer> deque = new LinkedList<Integer>(); 
        for(int i=0; i<=n-1; i++) {
            
            if(!deque.isEmpty() && i - deque.peekFirst() == k){
                deque.pollFirst();
            }
            
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            
            deque.offerLast(i); 
            
            if(i>=k-1){
                res[i-k+1] = nums[deque.peekFirst()];        
            }
        }
        return res; 
    }
}