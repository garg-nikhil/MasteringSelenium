package utils.Practice;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class FileOpsNio {
    public static void main(String[] args) throws IOException {
        moveOrRename();
    }

    public static void filecreate() throws IOException {
        Path path = Paths.get("C:\\Users\\nikhi\\OneDrive\\Desktop\\sample.txt");
        String writeMe="Hello from java NIO.!!";
        try{
            Files.createFile(path);
            //Files.createDirectory(path);
            Files.writeString(path,writeMe, StandardOpenOption.APPEND);
            System.out.println("Contents of the file are as follows: "+Files.readString(path));

        }catch(Exception e){
            //Files.writeString(path,writeMe);
            Files.writeString(path,writeMe, StandardOpenOption.APPEND);
            String readMe=Files.readString(path);
            //System.out.println("Contents of the file are as follows: "+readMe);
            List<String> readAllLines = Files.readAllLines(path);
            for(String a: readAllLines){
                System.out.println(a.contains("java"));
            }

            if(readMe.contains("java")){
                System.out.println("Found");
            }

            System.out.println(e);
        }
    }

    public static void copyFile(){
        Path sourcePath = Paths.get("C:\\Users\\nikhi\\OneDrive\\Desktop\\sample.txt");
        Path destPath = Paths.get("C:\\Users\\nikhi\\OneDrive\\Desktop\\backup.txt");
        try{
            Files.copy(sourcePath,destPath, StandardCopyOption.REPLACE_EXISTING);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void moveOrRename(){
        Path srcPath = Paths.get("C:\\Users\\nikhi\\OneDrive\\Desktop\\sample1.txt");
        Path destPath = Paths.get("C:\\Users\\nikhi\\OneDrive\\Desktop\\New folder\\sample1.txt");
        try{
            Files.move(srcPath,destPath);
        }catch(Exception e){

        }
    }


}
