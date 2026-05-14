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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(p);
        q2.add(q);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            for (int i = q1.size(); i > 0; i--) {
                TreeNode NodeP = q1.poll();
                TreeNode NodeQ = q2.poll();
                if (NodeP == null && NodeQ == null) {
                    continue;
                }
                if (NodeP == null || NodeQ == null || NodeP.val != NodeQ.val) {
                    return false;
                }

                q1.add(NodeP.left);
                q1.add(NodeP.right);
                q2.add(NodeQ.left);
                q2.add(NodeQ.right);
            }
        }
        return true;
    }
}
