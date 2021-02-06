package learn.sword.to.offer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * <p>
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 */
public class Solution10_2RectCover {


    /**
     * 问题可以拆解成小问题
     * 拿出一个，若横着放，则必需再拿出来一个也横着放，剩余问题变成f（n-2）
     * 若竖着放，剩余问题变 f（n-1）
     * 由此，与斐波那契数列解法一致。
     * 同理，跳台阶（每次只能1阶/2阶，跳上n阶有多少种可能）问题
     * 注意：避免重复计算，
     *
     * @param target
     * @return
     */
    public int rectCover(int target) {
        return 0;
    }


    /**
     * 变态跳台阶，每一次可以跳1~n阶都允许
     * 公式f(n) = f(0) + f(1) + f(2) + ... + f(n-1)
     * 简化一下 f(n-1) = f(0) + f(1) + f(2) + ... + f(n-2)
     * 可得到 f(n) = 2 f(n-1)
     * 因为是等比数列，2^(n-1)直接得到也可以   1 << (target -1)
     * 最后一步，可以是从之前的任意一个台阶跳上来的。
     *
     * @return
     */
    public int jumpFloorII(int target) {
//        if(target == 1) return 1;
//        int last = 1;
//        int result = 1;
//        for (int i = 2; i <= target; i++) {
//            result = 2 * last;
//            last = result;
//        }
//        return result;

        return 1 << (target - 1);
    }
}
