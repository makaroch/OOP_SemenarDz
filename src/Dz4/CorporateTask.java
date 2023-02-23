package Dz4;

import java.util.Date;

public class CorporateTask extends Task {
    private final String organizer;

    public CorporateTask(Priority priority, String name, String description,
                         boolean notik, Date dateStart, Date dateEnd, String organizer) {
        super(priority, name, description, notik, dateStart, dateEnd);
        this.organizer = organizer;
    }

    @Override
    public String toString() {
        return super.toString() +
                " оргонизатор: '" + organizer + '\'' +
                '}';
    }

    public String getOrganizer() {
        return organizer;
    }
}
