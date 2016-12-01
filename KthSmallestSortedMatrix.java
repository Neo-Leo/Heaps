// Time to build heap = O(k) 
// Time for k delete and insert operations on the Heap = O(klogk) 
// Total time is dominated by O(klog(k))
// Revision 4th September

class node {
    int row; 
    int col; 
    int val; 
    node(int _row, int _col, int _val){
        row = _row; 
        col = _col; 
        val = _val; 
    }
}

public class KthSmallestSortedMatrix{
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<node> pq = new PriorityQueue<node>(new Comparator<node>(){
                public int compare(node a, node b){
                    return a.val - b.val; 
                }
        }); 
        int n = matrix[0].length; 
        for(int i=0; i<=Math.min(k-1,n-1); i++){
            pq.offer(new node(0, i, matrix[0][i]));
        }
        
        for(int i=1; i<=k-1; i++){
            node curr = pq.poll(); 
            if(curr.row == n-1)
                continue; 
            pq.offer(new node(curr.row+1, curr.col, matrix[curr.row+1][curr.col])); 
        }
        return pq.poll().val; 
    }
}