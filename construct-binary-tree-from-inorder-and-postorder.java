/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private HashMap<Integer, Integer> inorderHashMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderHashMap = new HashMap<Integer, Integer>();
        int n = inorder.length - 1;

        for (int i = 0; i <= n; i++) {
            inorderHashMap.put(inorder[i], i);
        }

        return helper(inorder, 0, n, postorder, 0, n);
    }

    public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(postorder[postEnd]);

        if (inStart != inEnd) {
            int inRootIndex = inorderHashMap.get(root.val);
            root.left = helper(inorder, inStart, inRootIndex - 1, postorder, postStart, postStart + inRootIndex - 1 - inStart);
            root.right = helper(inorder, inRootIndex + 1, inEnd, postorder, postStart + inRootIndex - inStart, postEnd - 1);
        }

        return root;
    } 
}