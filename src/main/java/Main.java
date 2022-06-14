import java.io.File;
import java.io.IOException;

/*
CLI directory to remove DS store file
 */
public class Main {
    public static void main(String[] args) throws IOException {
        File currentDir;
        if (args.length == 0)
        {
            currentDir = new File(".");
        }
        else {
            currentDir = new File(args[0]);
        }
        String absDir = currentDir.getAbsolutePath();
        System.out.println("Dir: "+ absDir);
        deleteDSStore(new File(absDir));
    }

    private static void deleteDSStore(File file) throws IOException {
        if (file.isDirectory()) {
            File[] entries = file.listFiles();
            if (entries != null) {
                for (File entry : entries) {
                        deleteDSStore(entry);
                }
            }
        }

        if (file.getName().equals(".DS_Store")) {
            if(!file.delete()) {
                throw new IOException("Failed to delete " + file);
            }
            System.out.println("deleted: " + file.getAbsolutePath());
        }
    }



}
