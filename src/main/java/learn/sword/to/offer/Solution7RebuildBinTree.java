package learn.sword.to.offer;

import learn.sword.to.offer.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey
 */
public class Solution7RebuildBinTree {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) return null;
        // 中序遍历的每个元素的索引表
        Map<Integer, Integer> midIndexMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            midIndexMap.put(in[i], i);
        }

        return findRoot(pre, 0, in, 0, in.length - 1, midIndexMap);

    }


    /**
     * 重点：中序遍历时，某个节点的左边，全为左子树的成员，右边的节点全为右子树的成员
     * 由此，可以找到先序遍历的数组中，接下来有几个数组是左子树的，有几个是右子树的。
     * 这是最重要的特征！
     * 由此，递归调用，分别求左子树和右子树
     *
     * @param pre
     * @param preStart
     * @param in
     * @param inStart
     * @param inEnd
     * @param midIndexMap
     * @return
     */
    TreeNode findRoot(int[] pre, int preStart, int[] in, int inStart, int inEnd, Map<Integer, Integer> midIndexMap) {
        if (preStart > pre.length - 1 || inEnd < inStart) return null;
        if (inEnd == inStart) return new TreeNode(pre[preStart]);
        int rootVal = pre[preStart];
        int rootMidIdx = midIndexMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int leftSize = rootMidIdx - inStart;
        int rightSize = inEnd - rootMidIdx;
        if (leftSize > 0) {
            root.left = findRoot(pre, preStart + 1, in, inStart, rootMidIdx - 1, midIndexMap);
        }
        if (rightSize > 0) {
            root.right = findRoot(pre, preStart + leftSize + 1, in, rootMidIdx + 1, inEnd, midIndexMap);
        }
        return root;
    }


    //
    public TreeNode reConstructBinaryTree2(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree2(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree2(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        if (startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);

        // 不通过map，通过遍历来确定位置
        for (int i = startIn; i <= endIn; i++)
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree2(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree2(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }

        return root;
    }

}
