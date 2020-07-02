package chapter02;


/**
 * Create by
 *
 * @author gwaifaiwong
 * @date 2020/7/1
 */
public class MyLinkedList {

    /**
     * 头结点指针
     */
    private Node head;
    /**
     * 尾节点指针
     */
    private Node last;
    /**
     * 链表实际长度
     */
    private int size;

    /**
     * 链表节点
     */
    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    /**
     * 输出链表
     */
    public void output() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    /**
     * 链表查找元素
     * @param index 查找的位置
     * @return
     * @throws Exception
     */
    public Node get(int index) throws Exception {
        if (index<0 || index>=size){
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 链表插入元素
     * @param index 插入位置
     * @param data 插入元素
     * @throws Exception
     */
    public void insert(int index ,int data) throws Exception{


        if (index<0 || index>size){
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node insertNode = new Node(data);
        if (size == 0) {
            //空链表
            head = insertNode;
            last = insertNode;
        } else if (index == 0) {
            //插入头部
            insertNode.next = head;
            head = insertNode;
        } else if (size == index) {
            //插入尾部
            last.next = insertNode;
            last = insertNode;
        } else {
            //插入中间
            Node prevNode = get(index - 1);
            insertNode.next = prevNode.next;
            prevNode.next = insertNode;
        }
        size++;
    }

    /**
     * 链表删除元素
     * @param index
     * @return
     * @throws Exception
     */
    public Node remove(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node removeNode = null;
        if (index == 0) {
            //删除头结点
            removeNode = head;
            head = head.next;
        } else if (index == size - 1) {
            //删除尾节点
            Node prevNode = get(index - 1);
            removeNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        } else {
            //删除中间节点
            Node prevNode = get(index - 1);
            Node nextNode = prevNode.next.next;
            removeNode = prevNode.next;
            prevNode.next = nextNode;
        }
        size--;
        return removeNode;
    }

    public static void main(String[] args) throws Exception {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(0, 3);
        myLinkedList.insert(0, 4);
        myLinkedList.insert(2,9);
        myLinkedList.insert(3,5);
        myLinkedList.insert(1,6);
        myLinkedList.remove(0);
        myLinkedList.output();
    }


}
