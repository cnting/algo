package day10_dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cnting on 2020/3/21
 * 找零钱 https://leetcode-cn.com/problems/coin-change/
 */
class Change {
    public int coinChange(int[] coins, int amount) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        Arrays.sort(coins);
        int index = coins.length - 1;
        while ((amount - sum) >= coins[0]) {
            if ((amount - sum) < coins[index]) {
                index--;
            } else {
                int coin = coins[index];
                sum += coin;
                list.add(coin);
            }
        }
        return (amount - sum) > 0 ? -1 : list.size();
    }

    public static void main(String[] args) {
//        int[] coins = {1, 2, 5};
//        int amount = 11;
        int[] coins = {186, 419, 83, 408};
        int amount = 6249;
        int result = new Change().coinChange(coins, amount);
        System.out.println(result);
    }
}
