package Dz4;

import java.util.Date;

public class PesonalTask extends Task {
   private String coment;

    public PesonalTask(Priority priority, String name, String description,
                       boolean notik, Date dateStart, Date dateEnd, String coment) {
        super(priority, name, description, notik, dateStart, dateEnd);
        this.coment = coment;
    }

    @Override
    public String toString() {
        return super.toString()  +
                " коментарий: '" + coment + '\'' +
                '}';
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }
}
