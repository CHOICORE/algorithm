class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        var result = 0
        for (x in grid.indices)
            for (y in grid[x].indices)
                result += dfs(grid, x, y)
        return result
    }

    private fun dfs(
        grid: Array<CharArray>,
        x: Int,
        y: Int,
    ): Int {
        if (!isCoords(grid, x, y) || grid[x][y] == '0') {
            return 0
        }

        grid[x][y] = '0'
        dfs(grid, x + 1, y)
        dfs(grid, x, y + 1)
        dfs(grid, x - 1, y)
        dfs(grid, x, y - 1)
        return 1
    }

    private fun isCoords(
        grid: Array<CharArray>,
        x: Int,
        y: Int,
    ) = x >= 0 && y >= 0 && x < grid.size && y < grid[0].size
}
