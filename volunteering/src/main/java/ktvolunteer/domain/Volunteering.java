package ktvolunteer.domain;

import ktvolunteer.domain.VolunteeringApplied;
import ktvolunteer.domain.VolunteeringEditted;
import ktvolunteer.domain.VolunteeringCanceled;
import ktvolunteer.domain.VolunteeringCompleted;
import ktvolunteer.VolunteeringApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;


@Entity
@Table(name="Volunteering_table")
@Data

//<<< DDD / Aggregate Root
public class Volunteering  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    private Long volunteeringId;
    
    
    
    
    private String place;
    
    
    
    
    private Date schedule;
    
    
    
    
    private String title;
    
    
    
    
    private String category;
    
    
    
    
    private Integer personnel;
    
    
    
    
    private Long userId;

    @PostPersist
    public void onPostPersist(){
    List<AssociationInfo> associationInfoList = VolunteeringApplication.applicationContext
        .getBean(ktvolunteer.external.AssociationInfoService.class)
        .checkSchedule//();


        VolunteeringApplied volunteeringApplied = new VolunteeringApplied(this);
        volunteeringApplied.publishAfterCommit();



        VolunteeringEditted volunteeringEditted = new VolunteeringEditted(this);
        volunteeringEditted.publishAfterCommit();



        VolunteeringCanceled volunteeringCanceled = new VolunteeringCanceled(this);
        volunteeringCanceled.publishAfterCommit();



        VolunteeringCompleted volunteeringCompleted = new VolunteeringCompleted(this);
        volunteeringCompleted.publishAfterCommit();

    
    }

    public static VolunteeringRepository repository(){
        VolunteeringRepository volunteeringRepository = VolunteeringApplication.applicationContext.getBean(VolunteeringRepository.class);
        return volunteeringRepository;
    }



//<<< Clean Arch / Port Method
    public void editVolunteering(EditVolunteeringCommand editVolunteeringCommand){
        
        //implement business logic here:
        


    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void cancelVolunteering(CancelVolunteeringCommand cancelVolunteeringCommand){
        
        //implement business logic here:
        


    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void completeVolunteering(CompleteVolunteeringCommand completeVolunteeringCommand){
        
        //implement business logic here:
        


    }
//>>> Clean Arch / Port Method



}
//>>> DDD / Aggregate Root
