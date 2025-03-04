package ktvolunteer.domain;

import java.time.LocalDate;
import java.util.*;
import ktvolunteer.domain.*;
import ktvolunteer.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class VolunteerInfoEntered extends AbstractEvent {

    private Long userId;
    private String name;
    private Date birth;
    private String tel;
    private String email;
    private String profileImg;
    private String interest;
    private Date time;
    private String location;

    public VolunteerInfoEntered(VolunteerInfo aggregate) {
        super(aggregate);
    }

    public VolunteerInfoEntered() {
        super();
    }
}
//>>> DDD / Domain Event
