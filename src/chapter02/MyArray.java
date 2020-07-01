package chapter02;

/**
 * Create by
 *
 * @author gwaifaiwong
 * @date 2020/6/30
 */
public class MyArray {
    private int[] array;
    private int size;

    public MyArray(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    /**
     * 数组插入元素
     *
     * @param index   插入的位置
     * @param element 插入的元素
     */
    public void insert(int index, int element) throws Exception {
        //判断访问下标是否超出范围
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组实际范围！");
        }
        //如果实际元素达到数组容量实际范围，则进行扩容
        if (size >= array.length) {
            resize();
        }
        //从右向左循环，将元素逐个向右挪一位
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        //腾出的位置放入新元素
        array[index] = element;
        size++;
    }

    /**
     * 数组删除元素
     *
     * @param index 删除的位置
     */
    public int delete(int index) throws  Exception {
        //判断访问下标是否超出范围
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出数组实际范围！");
        }

        //删除的数据
        int deleteElement = array[index];

        //从左向右循环，将元素逐个向左挪一位
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i+1];
        }
        size--;
        //返回被删除的数据
        return deleteElement;

    }
    /**
     * 数组扩容
     */
    public void resize() {
        int[] arrayNew = new int[array.length * 2];
        System.arraycopy(array, 0, arrayNew, 0, array.length);
        array = arrayNew;
    }

    /**
     * 输出数组
     */
    public void output(){
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        MyArray myArray = new MyArray(5);
        myArray.insert(0, 2);
        myArray.insert(1, 5);
        myArray.insert(2, 6);
        myArray.insert(3, 8);
        myArray.insert(4, 5);
//        myArray.insert(3, 6);
//        myArray.insert(2, 13);
        myArray.delete(3);
        myArray.output();

    }
}
