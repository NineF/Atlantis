package com.bulingbuu.base;

import lombok.Getter;
import lombok.Setter;

/**
 * @author bulingbuu
 * @date 19-1-27 下午8:18
 */
public class YHTriangle {

    /**
     * @param root 根节点
     * @param height 高度
     */
    public void triangle(Node root, int height, int maxLen) {
        boolean[][] items = new boolean[height][maxLen + 1];
        if (root.data > maxLen) {
            return;
        }
        items[0][root.data] = true;
        for (int i = 1; i < height; i++) {
            for (int j = 0; j <= maxLen; j++) {
                if (items[i - 1][j]) {

                }
            }
        }
    }

    public void triangle(int[] items, int length) {

    }


    @Setter
    @Getter
    class Node {
        int data;
        Node left;
        Node right;
    }


}
