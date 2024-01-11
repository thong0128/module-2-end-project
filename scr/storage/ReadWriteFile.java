package storage;

import model.BasicBow;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReadWriteFile {
    public List<BasicBow> readFile(){
        File file = new File("Bow.dat");
        try {
            InputStream inputStream = new  FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            return (List<BasicBow>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }

    }

    //    ghi file
    public void writeFile(List<BasicBow> Bowlist){
        File file = new File("Bow.dat");
        try {
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
            objectOutputStream.writeObject(Bowlist);
            objectOutputStream.close();
            os.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ReadWriteFile() {
    }
    private static ReadWriteFile instance;

    public static ReadWriteFile getInstance() {
        if(instance==null) {
            instance = new ReadWriteFile();
        }
        return instance;
    }
}