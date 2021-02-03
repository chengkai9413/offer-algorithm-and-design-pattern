package learn.sword.to.offer;

import java.util.Arrays;

/**
 * 作者：CyC2018
 * 链接：https://www.nowcoder.com/discuss/198840?type=1
 * 来源：牛客网
 * <p>
 * 给定一个二维数组，其
 * 每一行从左到右递增排序，从上到下也是递增排序。
 * 给定一个数，判断这个数是否在该二维数组中。
 * <p>
 * Consider the following matrix:
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * Given target = 5, return true.
 * Given target = 20, return false.
 */
public class Solution4FindNumIn2DimArray {
    /**
     * 思路：分析数组规律，每一行从左到右递增，每一列从上到下也是递增。则每个位置上的数字，都比其左边及上边的所有数字都要大。
     * 例如例子中要查找数字13，从右上角的开始，15>13,排除最后一列，11<13,则倒数第二列就不能排除了。但是可以排除第一行11及左边的所有位置
     * 再往下走，12 < 13则第二行的12及左边也可以排除，16>13 则到此 倒数第二列也可以排除了
     * 再往左走，9 < 13 ,则9左边的都可以排除...
     * <p>
     * 总结：走到某个位置后，若当前位置的值 n ！= 需要查找的值 t，则
     * 1. n > t 时，
     * 2. n < t 时，
     *
     * @param arr
     * @return
     */
    static boolean find(int[][] arr,int x) {
        if (arr == null || arr.length == 0) return false;
        int i = 0;
        int j = arr[0].length -1;
        while (j >= 0 && i <= arr.length-1 && i >= 0) {
            if(arr[i][j] == x){
                return true;
            } else if(arr[i][j] > x){
                j --;
            } else {
                i ++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                new int[]{1, 4, 7, 11, 15},
                new int[]{2, 5, 8, 12, 19},
                new int[]{3, 6, 9, 16, 22},
                new int[]{10, 13, 14, 17, 24},
                new int[]{18, 21, 23, 26, 30}
        };
        System.out.println(arr.length);
        System.out.println(arr[0].length);
        System.out.println(find(arr,1));
    }

}
