class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return totalWays(grid, 0, 0,m - 1,n - 1,new HashMap<String,Integer>());
    }
    public int totalWays(int[][] grid, int currentRow, int currentCol, int m, int n, HashMap<String,Integer> memo)
    {
        if(currentRow==m && currentCol==n)
            return grid[currentRow][currentCol];
        if(currentRow > m || currentCol > n)
            return 1000;
        
        String currentKey = Integer.toString(currentRow) + "_" + Integer.toString(currentCol);
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int downMove = grid[currentRow][currentCol] + totalWays(grid, currentRow+1, currentCol, m, n, memo);
        
        int rightMove = grid[currentRow][currentCol] + totalWays(grid, currentRow, currentCol + 1, m, n, memo);
        
        memo.put(currentKey,Math.min(downMove,rightMove));
        
        return memo.get(currentKey);
    }
}
