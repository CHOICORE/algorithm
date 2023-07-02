class Solution {
    int answer = 0;

    public int maximumRequests(int n, int[][] requests) {
        int[] degree = new int[n];
        permits(requests, 0, degree, 0);
        return answer;
    }

    void permits(int[][] req, int ind, int[] degree, int temp) {
        if (ind == req.length) {
            for (int j : degree) {
                if (j != 0)
                    return;
            }
            answer = Math.max(answer, temp);
            return;
        }

        int i = req[ind][0];
        int j = req[ind][1];

        degree[i] = degree[i] - 1;
        degree[j] = degree[j] + 1;
        permits(req, ind + 1, degree, temp + 1);

        degree[i] = degree[i] + 1;
        degree[j] = degree[j] - 1;
        permits(req, ind + 1, degree, temp);
    }
}