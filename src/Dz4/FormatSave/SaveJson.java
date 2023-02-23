package Dz4.FormatSave;

import Dz4.Task;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveJson extends SaveFormat<Task> {
    @Override
    public void saveAs(List<Task> calendar, String path) {
        try (FileWriter writer = new FileWriter(path+".json", false)) {
            writer.write("{");
            for (Task t : calendar) {
                String task = String.format("""
                        "%d": {
                        "Название":"%s",
                        "дата старта":"%s",
                        "дата дедлайна":"%s",
                        "приоритет":"%s"
                        },
                        """, t.getId(), t.getName(), t.getDateStart(), t.getDateEnd(), t.getPriority());
                writer.write(task);
            }
            writer.write("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

