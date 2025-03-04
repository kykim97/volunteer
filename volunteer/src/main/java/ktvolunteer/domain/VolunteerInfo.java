package ktvolunteer.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import ktvolunteer.VolunteerApplication;
import ktvolunteer.domain.VolunteerInfoEntered;
import lombok.Data;

@Entity
@Table(name = "VolunteerInfo_table")
@Data
//<<< DDD / Aggregate Root
public class VolunteerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String name;

    private Date birth;

    private String tel;

    private String email;

    private String profileImg;

    private String interest;

    private Date time;

    private String location;

    @PostPersist
    public void onPostPersist() {
        VolunteerInfoEntered volunteerInfoEntered = new VolunteerInfoEntered(
            this
        );
        volunteerInfoEntered.publishAfterCommit();
    }

    public static VolunteerInfoRepository repository() {
        VolunteerInfoRepository volunteerInfoRepository = VolunteerApplication.applicationContext.getBean(
            VolunteerInfoRepository.class
        );
        return volunteerInfoRepository;
    }
}
//>>> DDD / Aggregate Root
