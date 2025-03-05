package ktvolunteer.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CancelVolunteeringCommand {

    private Long volunteeringId;
    private String place;
    private Date schedule;
    private String title;
    private String category;
    private Integer personnel;
}
