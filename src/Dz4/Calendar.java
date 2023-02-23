package Dz4;

import Dz4.FormatSave.Saveable;
import Dz4.FormatSave.SerializingMy;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;
import java.util.List;

public class Calendar<T extends Task> implements Iterable<T>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private List<T> listTask;

    public Calendar() {
        this.listTask = new ArrayList<>();
    }

    public boolean checkData(Date dataStart, Date dataEnd, Priority priority) {
        for (Task t : listTask) {
            if ((t.dateStart.after(dataStart) && dataStart.after(t.dateEnd)) //если начало и конец добаляемой задачи пересек
                    && (t.dateStart.after(dataEnd) && dataEnd.after(t.dateEnd))) {
                return false;
            }
        }
        return true;
    }

    public void addTask(T task) {
        listTask.add(task);
        sortByDedlain();
    }

    public void showAll() {
        for (var t : listTask) {
            System.out.println(t);
        }
    }

    public T getByName(String s) {
        for (var t : listTask) {
            if (t.getName().equals(s)) {
                return t;
            }
        }
        return null;
    }

    public void authorSearch(String s) {
        for (var t : listTask) {
            if (t instanceof CorporateTask tCT) {
                if (tCT.getOrganizer().equals(s)) {
                    System.out.println(tCT);
                    return;
                }
            }
        }
        System.out.println("Нет такого.");
    }

    public void sortByPrior() {
        listTask.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o2.getPriority().compareTo(o1.getPriority());
            }
        });
    }

    public void sortByDedlain() {
        listTask.sort(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getDateEnd().compareTo(o2.getDateEnd());
            }
        });
    }


    @Override
    public Iterator<T> iterator() {
        return listTask.iterator();
    }

    public void saveAs(String path, Saveable<T> format) {
        format.saveAs(listTask, path);
    }

    public void exportingCalendar(String path, SerializingMy<T> serializing) {
        serializing.exportingCalendar(this, path);
    }

    public void importingCalendar(String path, SerializingMy<T> serializing) {
        //this = serializing.importingCalendar(path); // ненонятно но очень интересно
    }
}
