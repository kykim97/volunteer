package ktvolunteer.domain;

import java.time.LocalDate;
import java.util.*;
import ktvolunteer.domain.*;
import ktvolunteer.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class VolunteerHistoryAdded extends AbstractEvent {

    private Long historyId;
    private String place;
    private Date schedule;
    private String title;
    private String category;
    private Integer personnel;
    private Long userId;

    public VolunteerHistoryAdded(VolunteerHistory aggregate) {
        super(aggregate);
    }

    public VolunteerHistoryAdded() {
        super();
    }
}
//>>> DDD / Domain Event
