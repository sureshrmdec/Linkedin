/*

Total Accepted: 135768
Total Submissions: 513324
Difficulty: Hard
Contributors: Admin
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */






    public Iterable<Integer> mergeKSortedIterators(Iterator<Integer>[] iters){
        Queue<IntIter> minHeap = new PriorityQueue<IntIter>(iters.length, new iteratorComp());
        List<Integer> result = new ArrayList<Integer>();
        for(Iterator<Integer> iter : iters){
            if(iter.hasNext()){
                minHeap.add(new IntIter(iter));
            }
        }
        while(!minHeap.isEmpty()){
            IntIter curr = minHeap.poll();
            result.add(curr.next);
            if(curr.iter.hasNext()){
                minHeap.add(new IntIter(curr.iter));
            }
        }
        return result;
    }

    public class iteratorComp implements Comparator<IntIter> {
        public int compare(IntIter a, IntIter b){
            return a.next - b.next;
        }
    }

    public class IntIter {
        int next;
        Iterator<Integer> iter;
        public IntIter(Iterator<Integer> iter) {
            this.next = iter.next();
            this.iter = iter;
        }
    }





public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        
        if(lists == null || lists.length == 0){
            return null;
        }
        
        if(lists.length == 1){
            
            return lists[0];
        }
        
        if(lists.length == 2){
            
            return mergeTwoList(lists[0], lists[1]);
        }
        
        int st = 0;
        int ed = lists.length;
        
        int mid = st + (ed - st) / 2;
        
        return mergeTwoList(mergeKLists(Arrays.copyOfRange(lists, st, mid)), mergeKLists(Arrays.copyOfRange(lists, mid ,ed)));
        
    }
    
    
    private ListNode mergeTwoList(ListNode l1, ListNode l2){
        
        ListNode head = new ListNode(0);
        
        ListNode dummy = head;
        
        while(l1 != null && l2 != null){
            
            if(l1.val < l2.val){
                head.next = l1;
                l1 = l1.next;
            }else{
                head.next = l2;
                l2 = l2.next;
            }
            
            head = head.next;
        }
        
        if(l1 != null){
            head.next = l1;
        }
        
        if(l2 != null){
            head.next = l2;
        }
        
        return dummy.next;
    }
    
}
