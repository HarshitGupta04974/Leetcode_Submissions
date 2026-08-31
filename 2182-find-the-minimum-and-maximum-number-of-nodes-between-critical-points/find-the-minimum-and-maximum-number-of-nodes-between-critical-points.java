/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode cur = head.next;
        ListNode nxt = cur.next;
        int firstInd = -1;
        int lastInd = -1;
        int minDist = Integer.MAX_VALUE;
        int ind = 1;
        while (nxt != null) {
            if ((cur.val > prev.val && cur.val > nxt.val) ||
                    (cur.val < prev.val && cur.val < nxt.val)) {
                if (firstInd == -1) {
                    firstInd = ind;
                    lastInd = ind;
                } else {
                    int dist = ind - lastInd;
                    minDist = Math.min(minDist, dist);
                    lastInd = ind;
                }

            }
            prev = cur;
            cur = nxt;
            nxt = nxt.next;
            ind++;

        }
        if (firstInd == -1 || firstInd == lastInd) {
            return new int[] { -1, -1 };
        }
        int maxdist = lastInd - firstInd;
        return new int[] { minDist, maxdist };
    }
}