package com.bulingbuu.practice.array;

/**
 * @author bulingbuu
 * @date 19-2-18 下午4:38
 * <p>
 * 一个支持动态扩容的数组
 * 申请一段内存,当array满后,扩容1倍,并将其复制过去
 */
public class DynamicArray {

    private int[] array;
    //当前个数
    private int size;

    public DynamicArray(int length) {
        array = new int[length];
    }

    public DynamicArray() {
        array = new int[2];
    }

    public boolean add(int value) {
        if (size == array.length - 1) {
            resize();
        }
        array[size] = value;
        size++;

        return true;
    }

    public int remove(int index) {
        int oldValue = array[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(array, index + 1, array, index, numMoved);
        }
        array[--size] = 0;
        return oldValue;
    }

    private void resize() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {

            sb.append(array[i]);
            sb.append("   ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        DynamicArray array = new DynamicArray();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        System.out.println(array);
        array.remove(3);
        System.out.println(array);
    }

}
