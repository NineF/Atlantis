package com.bulingbuu.problem.base;

import java.util.ArrayList;
import java.util.List;

public class MinimumTotal {
    public static void main(String[] args) {
        MinimumTotal total=new MinimumTotal();
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list1=new ArrayList<>();
        list1.add(2);
        lists.add(list1);

        List<Integer> list2=new ArrayList<>();
        list2.add(3);
        list2.add(4);
        lists.add(list2);

        List<Integer> list3=new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        lists.add(list3);

        List<Integer> list4=new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);

        lists.add(list4);

        System.out.println(total.minimumTotal(lists));

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[][] item = new int[length][length];
        item[0][0] = triangle.get(0).get(0);
        for (int i=1;i<triangle.size();i++){
            for (int j=0;j<triangle.get(i).size();j++){
                //右边
                int tmp = Integer.MAX_VALUE;
                //避免边界问题
                if (j != triangle.get(i).size() - 1) {
                    tmp = item[i - 1][j] + triangle.get(i).get(j);
                }
                //左边
                if (j != 0) {
                    int tmp1 = item[i - 1][j - 1] + triangle.get(i).get(j);
                    if (tmp1 < tmp) {
                        tmp = tmp1;
                    }
                }
                item[i][j] = tmp;
            }
        }
        int result=item[length - 1][0];
        for (int i = 0; i < length; i++) {
            result=Math.min(result,item[length-1][i]);
        }
        return result;
    }
}
