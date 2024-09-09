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
        int i = 0;
        int j = 0;
        int cur_d = 0;
        int[][] movement = {
                        {0, 1},
                        {1, 0},
                        {0, -1},
                        {-1, 0},
                };
        int[][] answer = new int[m][n];
        for (int[] row : answer) {
            Arrays.fill(row, -1);
        }

        while (head != null) {
            answer[i][j] = head.val;
            int newi = i + movement[cur_d][0], newj = j + movement[cur_d][1];
            
            if (
                    Math.min(newi, newj) < 0 ||
                            newi >= m ||
                            newj >= n ||
                            answer[newi][newj] != -1
            ) cur_d = (cur_d + 1) % 4;
            i += movement[cur_d][0];
            j += movement[cur_d][1];

            head = head.next;
        }

        return answer;
    }
}