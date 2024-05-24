package com.pardys.pardysback.image.util;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;


public class ImageUtil {

    public static byte[] compressImage(byte[] data) {

        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[20000000];
        while (!deflater.finished()) {
            int size = deflater.deflate(tmp);
            outputStream.write(tmp, 0, size);
        }
        try {
            outputStream.close();
        } catch (Exception e) {
        }
        return outputStream.toByteArray();
    }

    //    public static byte[] decompressImage(byte[] data) {
//        Inflater inflater = new Inflater();
//        inflater.setInput(data);
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//        byte[] tmp = new byte[4*1024];
//        System.out.println("in decompress image by util 1");
//        try {
//            while (!inflater.finished()) {
//                int count = inflater.inflate(tmp);
//                outputStream.write(tmp, 0, count);
//            }
//            System.out.println("in decompress image by util 2");
//            outputStream.close();
//        } catch (Exception exception) {
//        }
//        System.out.println("in decompress image by util 3");
//        return outputStream.toByteArray();
//    }
    public static byte[] decompressImage(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[10000000];
        System.out.println("in decompress image by util 1");

        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(tmp);
                if (count == 0) {
                    if (inflater.needsInput()) {
                        System.err.println("Inflater needs more input.");
                        break;
                    }
                    if (inflater.needsDictionary()) {
                        System.err.println("Inflater needs a dictionary.");
                        break;
                    }
                    if (inflater.finished()) {
                        break;
                    }
                }
                outputStream.write(tmp, 0, count);
            }
            System.out.println("in decompress image by util 2");
            outputStream.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            inflater.end(); // Ensure resources are released
        }
        System.out.println("in decompress image by util 3");
        return outputStream.toByteArray();
    }
}
