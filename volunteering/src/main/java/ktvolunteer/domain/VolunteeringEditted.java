package ktvolunteer.domain;

import java.time.LocalDate;
import java.util.*;
import ktvolunteer.domain.*;
import ktvolunteer.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class VolunteeringEditted extends AbstractEvent {

    private Long volunteeringId;
    private String place;
    private Date schedule;
    private String title;
    private String category;
    private Integer personnel;
    private Long userId;

    public VolunteeringEditted(Volunteering aggregate) {
        super(aggregate);
    }

    public VolunteeringEditted() {
        super();
    }
}
//>>> DDD / Domain Event
