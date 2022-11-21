package dp.bag;

/**
 * Created by cnting on 2022/11/13
 * 0-1背包问题，一维数组
 * <p>
 * 问题：
 * 有n件物品和一个最多能背重量为bagSize的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。
 * 每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
 */
public class Bag2 {
    public static void main(String[] args) {
        //物品重量
        int[] weight = new int[]{1, 3, 4};
        //物品价值
        int[] value = new int[]{15, 20, 30};
        //背包容量
        int bagSize = 4;

        //dp[j]：容量为j的背包，所背物品的最大价值
        int[] dp = new int[bagSize+1];

        //遍历物品
        for(int i = 0;i<weight.length;i++){
            //dp[j]会受 <j 的dp的影响，所以要从后往前遍历
            for(int j = bagSize;j>=weight[i];j--){
                //不取，dp[j]不变
                //取，dp[j-weight[i]]+value[i] 表示背包容量为 j-weight[i] 并且不放物品i时的容量，保证物品i放进去时的容量是够的
                dp[j] = Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }

        for(int i :dp){
            System.out.println(i+" ");
        }
    }
}
