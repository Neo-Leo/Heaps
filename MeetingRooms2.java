/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/meeting-rooms-ii/
 */ 


class point {
    int val; 
    boolean isStart; 
    point(int val, boolean isStart){
        this.val = val; 
        this.isStart = isStart; 
    }
}

public class MeetingRooms2 {
    public int minMeetingRooms(Interval[] intervals) {
        int maxIntervals = 0, currIntervals=0; 
        if(intervals == null || intervals.length == 0) return 0; 
        List<point> points = new ArrayList<point>(); 
        for(Interval i : intervals){
            points.add(new point(i.start, true));
            points.add(new point(i.end, false));
        }
        Collections.sort(points, new Comparator<point>(){
            public int compare(point p1, point p2){
                if(p1.val == p2.val) {
                    if(!p1.isStart && p2.isStart) return -1; 
                    else if (!p2.isStart && p1.isStart) return 1;
                }
                return p1.val -p2.val; 
            }
        }); 
        
        for(point p : points){
            if(p.isStart){
                currIntervals++; 
            } else {
                currIntervals--; 
            }
            maxIntervals = Math.max(maxIntervals, currIntervals); 
        }
        return maxIntervals; 
    }
}