package learn.sword.to.offer;


/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n ≤ 39
 * f(n) = 0,  n=0;
 * f(n) = 1,  n=1;
 * f(n) = f(n-1) +f(n-2)   n>1;
 */
public class Solution10Fibonacci {

    // 暴力递归，问题在于，f(3)等较小的数，被重复计算很多很多次
    public int fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }

    int[] arr = new int[40];

    // 为了避免重复计算，需要动态规划，将结果缓存起来。
    public int fibonacci2(int n) {
        if (n <= 1) {
            return n;
        } else if (arr[n] != 0) {
            return arr[n];
        } else {
            return fibonacci2(n - 1) + fibonacci2(n - 2);
        }
    }

    // 正序计算
    public int fibonacci3(int n) {
        if (n <= 1) return n;
        int prePre = 0;
        int pre = 1;
        int tmp = 0;
        for (int i = 2; i <= n; i++) {
            tmp = pre + prePre;
            prePre = pre;
            pre = tmp;
        }
        return tmp;
    }
}


