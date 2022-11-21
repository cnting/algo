package dp.bag;

/**
 * Created by cnting on 2022/11/19
 * 完全背包
 * 有N件物品和一个最多能背重量为W的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。
 * 每件物品都有无限个（也就是可以放入背包多次），求解将哪些物品装入背包里物品价值总和最大。
 */
public class Bag3 {
    public static void main(String[] args) {
        //物品重量
        int[] weight = new int[]{1, 3, 4};
        //物品价值
        int[] value = new int[]{15, 20, 30};
        //背包容量
        int bagSize = 4;

        //dp[j]:容量为j的背包，所背物品的最大价值
        int[] dp = new int[bagSize + 1];

        //遍历方式1：先遍历物品，再遍历容量
//        for (int i = 0; i < weight.length; i++) {  //遍历物品
//            for (int j = weight[i]; j <= bagSize; j++) {  //遍历容量，j=weight[i]表示背包容量至少从刚好放进物品开始
//                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
//            }
//        }

        //遍历方式2：先遍历容量，再遍历物品
        for (int j = 0; j <= bagSize; j++) {  //遍历容量
            for (int i = 0; i < weight.length; i++) {  //遍历物品
                if (j >= weight[i]) dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        for (int i : dp) {
            System.out.println(i + " ");
        }
    }
}
