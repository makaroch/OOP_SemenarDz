package Dz4.FormatSave;

import Dz4.Calendar;
import Dz4.Task;

import java.util.List;

public interface SerializingMy<T extends Task> {
   void exportingCalendar(Calendar<T> calendar, String path);
   Calendar<T> importingCalendar(String path);
}
