/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/find-median-from-data-stream/
 */ 


class MedianFinder {
    
     PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder()); // Min Heap
     PriorityQueue<Integer> min = new PriorityQueue<Integer>(); //Max Heap 
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        max.add(num);
        min.add(max.poll());
        if(min.size() > max.size())
            max.add(min.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(max.size() > min.size()) return max.peek();
        else return (max.peek() + min.peek())/2.0;
    }
};