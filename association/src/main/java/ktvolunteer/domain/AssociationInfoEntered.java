package ktvolunteer.domain;

import java.time.LocalDate;
import java.util.*;
import ktvolunteer.domain.*;
import ktvolunteer.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class AssociationInfoEntered extends AbstractEvent {

    private Long associationId;
    private String address;
    private String tel;
    private Integer bizNumber;
    private String email;

    public AssociationInfoEntered(AssociationInfo aggregate) {
        super(aggregate);
    }

    public AssociationInfoEntered() {
        super();
    }
}
//>>> DDD / Domain Event
