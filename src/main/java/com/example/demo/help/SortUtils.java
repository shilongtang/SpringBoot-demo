package com.example.demo.help;

import java.util.Arrays;

/**
 * @Author: 青菜
 * @Date: 2019/5/16 下午8:49
 * @Description: 排序算法util
 * @Version 1.0
 */
public class SortUtils {

    public static void main(String[] args) {
        //测试冒泡排序
        int[] list = {100,123,99,2,3,41,41231,23,23,43,56,78};
        //bubbleSort(list);
        //测试选择排序
        //selectionSort(list);
        //测试插入排序
        insertionSort(list);

    }

    /**
     * 冒泡排序（Bubble Sort）
     * 实现原理 ：比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     *           对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     *           针对所有的元素重复以上的步骤，除了最后一个；
     * @param list
     * @throws Exception
     */
    public static void bubbleSort(int[] list){
        for (int i=0; i<list.length; i++){
            for (int j=0;j<list.length - 1 -i; j++){
                if(list[j]>list[j+1]){
                    int x = list[j+1];
                    list[j+1] = list[j];
                    list[j] = x;
                }
            }
        }
        System.out.println(Arrays.toString(list));
    }

    /**
     * 选择排序（Selection Sort）
     * 实现原理：n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
     *          初始状态：无序区为R[1..n]，有序区为空；
     *          第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。
     *          该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     *          n-1趟结束，数组有序化了。
     *          个人理解（拿出最小的数字，放在最前面，遍历剩下的最小的数字，放置在有序区list[i+1]的位置）
     * @param list
     */
    private static void selectionSort(int[] list){
        for (int i=0; i<list.length; i++){
            int minIndex = i;
            for (int j=i; j<list.length; j++){
                if(list[j] < list[minIndex]){
                    //替换最小值索引
                    minIndex = j;
                }
            }
            int minValue = list[minIndex];
            list[minIndex] = list[i];
            list[i] = minValue;
        }
        System.out.println(Arrays.toString(list));
    }


    /**
     * 插入排序（Insertion Sort）
     * 实现原理：一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
     *          从第一个元素开始，该元素可以认为已经被排序；
     *          取出下一个元素，在已经排序的元素序列中从后向前扫描；
     *          如果该元素（已排序）大于新元素，将该元素移到下一位置；
     *          重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     *          将新元素插入到该位置后；
     *          重复步骤2~5。
     * @param list
     */
    private static void insertionSort(int[] list){
        //下一个元素值
        int nextValue = 0;
        for (int i=0; i<list.length - 1; i++){
            nextValue = list[+1];
            int index = i;
            while (index >=0 && nextValue < list[index]){
                //调换位置
                list[index+1] = list[index];
                index--;
            }
            list[index+1] = nextValue;
        }
        System.out.println(Arrays.toString(list));
    }




}
