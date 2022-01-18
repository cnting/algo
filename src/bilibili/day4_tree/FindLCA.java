package bilibili.day4_tree;

public class FindLCA {
    public static void main(String[] args) {
        TreeNode node = TreeSerializable.preOrderDeserialize("1,2,#,4,#,#,3,4,#,#,5,#,#");
        TreeUtil.show(node);
        System.out.println("LCA:" + findLCA(node, node.left, node.right.left));
    }

    /**
     * 找 p 和 q 的最低公共祖先
     * 情况 1，如果 p 和 q 都在以root为根的树中，那么left和right一定分别是p和q。
     * 情况 2，如果 p 和 q 都不在以root为根的树中，直接返回null。
     * 情况 3，如果 p 和 q 只有一个存在于root为根的树中，函数返回该节点。
     */
    public static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        //情况 1
        if (left != null && right != null) {
            return root;
        }
        //情况 2
        if (left == null && right == null) {
            return null;
        }
        //情况 3
        return left != null ? left : right;
    }
}
