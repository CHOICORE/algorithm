import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        // Time complexity: O(n^2)
        // Space complexity: O(n)
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // 배열에 방문하지 않았다면
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i); // 큐에 담고
                visited[i] = true; // 마킹한다.

                while (!queue.isEmpty()) { // 대기 큐가 있을때 순회를 돈다.
                    int cur = queue.poll(); // 큐에서 꺼낸다.
                    for (int j = 0; j < n; j++) { // 인접을 순회돈다.
                        // i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
                        if (!visited[j] && computers[cur][j] == 1) { // 방문하지 않은 노드이며 연결되어 있으면
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }
                }
                answer++;
            }
        }

        return answer;
    }
}
