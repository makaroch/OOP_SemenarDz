package Dz4;

import Dz4.FormatSave.SerializingMy;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public abstract class Task implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;
    protected Priority priority;
    protected String name;
    protected String description;
    protected boolean notification;
    protected Date dateStart;// время начала и день
    protected Date dateEnd; // время конца и день
    protected long durationTask;

    public Task(Priority priority, String name, String description, boolean notification, Date dateStart, Date dateEnd) {
        this.priority = priority;
        this.name = name;
        this.description = description;
        this.notification = notification;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.durationTask = dateEnd.getTime() - dateStart.getTime();
    }

    @Override
    public String toString() {
        return "Задача{" +
                "приоритет:" + priority +
                ", навание: '" + name + '\'' +
                ", описание: '" + description + '\'' +
                ", нотиф.: " + notification +
                ", дата начала: " + dateStart +
                ", дата дедлайна: " + dateEnd;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isNotification() {
        return notification;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public long getDurationTask() {
        return durationTask;
    }
    public int getId(){
        return this.hashCode();
    }
}
