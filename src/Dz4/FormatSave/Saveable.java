package Dz4.FormatSave;

import Dz4.Calendar;
import Dz4.Task;

import java.util.List;

public interface Saveable<T extends Task> {
    void saveAs(List<T> calendar, String path);
}
