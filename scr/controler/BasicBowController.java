package controler;

import model.BasicBow;
import storage.ReadWriteFile;

import java.util.List;

public class BasicBowController {
    public static ReadWriteFile readWriteFile = ReadWriteFile.getInstance();
    public static List<BasicBow> basicBowList = readWriteFile.readFile();
    public static BasicBowController instance;
    public static BasicBowController getInstance(){
        if (instance == null) {
            return new BasicBowController();
        }
        return  instance;
    }
    private BasicBowController() {
    }

    public List<BasicBow> getBasicBowList() {
        return basicBowList;
    }

    public void setBasicBowList(List<BasicBow> basicBowList) {
        BasicBowController.basicBowList = basicBowList;
        readWriteFile.writeFile(basicBowList);
    }

    public void addNewBasicBow(BasicBow basicBow) {
        basicBowList.add(basicBow);
        readWriteFile.writeFile(basicBowList);
    }
    public void deleteByID(int id){
        for (BasicBow basicBow:basicBowList){
            if (basicBow.getId()==id){
                basicBowList.remove(basicBow);
                readWriteFile.writeFile(basicBowList);
                return;
            }
        }
        System.out.println("No bow with id: " + id);
    }
}
