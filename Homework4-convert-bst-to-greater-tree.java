/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * 本题思路：根据二叉搜索树的性质，将二叉搜索树转换为累加树时，需要按照右子树->根节点->左子树的顺序遍历
     * 考虑一般情况——根节点，左子节点，右子节点的情况：
     * 此时，按照之前指定的遍历顺序：
     *      右子节点的值等于其自身值加上大于右节点但不在当前子树上的节点值，
     *      根节点值等于其自身加上右子节点值，
     *      左子节点等于其自身加上现在的根节点值（既原根节点值加右子节点值）
     * 因此，按照规定的顺序遍历，同时传入节点和根节点值作为参数（函数RDL()）
     */
    /**
     * 时间复杂度分析：若本题二叉搜索树总节点数为n，则仅需遍历一次二叉树即可得到结果，因此时间复杂度为O(n)
     * 本算法耗时：0ms
     */

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 调用时，初始根节点的父亲节点的值为0
        RDL(root, 0);

        return root;
    }

    private int RDL(TreeNode root, int rootVal) {
        // 当root为null时不应该返回0，而应该返回rootVal，考虑左子树为空的情况
        if (root == null) {
            return rootVal;
        }

        // 先对右子树调用算法， rootVal为之前所有节点值之和
        // 同时将根节点值修改为当前值与右子树最左侧节点值之和
        root.val += RDL(root.right, rootVal);

        // 对左子树调用算法
        return RDL(root.left, root.val);

    }

}