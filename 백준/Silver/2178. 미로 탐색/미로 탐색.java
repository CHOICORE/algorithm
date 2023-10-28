import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int node, edge;
    static boolean[][] visited;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer reader = new StringTokenizer(br.readLine());
        node = Integer.parseInt(reader.nextToken());
        edge = Integer.parseInt(reader.nextToken());

        visited = new boolean[node][edge];
        A = new int[node][edge];

        for (int i = 0; i < node; i++) {
            reader = new StringTokenizer(br.readLine());
            String line = reader.nextToken();
            for (int j = 0; j < edge; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }


        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int m = 0; m < 4; m++) {
                int x = now[0] + dx[m];
                int y = now[1] + dy[m];
                if (x >= 0 && y >= 0 && x < node && y < edge) {
                    if (A[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; // 핵심
                        queue.add(new int[]{x, y}); // 큐에 현재 좌표 등록
                    }
                }
            }
        }

        System.out.println(A[node - 1][edge - 1]);
    }
}
