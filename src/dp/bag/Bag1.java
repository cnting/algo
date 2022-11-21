package dp.bag;

/**
 * Created by cnting on 2022/11/13
 * 0-1背包问题，二维数组
 * <p>
 * 问题：
 * 有n件物品和一个最多能背重量为bagSize的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。
 * 每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
 */
public class Bag1 {
    public static void main(String[] args) {
        //物品重量
        int[] weight = new int[]{1, 3, 4};
        //物品价值
        int[] value = new int[]{15, 20, 30};
        //背包容量
        int bagSize = 4;

        //dp[i][j]：从下标为[0-i]的物品中任意取，放进容量为j的背包，价值总和最大是多少
        //bagSize+1：背包容量从 0 到 4，长度为5
        int[][] dp = new int[weight.length][bagSize + 1];

        //初始化第0个物品放入 背包容量为 [0-bagSize] 的价值
        for (int j = 0; j <= bagSize; j++) {
            //如果物品重量<背包容量
            if (weight[0] <= j) {
                dp[0][j] = value[0];
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                //如果第i个物品重量大于背包容量，则不取，也就是跟dp[i-1][j]的价值一样
                if (weight[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //分为取和不取物品i：
                    //不取：和dp[i-1][j]的价值一样
                    //取：dp[i - 1][j - weight[i] 表示背包容量为 j-weight[i] 并且不放物品i时的容量，保证物品i放进去时的容量是够的
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
