package com.bulingbuu.problem.deque;

/**
 * @author bulingbuu
 * @date 19-2-20 下午5:56
 * <p>
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 * <p>
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 * 示例：
 * <p>
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 所有值的范围为 [1, 1000]
 * 操作次数的范围为 [1, 1000]
 * 请不要使用内置的双端队列库。
 */
public class MyCircularDeque {

    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(4);
        System.out.println(deque.insertFront(9));
        System.out.println(deque.deleteFront());
        System.out.println(deque.getRear());

        System.out.println(deque.insertLast(2));
        System.out.println(deque.insertLast(3));
        System.out.println(deque.insertLast(4));
        System.out.println(deque.getFront());
        System.out.println(deque.getRear());
        System.out.println(deque.getFront());
        System.out.println(deque.deleteLast());
        System.out.println(deque.getRear());

    }

    private int[] array;
    private int head;
    private int tail;
    private int size;
    private int num;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        array = new int[k];
        size = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (!isEmpty()) {
            head = head + size;
            head--;
            head %= size;
        } else {
            head = tail = 0;
        }
        array[head] = value;
        num++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if (!isEmpty()) {
            tail++;
            tail = tail % size;
        } else {
            head = tail = 0;
        }
        array[tail] = value;
        num++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        array[head] = 0;
        head++;
        head %= size;
        num--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        array[tail] = 0;
        tail = tail + size;
        tail--;
        tail %= size;
        num--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return array[head % size];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return array[tail % size];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        if (num == 0) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        if (num == size) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */