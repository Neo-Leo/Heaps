/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/sliding-window-median/
 */ 

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> upperHalf = new PriorityQueue<>(); 
        PriorityQueue<Integer> lowerHalf = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length; 
        for(int i=0; i<=k-2; i++){
            addElement(lowerHalf, upperHalf, nums[i]); 
        }
        
        double[] medians = new double[n-k+1];
        
        for(int i=k-1; i<=n-1; i++) {
            addElement(lowerHalf, upperHalf, nums[i]);
            //Calculate the median
            if(lowerHalf.size() > upperHalf.size()){
                medians[i-k+1] = (double)lowerHalf.peek(); 
            } else {
                medians[i-k+1] = (((double)lowerHalf.peek() + upperHalf.peek()))/2;
            }
            deleteElement(lowerHalf, upperHalf, nums[i-k+1]);
        }
        return medians; 
    }
    
    public void addElement(PriorityQueue<Integer> lowerHalf, PriorityQueue<Integer> upperHalf, int element){
        lowerHalf.offer(element);
        upperHalf.offer(lowerHalf.poll());
        if(upperHalf.size() > lowerHalf.size()){
            lowerHalf.offer(upperHalf.poll());
        }
    }
    
    public void deleteElement(PriorityQueue<Integer> lowerHalf, PriorityQueue<Integer> upperHalf, int element){
        if(lowerHalf.peek() >= element) {
            lowerHalf.remove(element); 
        } else {
            upperHalf.remove(element);
        }
        if(upperHalf.size() > lowerHalf.size()){
            lowerHalf.offer(upperHalf.poll());
        }
        if(lowerHalf.size() - upperHalf.size() > 1){
            upperHalf.offer(lowerHalf.poll());
        }
    }
}