package bilibili.day4_tree;

import offer.practice.ListNode;

import java.util.*;

public class TreeSerializable {

    private final static String NULL = "#";
    private final static String SEP = ",";

    public static void main(String[] args) {
        String str = "1,2,#,4,#,#,3,#,#";
        //先序
        System.out.println("======先序");
        TreeNode head = preOrderDeserialize(str);
        TreeUtil.show(head);
        System.out.println(preOrderSerialize(head));

        //后序
        System.out.println("======后序");
        head = postOrderDeserialize(str);
        System.out.println(postOrderSerialize(head));


        //层序
        System.out.println("======层序");
        head = layerDeserialize("1,2,3,#,4,#,#,#,#");
        System.out.println(layerSerialize(head));
    }


    /**
     * 先序遍历反序列化
     */
    public static TreeNode preOrderDeserialize(String str) {
        List<String> list = new LinkedList<>();
        Collections.addAll(list, str.split(SEP));
        return preOrderDeserialize(list);
    }

    public static TreeNode preOrderDeserialize(List<String> list) {
        if (list.isEmpty()) return null;
        String str = list.remove(0);
        if (str.equals(NULL)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(str));
        node.left = preOrderDeserialize(list);
        node.right = preOrderDeserialize(list);
        return node;
    }

    /**
     * 先序遍历序列化
     */
    public static String preOrderSerialize(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        preOrder(sb, node);
        return sb.toString();
    }

    private static void preOrder(StringBuilder sb, TreeNode node) {
        sb.append(node == null ? NULL : node.val).append(SEP);
        if (node != null) {
            preOrder(sb, node.left);
            preOrder(sb, node.right);
        }
    }

    /**
     * 中序遍历可以序列化，但没法反序列化
     */
    public static String inOrderSerialize(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        inOrder(sb, node);
        return sb.toString();
    }

    private static void inOrder(StringBuilder sb, TreeNode node) {
        if (node != null) inOrder(sb, node.left);
        sb.append(node == null ? NULL : node.val).append(SEP);
        if (node != null) inOrder(sb, node.right);
    }

    /**
     * 后序遍历序列化
     */
    public static TreeNode postOrderDeserialize(String str) {
        List<String> list = new LinkedList<>();
        Collections.addAll(list, str.split(SEP));
        return preOrderDeserialize(list);
    }

    public static TreeNode postOrderDeserialize(List<String> list) {
        if (list.isEmpty()) return null;
        //根节点在最后
        String rootValue = list.remove(list.size() - 1);
        if (rootValue.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(rootValue));
        root.right = postOrderDeserialize(list);
        root.left = postOrderDeserialize(list);
        return root;
    }

    /**
     * 后遍历反序列化
     */
    public static String postOrderSerialize(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        postOrder(sb, node);
        return sb.toString();
    }

    private static void postOrder(StringBuilder sb, TreeNode node) {
        if (node == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        postOrder(sb, node.left);
        postOrder(sb, node.right);
        sb.append(node.val).append(SEP);
    }

    /**
     * 层序序列化
     */
    public static String layerSerialize(TreeNode node) {
        if (node == null) return null;
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(node);
        while (!list.isEmpty()) {
            TreeNode n = list.poll();
            if (n == null) {
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(n.val).append(SEP);
            list.add(n.left);
            list.add(n.right);
        }
        return sb.toString();
    }

    /**
     * 层序反序列化
     */
    public static TreeNode layerDeserialize(String str) {
        if (str == null) return null;
        String[] arr = str.split(SEP);
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        for (int i = 1; i < arr.length; ) {
            TreeNode parent = list.poll();
            if (parent == null) break;
            String leftValue = arr[i++];
            if (leftValue.equals(NULL)) {
                parent.left = null;
            } else {
                parent.left = new TreeNode(Integer.parseInt(leftValue));
                list.add(parent.left);
            }
            String rightValue = arr[i++];
            if (rightValue.equals(NULL)) {
                parent.right = null;
            } else {
                parent.right = new TreeNode(Integer.parseInt(rightValue));
                list.add(parent.right);
            }
        }
        return root;
    }
}
