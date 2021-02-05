package learn.sword.to.offer;

import learn.sword.to.offer.model.TreeLinkNode;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Solution8FindNextNodeInBinLinkTree {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            TreeLinkNode tmp = pNode.right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            return tmp;
        } else {
            // 右节点是null，往上找，
            if(pNode.next == null) return null;
            else if(pNode.next.left == pNode) return pNode.next;
            else {
                TreeLinkNode tmp = pNode.next;
                while (tmp.next != null){
                    if(tmp.next.left == tmp) return tmp.next;
                    else tmp = tmp.next;
                }
                // 回溯到根节点了，且回溯路径为右子树，此时，没有后续了
                return null;
            }
        }
    }

}
