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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = -1;
            }
        }
        if (head == null) return answer;
        int top = 0, left = 0;
        int right = n - 1, bottom = m - 1;

        while (head != null && top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                answer[top][i] = head.val;
                head = head.next;
                if (head == null) return answer;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                answer[i][right] = head.val;
                head = head.next;
                if (head == null) return answer;
            }
            right--;
            for (int i = right; i >= left; i--) {
                answer[bottom][i] = head.val;
                head = head.next;
                if (head == null) return answer;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                answer[i][left] = head.val;
                head = head.next;
                if (head == null) return answer;
            }
            left++;
        }
        return answer;
    }
}