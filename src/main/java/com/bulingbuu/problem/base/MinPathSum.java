package com.bulingbuu.problem.base;

/**
 * @author bulingbuu
 * @date 19-2-22 下午6:19
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        MinPathSum pathSum = new MinPathSum();
        System.out.println(pathSum.minPathSum(grid));

    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] item = new int[m][n];


        //初始化哨兵
        item[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            item[i][0] = grid[i][0] + item[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            item[0][i] = grid[0][i] + item[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                item[i][j] = Math.min(item[i - 1][j], item[i][j - 1]) + grid[i][j];
            }
        }

        return item[m - 1][n - 1];
    }
}
