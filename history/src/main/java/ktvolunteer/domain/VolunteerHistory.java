package ktvolunteer.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import ktvolunteer.HistoryApplication;
import ktvolunteer.domain.VolunteerHistoryAdded;
import lombok.Data;

@Entity
@Table(name = "VolunteerHistory_table")
@Data
//<<< DDD / Aggregate Root
public class VolunteerHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long historyId;

    private String place;

    private Date schedule;

    private String title;

    private String category;

    private Integer personnel;

    private Long userId;

    @PostPersist
    public void onPostPersist() {
        VolunteerHistoryAdded volunteerHistoryAdded = new VolunteerHistoryAdded(
            this
        );
        volunteerHistoryAdded.publishAfterCommit();
    }

    public static VolunteerHistoryRepository repository() {
        VolunteerHistoryRepository volunteerHistoryRepository = HistoryApplication.applicationContext.getBean(
            VolunteerHistoryRepository.class
        );
        return volunteerHistoryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void addVolunteerHistory(
        VolunteeringCompleted volunteeringCompleted
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        VolunteerHistory volunteerHistory = new VolunteerHistory();
        repository().save(volunteerHistory);

        */

        /** Example 2:  finding and process
        

        repository().findById(volunteeringCompleted.get???()).ifPresent(volunteerHistory->{
            
            volunteerHistory // do something
            repository().save(volunteerHistory);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
