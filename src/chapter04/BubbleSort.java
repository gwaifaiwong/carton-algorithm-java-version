package chapter04;

import java.util.Arrays;

/**
 * Create by
 *
 * @author gwaifaiwong
 * @date 2020/7/19
 */
public class BubbleSort {

    public static void sort01(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                int tmp = 0;
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    public static void sort02(int[] array) {


        for (int i = 0; i < array.length - 1; i++) {

            //每一轮的初值设置为true
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                int tmp;
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j + 1] = tmp;
                    //因为有元素交换，所以设为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static void sort03(int[] array) {
        int tmp = 0;
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        //无序数列的边界，每次比较只需要比到这里为止
        int sortBorder = array.length-1;
        for (int i = 0; i < array.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {

                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j + 1] = tmp;
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
//        sort01(array);
//        sort02(array);
        sort03(array);
        System.out.println(Arrays.toString(array));

    }
}
