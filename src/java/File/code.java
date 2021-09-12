package src.java.File;

import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class code {
    public static void main(String[] args) {
        File[] paths;
        FileSystemView fsv = FileSystemView.getFileSystemView();

// returns pathnames for files and directory
        paths = File.listRoots();

// for each pathname in pathname array
        for (File path : paths) {
            // prints file and directory paths
            System.out.println("Drive Name: " + path);
                    OutFiles.out(path);

           // System.out.println(path.listFiles());
            System.out.println("Description: " + fsv.getSystemTypeDescription(path));
        }
    }
}
// вывод из определенной папки всех файлов
class OutFiles {
    public static void main(String[] args) {
        File folder = new File("c:/");
        out(folder);
    }
    public static void out(File file) {
//       if(file.equals(null)){
//           System.out.println("пустой диск");
//       }
        File folder=file;
        try {
            for(File file1:
         folder.listFiles()){
             System.out.println(file1.getName());
           }
        } catch (NullPointerException e) {
            System.out.println("пустой диск");
        }
    }
}




































