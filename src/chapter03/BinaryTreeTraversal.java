package chapter03;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Create by
 *
 * @author gwaifaiwong
 * @date 2020/7/9
 */
public class BinaryTreeTraversal {
    /**
     * 二叉树节点
     */
    private static class TreeNode{
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     *构建二叉树
     * @param inputList
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        //这里判断null很关键，如果元素时空，说明该节点不存在，跳出这一层递归；如果元素非null，继续递归构建该节点的左右孩子。
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 前序遍历
     * @param node
     */
    public static void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    /**
     * 中序遍历
     * @param node
     */
    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.println(node.data);
        inOrderTraversal(node.rightChild);
    }

    /**
     * 后序遍历
     * @param node
     */
    public static void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.println(node.data);
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{1,2,4,null,null,5,null,null,3,null,6}));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("前序遍历： ");
        preOrderTraversal(treeNode);
        System.out.println("中序遍历： ");
        inOrderTraversal(treeNode);
        System.out.println("后序遍历： ");
        postOrderTraversal(treeNode);
    }
}
