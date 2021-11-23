package src.java.Проект_Полигон;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class solution {
    public static void main(String[] args) throws IOException {
        List<String> files = getFileTree("c:/инфинити");
        for (String z : files
        ) {
            System.out.println(z);

        }
    }


    public static List<String> getFileTree(String root) throws IOException {
        List<String> pathesFiles = new ArrayList<>();
        Queue<File> listFiles = new ArrayDeque<>();
        listFiles.add(new File(root));
        while (!listFiles.isEmpty()) {
            File current = listFiles.poll();
            if (current.isDirectory()) {
                for (File x: current.listFiles()) {
                    listFiles.offer(x);
                }
            } else {
                pathesFiles.add(current.getAbsolutePath());
            }

//            File current = listFiles.poll();
//            File[] fileDirList = current.listFiles();
//            if (fileDirList != null) {
//                for (File z : fileDirList
//                ) {
//                    if (z.isDirectory()) {
//                        listFiles.offer(z);
//                    } else pathesFiles.add(z.getAbsolutePath());
//                }
//            }
        }
        return pathesFiles;
    }
}