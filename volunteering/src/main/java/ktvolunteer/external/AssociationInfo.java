package ktvolunteer.external;

import java.util.Date;
import lombok.Data;

@Data
public class AssociationInfo {

    private Long associationId;
    private String address;
    private String tel;
    private Integer bizNumber;
    private String email;
    private String place;
    private String schedule;
    private String title;
    private String category;
}
