package ktvolunteer.domain;

import ktvolunteer.domain.AssociationInfoEntered;
import ktvolunteer.domain.ScheduleAdded;
import ktvolunteer.AssociationApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;


@Entity
@Table(name="AssociationInfo_table")
@Data

//<<< DDD / Aggregate Root
public class AssociationInfo  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    private Long associationId;
    
    
    
    
    private String address;
    
    
    
    
    private String tel;
    
    
    
    
    private Integer bizNumber;
    
    
    
    
    private String email;
    
    
    
    
    private String place;
    
    
    
    
    private String schedule;
    
    
    
    
    private String title;
    
    
    
    
    private String category;

    @PostPersist
    public void onPostPersist(){


        AssociationInfoEntered associationInfoEntered = new AssociationInfoEntered(this);
        associationInfoEntered.publishAfterCommit();


        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        ktvolunteer.external.  = new ktvolunteer.external.();
        // mappings goes here
        AssociationApplication.applicationContext.getBean(ktvolunteer.external.Service.class)
            .();


        ScheduleAdded scheduleAdded = new ScheduleAdded(this);
        scheduleAdded.publishAfterCommit();

    
    }

    public static AssociationInfoRepository repository(){
        AssociationInfoRepository associationInfoRepository = AssociationApplication.applicationContext.getBean(AssociationInfoRepository.class);
        return associationInfoRepository;
    }






}
//>>> DDD / Aggregate Root
