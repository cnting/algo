package day10_dynamic;

import java.util.Arrays;

/**
 * Created by cnting on 2020/3/21
 * 机器人走格子  https://leetcode-cn.com/problems/unique-paths/
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] array = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < m; i++) {
            //如果是第0行或第0列，记录当前行或者列是否有障碍物，如果有，后面的值都为0
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    array[i][j] = 0;
                } else {
                    if (i == 0 || j == 0) {
                        boolean hasObstacle = false;
                        if (i == 0) {
                            for (int p = 0; p < j; p++) {
                                if (array[i][p] == 0) {
                                    hasObstacle = true;
                                    break;
                                }
                            }
                        } else {
                            for (int p = 0; p < i; p++) {
                                if (array[p][j] == 0) {
                                    hasObstacle = true;
                                    break;
                                }
                            }
                        }
                        array[i][j] = hasObstacle ? 0 : 1;
                    } else {
                        array[i][j] = array[i - 1][j] + array[i][j - 1];
                    }
                }
            }
        }

        return array[m - 1][n - 1];
    }

    public static void main(String[] args) {
//        int[][] obstacleGrid = {
//                {1},
//                {0}
//        };
        int[][] obstacleGrid = {
                {1,0},
        };
//        int[][] obstacleGrid = {
//                {0,0,0},
//                {0,1,0},
//                {0,0,0}
//        };
        System.out.println(new Solution().uniquePathsWithObstacles(obstacleGrid));

//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(array[i][j] + " ");
//            }
//            System.out.println();
//        }

    }
}