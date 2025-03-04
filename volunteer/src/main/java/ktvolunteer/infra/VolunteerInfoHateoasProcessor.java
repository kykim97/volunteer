package ktvolunteer.infra;

import ktvolunteer.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class VolunteerInfoHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<VolunteerInfo>> {

    @Override
    public EntityModel<VolunteerInfo> process(
        EntityModel<VolunteerInfo> model
    ) {
        return model;
    }
}
