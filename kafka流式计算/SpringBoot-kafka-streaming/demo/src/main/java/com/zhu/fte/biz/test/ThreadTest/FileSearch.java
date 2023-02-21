package com.zhu.fte.biz.test.ThreadTest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileSearch {
    private static final String IP_ADDRESS = "192.168.1.1";

    public static void main(String[] args) {
        String directoryPath = "/Users/helloword/workspace/bqs";
        File directory = new File(directoryPath);
        List<String> filePaths = searchFilesContainingIpAddress(directory, IP_ADDRESS);
        System.out.println("Files containing IP address " + IP_ADDRESS + ":");
        for (String filePath : filePaths) {
            System.out.println(filePath);
        }
    }

    public static List<String> searchFilesContainingIpAddress(File directory, String ipAddress) {
        List<String> filePaths = new ArrayList<>();
        File[] files = directory.listFiles();
        if (files == null) {
            return filePaths;
        }
        for (File file : files) {
            String filePath = file.toPath().toString();
            if (file.isDirectory()) {
                filePaths.addAll(searchFilesContainingIpAddress(file, ipAddress));
            } else if(filePath.contains(".properties") || filePath.contains(".xml") || filePath.contains(".java")|| filePath.contains(".pom")){
                try {
                    List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

                    for (String line : lines) {
                        if (line.contains(ipAddress)) {
                            filePaths.add(file.getAbsolutePath());
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Error reading file: " + file.getAbsolutePath());
                }
            }
        }
        return filePaths;
    }
}