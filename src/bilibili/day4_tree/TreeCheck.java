package bilibili.day4_tree;

import java.util.LinkedList;

public class TreeCheck {
    public static void main(String[] args) {
        TreeNode node = TreeSerializable.preOrderDeserialize("1,2,#,4,#,#,3,4,#,#,5,#,#");
        TreeUtil.show(node);
//        System.out.println("是否是搜索二叉树:" + isBST(node).isBST);
//        System.out.println("是否是平衡二叉树:" + isBalanceBinaryTree(node).isBBT);
//        System.out.println("是否是满二叉树:" + isFullBinaryTree(node).isFBT);
        System.out.println("是否是完成二叉树:"+isCompleteBinaryTree(node));
    }

    /**
     * 判断是否是搜索二叉树
     * 1.左是搜索二叉树
     * 2.右是搜索二叉树
     * 3.左max < 当前节点 < 右min
     */
    public static BSTInfo isBST(TreeNode node) {
        if (node == null) {
            return new BSTInfo(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        BSTInfo leftInfo = isBST(node.left);
        BSTInfo rightInfo = isBST(node.right);
        boolean isBST = leftInfo.isBST && rightInfo.isBST && leftInfo.max <= node.val && rightInfo.min >= node.val;
        int min = Math.min(leftInfo.min, node.val);
        int max = Math.max(rightInfo.max, node.val);
        return new BSTInfo(isBST, min, max);
    }

    static class BSTInfo {
        boolean isBST;
        int min;
        int max;

        BSTInfo(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    /**
     * 判断是否是完成二叉树，完全二叉树只有最后一层不满
     * 1.任一节点，有右节点，无左节点，返回false
     * 2.在满足1的条件下，如果遇到第一个左右节点不全，则后续节点都必须是叶子节点
     */
    public static boolean isCompleteBinaryTree(TreeNode node) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        boolean isLeaf = false;
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            TreeNode left = n.left;
            TreeNode right = n.right;
            if (left == null && right != null) {
                return false;
            }
            if (isLeaf && (left != null || right != null)) {
                return false;
            }
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            if (left == null || right == null) {
                isLeaf = true;
            }
        }
        return true;
    }

    /**
     * 是否是满二叉树
     * 有这个关系：节点数=2^高度-1
     */
    public static FBTInfo isFullBinaryTree(TreeNode node) {
        if (node == null) {
            return new FBTInfo(true, 0, 0);
        }
        FBTInfo left = isFullBinaryTree(node.left);
        FBTInfo right = isFullBinaryTree(node.right);
        int height = Math.max(left.height, right.height) + 1;
        int nodeCount = left.nodeCount + right.nodeCount + 1;
        boolean isFBT = left.isFBT && right.isFBT && nodeCount == Math.pow(2, height) - 1;
        return new FBTInfo(isFBT, height, nodeCount);
    }

    static class FBTInfo {
        boolean isFBT;
        int height;
        int nodeCount;

        FBTInfo(boolean isFBT, int height, int nodeCount) {
            this.isFBT = isFBT;
            this.height = height;
            this.nodeCount = nodeCount;
        }
    }

    /**
     * 是否是平衡二叉树，左右子树高度差<=1
     */
    public static BBTInfo isBalanceBinaryTree(TreeNode node) {
        if (node == null) {
            return new BBTInfo(true, 0);
        }
        BBTInfo left = isBalanceBinaryTree(node.left);
        BBTInfo right = isBalanceBinaryTree(node.right);
        int height = Math.max(left.height, right.height) + 1;
        boolean isBBT = left.isBBT && right.isBBT && Math.abs(left.height - right.height) <= 1;
        return new BBTInfo(isBBT, height);
    }

    static class BBTInfo {
        boolean isBBT;
        int height;

        BBTInfo(boolean isBBT, int height) {
            this.isBBT = isBBT;
            this.height = height;
        }
    }

}
