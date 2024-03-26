package lk.ijse.dep12.fx.controls;

import java.io.File;

public class Demo {

    public static void main(String[] args) {
        String path = "/bin";
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f + "-" + (f.isFile() ? "File": "Directory"));
        }
    }
}
