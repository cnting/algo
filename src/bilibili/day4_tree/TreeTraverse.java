package bilibili.day4_tree;

import java.util.Stack;

/**
 * Created by cnting on 2022/1/9
 * 二叉树的遍历，分为递归和非递归方式
 */
class TreeTraverse {
    public static void main(String[] args) {
        TreeNode node = TreeSerializable.preOrderDeserialize("1,2,#,4,#,#,3,#,#");
        System.out.println("递归先序:");
        recurPreOrder(node);
        System.out.println("\n非递归先序:");
        unRecurPreOrder(node);

        System.out.println("\n递归中序:");
        recurInOrder(node);
        System.out.println("\n非递归中序:");
        unRecurInOrder(node);

        System.out.println("\n递归后序:");
        recurPostOrder(node);
        System.out.println("\n非递归后序:");
        unRecurPostOrder(node);
    }

    /**
     * 递归先序
     */
    private static void recurPreOrder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        recurPreOrder(node.left);
        recurPreOrder(node.right);
    }

    /**
     * 递归中序
     */
    private static void recurInOrder(TreeNode node) {
        if (node == null) return;
        recurInOrder(node.left);
        System.out.print(node.val + " ");
        recurInOrder(node.right);
    }

    /**
     * 递归后序
     */
    private static void recurPostOrder(TreeNode node) {
        if (node == null) return;
        recurPostOrder(node.left);
        recurPostOrder(node.right);
        System.out.print(node.val + " ");
    }

    /**
     * 非递归先序
     */
    private static void unRecurPreOrder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            System.out.print(n.val + " ");
            if (n.right != null) stack.push(n.right);
            if (n.left != null) stack.push(n.left);
        }
    }

    /**
     * 非递归中序
     */
    private static void unRecurInOrder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                System.out.print(node.val+" ");
                node = node.right;
            }
        }
    }

    /**
     * 非递归后序
     */
    private static void unRecurPostOrder(TreeNode node) {
        //普通栈
        Stack<TreeNode> stack1 = new Stack<>();
        //收集栈
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(node);
        while (!stack1.isEmpty()) {
            TreeNode parent = stack1.pop();
            stack2.push(parent);
            if (parent.left != null) stack1.push(parent.left);
            if (parent.right != null) stack1.push(parent.right);
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }
}


