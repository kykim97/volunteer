package ktvolunteer.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import ktvolunteer.config.kafka.KafkaProcessor;
import ktvolunteer.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class VolunteerhistoryViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private VolunteerhistoryRepository volunteerhistoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenVolunteeringCompleted_then_CREATE_1(
        @Payload VolunteeringCompleted volunteeringCompleted
    ) {
        try {
            if (!volunteeringCompleted.validate()) return;

            // view 객체 생성
            Volunteerhistory volunteerhistory = new Volunteerhistory();
            // view 객체에 이벤트의 Value 를 set 함
            // view 레파지 토리에 save
            volunteerhistoryRepository.save(volunteerhistory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
