package ktvolunteer.infra;

import ktvolunteer.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class VolunteerHistoryHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<VolunteerHistory>> {

    @Override
    public EntityModel<VolunteerHistory> process(
        EntityModel<VolunteerHistory> model
    ) {
        return model;
    }
}
