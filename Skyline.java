/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/the-skyline-problem/
 */ 

class point {
    int x; 
    int y; 
    boolean isStart; 
    point(int x, int y, boolean isStart){
        this.x = x; 
        this.y = y;
        this.isStart = isStart; 
    }
}
public class Skyline {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> list = new ArrayList<int[]>(); 
        if(buildings == null || buildings.length == 0) return list; 
        int n = buildings.length; 
        List<point> points = new ArrayList<point>(); 
        for(int[] building : buildings){
            points.add(new point(building[0],building[2],true));
            points.add(new point(building[1],building[2],false));
        }
        //Preparing this for sweep line
        Collections.sort(points, new Comparator<point>(){
            public int compare(point a, point b) { 
                if(a.x != b.x) {
                    return a.x-b.x;
                } else {
                    if(a.isStart && b.isStart) {
                        return b.y - a.y;
                    } else if(!a.isStart && !b.isStart) {
                        return a.y - b.y;
                    } else {
                        if(a.isStart) return -1;
                        else return 1; 
                    } 
                }
            }
        }); 
        
        // Create a Max Heap 
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        pq.offer(0);
        for(point p : points){
            if(p.isStart) { // If it is the starting 
                if (p.y > pq.peek()) {
                    int[] arr = new int[2];
                    arr[0] = p.x; arr[1] = p.y;
                    list.add(arr);
                } 
                pq.offer(p.y);
            } else { // If it is the end 
                int max = pq.peek(); 
                pq.remove(p.y);
                if(max != pq.peek()) {
                    int[] arr = new int[2];
                    arr[0] = p.x; arr[1] = pq.peek();
                    list.add(arr);
                }
            }
        }
        return list; 
    }
}