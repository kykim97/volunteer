package ktvolunteer.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import ktvolunteer.config.kafka.KafkaProcessor;
import ktvolunteer.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    VolunteerHistoryRepository volunteerHistoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='VolunteeringCompleted'"
    )
    public void wheneverVolunteeringCompleted_AddVolunteerHistory(
        @Payload VolunteeringCompleted volunteeringCompleted
    ) {
        VolunteeringCompleted event = volunteeringCompleted;
        System.out.println(
            "\n\n##### listener AddVolunteerHistory : " +
            volunteeringCompleted +
            "\n\n"
        );

        // Sample Logic //
        VolunteerHistory.addVolunteerHistory(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
