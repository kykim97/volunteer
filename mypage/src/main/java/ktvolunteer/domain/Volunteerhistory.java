package ktvolunteer.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "Volunteerhistory_table")
@Data
public class Volunteerhistory {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long userId;
    private Long associationId;
    private String title;
    private String category;
    private Date schedule;
}
