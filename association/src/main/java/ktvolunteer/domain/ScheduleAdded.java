package ktvolunteer.domain;

import java.time.LocalDate;
import java.util.*;
import ktvolunteer.domain.*;
import ktvolunteer.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ScheduleAdded extends AbstractEvent {

    private Long associationId;
    private String place;
    private Date schedule;
    private String title;
    private String category;

    public ScheduleAdded(AssociationInfo aggregate) {
        super(aggregate);
    }

    public ScheduleAdded() {
        super();
    }
}
//>>> DDD / Domain Event
