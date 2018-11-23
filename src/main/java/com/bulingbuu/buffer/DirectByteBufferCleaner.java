//package com.bulingbuu.buffer;
//
//import sun.nio.ch.DirectBuffer;
//
//import java.nio.ByteBuffer;
//
///**
// * @author bulingbuu
// * @date 18-11-2 上午11:14
// */
//public class DirectByteBufferCleaner {
//
//    public static void clean(final ByteBuffer byteBuffer) {
//        if (byteBuffer.isDirect()) {
//            ((DirectBuffer) byteBuffer).cleaner().clean();
//        }
//    }
//
//    public static void sleep(long i) {
//        try {
//            Thread.sleep(i);
//        } catch (Exception e) {
//            /*skip*/
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 1024 * 100);
//        System.out.println("start");
//        sleep(20000);
//        clean(buffer);
//        System.out.println("end");
//        sleep(10000);
//    }
//}
