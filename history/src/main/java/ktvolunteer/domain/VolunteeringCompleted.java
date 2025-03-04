package ktvolunteer.domain;

import java.util.*;
import ktvolunteer.domain.*;
import ktvolunteer.infra.AbstractEvent;
import lombok.*;

@Data
@ToString
public class VolunteeringCompleted extends AbstractEvent {

    private Long volunteeringId;
    private String place;
    private Date schedule;
    private String title;
    private String category;
    private Integer personnel;
    private Long userId;
}
