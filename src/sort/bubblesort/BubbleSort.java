package sort.bubblesort;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description: 冒泡排序
 * @author: bingyu
 * @date: 2019/9/21 15:39
 */
public class BubbleSort {

    //元素交换
    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //最简单的冒泡排序
    public static void bubbleSortTest1(int[] arr) {
        for(int i=0;i<arr.length;++i) { //n个数需要冒泡n次
			/*这里是每一次冒泡都比较了n-1次，因此有一个优化点，因为每次冒泡，最大的一个数都会排在最后，
			因此没必要再所有都比较一次，比较n-1-i次即可,i就是表示冒泡的次数，因为冒泡了i次，后面倒数
			i个数就已经是有序的了,不需要再比较*/
            for(int j=0;j<arr.length-1;++j) {
                if (arr[j]>arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    //冒泡排序第一次优化
    public static void bubbleSortTest2(int[] arr) {
        for(int i=0;i<arr.length;++i) {
            for(int j=0;j<arr.length-1-i;++j) { //只需要比较n-1-i次
                if (arr[j]>arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    //冒泡排序第二次优化,当所有数字已经是有序时停止排序，例如2,1,3,4,5这里只要冒泡一次即可，第二次如果发现没有元素交换则退出
    public static void bubbleSort(int[] arr) {
        if (arr.length<=1) {
            return;
        }
        for(int i=0;i<arr.length;++i) {
            boolean flag = true;
            for(int j=0;j<arr.length-1-i;++j) { //只需要比较n-1-i次
                if (arr[j]>arr[j+1]) {
                    flag = false;
                    swap(arr, j, j+1);
                }
            }
            if (flag) { //只要是true说明前面冒泡没有交换元素，说明元素已经是有序
                break;
            }
        }
    }


    /*
    总结：1.冒泡排序是一个原地排序，因为它无需算法辅助空间，空间复杂度为常量
         2.冒泡排序是一个稳定排序，冒泡排序中只有元素交换时才会改变顺序，相同大小的元素不会交换，因此是稳定排序
         3.冒泡排序的时间复杂度分析--,最佳时间复杂度，即已经是有序时，只需进行一次冒泡，n个元素需要执行n-1次交换，因此最佳时间复杂度是O(n);
            最差时间复杂度，即刚好是逆序，n个元素需要执行n次冒泡，执行交换的元素次数为n-1+n-2+n-3+....+1=n(n+1)/2;因此最差时间复杂度是0(n^2)

    */
    public static void main(String[] args){
        int[] arr = {2,1,3,4,5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}