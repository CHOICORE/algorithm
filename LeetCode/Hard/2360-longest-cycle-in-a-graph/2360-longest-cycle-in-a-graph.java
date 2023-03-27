class Solution {
    // 사이클의 최대 길이를 저장할 변수
    int answer = -1;

    // 깊이 우선 탐색을 통해 사이클 찾기
    public void dfs(int node, int[] edges, Map<Integer, Integer> dist, boolean[] visit) {
        // 현재 노드 방문 처리
        visit[node] = true;
        
        // 현재 노드의 이웃 노드
        int neighbor = edges[node];

        // 이웃 노드가 방문하지 않은 경우
        if (neighbor != -1 && !visit[neighbor]) {
            // 이웃 노드까지의 거리를 계산하고, dfs 재귀 호출
            dist.put(neighbor, dist.get(node) + 1);
            dfs(neighbor, edges, dist, visit);
        } 
        // 이웃 노드가 이미 방문한 경우, 사이클 찾기
        else if (neighbor != -1 && dist.containsKey(neighbor)) {
            // 사이클의 최대 길이 갱신
            answer = Math.max(answer, dist.get(node) - dist.get(neighbor) + 1);
        }
    }

    // 모든 노드를 순회하며 dfs 탐색
    public int longestCycle(int[] edges) {
        // 배열의 크기
        int n = edges.length;
        // 노드 방문 여부를 저장하는 배열
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            // 아직 방문하지 않은 노드를 찾아서 dfs 호출
            if (!visit[i]) {
                // 현재 노드부터의 거리를 저장하는 맵 초기화
                Map<Integer, Integer> dist = new HashMap<>();
                dist.put(i, 1);
                dfs(i, edges, dist, visit);
            }
        }
        // 사이클의 최대 길이 반환
        return answer;
    }
}
