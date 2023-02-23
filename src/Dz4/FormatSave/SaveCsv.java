package Dz4.FormatSave;

import Dz4.Task;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveCsv extends SaveFormat<Task> {
    @Override
    public void saveAs(List<Task> calendar, String path) {
        try(FileWriter writer = new FileWriter(path+".csv", true)) {
            for(Task t :calendar){
                writer.write(t.toString());
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
