package offer.practice;

/**
 * Created by cnting on 2020/6/16
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 */
class Offer15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n!=0){
            //进行与操作，判断最后一位是否是1
            if((n&1)>0){
                count++;
            }
            n = n>>>1;  //java中无符号右移为>>>
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Offer15().hammingWeight(15));
    }
}
