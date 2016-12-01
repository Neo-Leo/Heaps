/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */ 

public class KthLargestElement {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int l = left + 1, r=right;
        while(l <= r){
            while ((l<=r) && nums[l] >= pivot) l++; 
            while ((l<=r) && nums[r] < pivot) r--;
            if (l <= r)
                swap(nums, l++, r--);
        }
        swap(nums, left, r);
        return r;
    }
    
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0)
            return -1;
        // 1. Sort the array.  O(nlogn) Time
        /*
        Arrays.sort(nums);
        return[nums.length - k]; 
        */
        // 2. Use Min Heap O(nlogk) Time and O(k) space
        /*
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
        for(int i=0; i<k; i++)
            pq.add(nums[i]);
            
        for(int i=k; i<=nums.length-1; i++) {
            if(pq.peek() < nums[i]) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }    
        return pq.peek();
        */
        // 3. Average case time complexity O(n)
        
        int left = 0, right = nums.length-1;
        while(true){
            int pos = partition(nums, left, right);
            if(pos == k-1) return nums[pos];
            if(pos > k-1) right = pos-1; // Search on left. 
            else left = pos+1; // Search on right.
        }
    }
}