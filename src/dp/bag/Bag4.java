package dp.bag;

/**
 * 一步一个台阶，两个台阶，三个台阶，.......，直到 m个台阶。问有多少种不同的方法可以爬到楼顶n呢？
 */
public class Bag4 {
    public static void main(String[] args) {
        //1..m个台阶看做物品，可以重复。楼顶n看做背包容量
        int m = 4;
        int n = 10;
        //爬到n有多少种方法，这是组合问题
        int[] dp = new int[n + 1];
        dp[0] = 1;
        //先1个台阶再2个台阶，跟先2个台阶再1个台阶是两种方法，所以是求排列，所以容量在外面遍历，物品在里面遍历
        for (int j = 0; j <= n; j++) {  //遍历容量
            for (int i = 1; i <= m; i++) {  //遍历物品
                if (j >= i) dp[j] += dp[j - i];
            }
        }
        System.out.println(dp[n]);
    }
}
