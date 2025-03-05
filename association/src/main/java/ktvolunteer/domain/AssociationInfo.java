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
import ktvolunteer.external.AssociationInfoService;


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

        // 외부 서비스 호출 부분 수정
        AssociationApplication.applicationContext
            .getBean(ktvolunteer.external.AssociationInfoService.class)
            .checkSchedule();

        ScheduleAdded scheduleAdded = new ScheduleAdded(this);
        scheduleAdded.publishAfterCommit();
    }

    public static AssociationInfoRepository repository(){
        AssociationInfoRepository associationInfoRepository = AssociationApplication.applicationContext.getBean(AssociationInfoRepository.class);
        return associationInfoRepository;
    }






}
//>>> DDD / Aggregate Root
