//package com.bulingbuu.filter;
//
//import java.io.*;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author bulingbuu
// * @date 18-11-13 下午5:06
// * <p>
// * DFA 过滤
// */
//public class DFAFilter {
//
//    public static void add(String keyword) {
//        char[] chars = keyword.toCharArray();
//        if (chars.length == 0) {
//            return;
//        }
//        Map<Character, Map> level = head;
//        int i = 0;
//        for (; i < chars.length; i++) {
//            char c = chars[i];
//            if (level.containsKey(c)) {
//                level = level.get(c);
//            } else {
//                if (!(level instanceof Map)) {
//                    break;
//                }
//                for (int j = i; j < chars.length; j++) {
//                    Map<Character, Map> tmpMap = new HashMap<Character, Map>();
//                    level.put(chars[j], tmpMap);
//                    level = tmpMap;
//                }
//                level.put(END_CHAR, null);
//                break;
//            }
//
//        }
//
//        if (i == chars.length - 1) {
//            level.put(END_CHAR, null);
//        }
//
//    }
//
//
//    public static String filter(String message, String repl) {
//        int start = 0;
//        StringBuilder ret = new StringBuilder();
//        while (start < message.length()) {
//            Map<Character, Map> level = head;
//            int step_ins = 0;
//            char[] chars = message.toCharArray();
//            for (int i = start; i < chars.length; i++) {
//                char tmp = chars[i];
//                if (level.containsKey(tmp)) {
//                    step_ins++;
//                    if (!level.get(tmp).containsKey(END_CHAR)) {
//                        level = level.get(tmp);
//                    } else {
//                        for (int x = 0; x < step_ins; x++) {
//                            ret.append(repl);
//                        }
//                        start += step_ins - 2;
//                        break;
//                    }
//                } else {
//                    while (step_ins > 0) {
//                        ret.append(chars[start - step_ins]);
//                        step_ins--;
//                        level = head;
//                    }
//
//                    ret.append(chars[start]);
//                }
//
//                start++;
//            }
//
//        }
//
//        return ret.toString();
//    }
//
//    public static void initFilter(String filePath) throws IOException {
////        InputStream inputStream = DFAFilter.class.getClassLoader().getResourceAsStream(filePath);
//        FileInputStream inputStream=new FileInputStream(filePath);
//        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
//        String line = null;
//        int i=0;
//        while ((line = br.readLine()) != null) {
////            add(line);
//            i++;
//            System.out.println(line+"  "+i);
//            if ("电影".equals(line)){
//                System.out.println();
//            }
//        }
//
//
//    }
//
//    private static Map<Character, Map> head = new HashMap<Character, Map>();
//
//    private static final char END_CHAR = '^';
//
////    public static void main(String[] args) throws IOException {
////        long start = System.currentTimeMillis();
////        initFilter("keywords");
////        long end=System.currentTimeMillis();
////
////        String msg="是否的开始福建省空间";
////        String msg1="地方回民吃猪肉,性爱电影,sdf习近平";
////        String msg2="所示阴茎挺进滋润肉洞里在阴户中抽送,达到法轮功";
////        msg=filter(msg,"*");
////        msg1=filter(msg1,"*");
////        msg2=filter(msg2,"*");
////        long end1=System.currentTimeMillis();
////
////        System.out.println(end-start);
////        System.out.println(end1-end);
////
////        System.out.println(msg);
////        System.out.println(msg1);
////        System.out.println(msg2);
////    }
//}
