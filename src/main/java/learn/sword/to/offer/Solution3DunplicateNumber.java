package learn.sword.to.offer;

/**
 * <b>在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。</b>数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * Input:
 * {2, 3, 1, 0, 2, 5}
 * <p>
 * Output:
 * 2
 */
public class Solution3DunplicateNumber {

    /**
     * 作者：CyC2018
     * 链接：https://www.nowcoder.com/discuss/198840?type=1
     * 来源：牛客网
     * <p>
     * 要求时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
     * <p>
     * 对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
     * <p>
     * 以 (2, 3, 1, 0, 2, 5) 为例，遍历到位置 4 时，该位置上的数为 2，但是第 2 个位置上已经有一个 2 的值了，因此可以知道 2 重复：
     *
     * @param arr
     * @return
     */
    static int dumplicate(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {
                int tmpNum = arr[i];
                // 当前数字位置不正确，找到正确位置的数字比较，若相等，则表明为重复数字
                if (arr[tmpNum] == arr[i]) {
                    return arr[i];
                }
                // 若不相等，则交换两个数字的位置，即 数组中第i个数字和第tmpNum个数字
                int temp = arr[tmpNum];
                arr[tmpNum] = arr[i];
                arr[i] = temp;
                // 交换后，继续全流程判断。
            }

        }
        return -1;
    }


    /**
     * 长度 n+1 数组内所有数字都在 1~n 范围内，所以至少有一个数字是重复的，找出任意一个重复数字
     * 要求：不修改数组,空间复杂度 O(1)，用时间换空间，
     * 思路：核心规律：m~n的范围，若一个数组中，在这个范围内的数字数量超过了m-n+1个，则其中一定有重复的。
     * 再使用二分查找的思想，将m~n分为两份，再统计全数组分别在这两个范围内的数字数量。
     * 时间复杂度 O(nlogn)
     *
     * @param arr
     * @return
     */
    static int dumplicate2(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        int start = 1;
        int end = arr.length - 1;
        while (end > start) {
            int middle = start + ((end - start) >> 1);
            int cnt = countRange(arr, start, middle);
            if (cnt > middle - start + 1) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return end;
    }

    static int countRange(int[] arr, int start, int end) {
        int cnt= 0;
        for (int k : arr) {
            if(k >= start && k <= end){
                cnt ++;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
//        int[] arr = new int[]{2, 3, 0, 1, 2, 5, 7, 4};
//        System.out.println(dumplicate(arr));
        int[] arr = new int[]{2, 3, 1,1};
        System.out.println(dumplicate2(arr));
    }
}
