class Solution {
    var rows: Int = 0
    var cols: Int = 0
    var islands: Int = 0

    fun numIslands(grid: Array<CharArray>): Int {
        rows = grid.size
        cols = grid[0].size
        for (row in 0 until rows) check(grid, row)
        return islands
    }

    private fun check(
        grid: Array<CharArray>,
        row: Int,
    ) {
        val finalRow = grid[row]
        for (col in 0 until cols) if (finalRow[col] == '1') {
            bfs(grid, row, col)
            ++islands
        }
    }

    private fun bfs(
        grid: Array<CharArray>,
        row: Int,
        col: Int,
    ) {
        grid[row][col] = '*'
        if (row > 0 && grid[row - 1][col] == '1') bfs(grid, row - 1, col)
        if (row + 1 < rows && grid[row + 1][col] == '1') bfs(grid, row + 1, col)
        if (col > 0 && grid[row][col - 1] == '1') bfs(grid, row, col - 1)
        if (col + 1 < cols && grid[row][col + 1] == '1') bfs(grid, row, col + 1)
    }
}
