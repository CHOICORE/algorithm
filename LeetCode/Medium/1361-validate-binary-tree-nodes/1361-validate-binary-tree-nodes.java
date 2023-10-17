class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        int[] inDegree = new int[n];
        int root = -1;

        for (final int child : leftChild)
            if (child != -1 && ++inDegree[child] == 2)
                return false;

        for (final int child : rightChild)
            if (child != -1 && ++inDegree[child] == 2)
                return false;

        for (int i = 0; i < n; ++i)
            if (inDegree[i] == 0)
                if (root == -1)
                    root = i;
                else
                    return false;

        if (root == -1)
            return false;

        boolean[] visited = new boolean[n];
        if (!dfs(root, leftChild, rightChild, visited)) return false;

        for (boolean v : visited) if (!v) return false;
        return true;
    }

    private boolean dfs(int source, int[] leftChild, int[] rightChild, boolean[] visited) {
        visited[source] = true;
        int left = leftChild[source], right = rightChild[source];

        if (left >= 0) {
            if (visited[left] || !dfs(left, leftChild, rightChild, visited)) return false;
        }

        if (right >= 0) {
            return !visited[right] && dfs(right, leftChild, rightChild, visited);
        }

        return true;
    }
}