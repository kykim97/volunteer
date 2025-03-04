package ktvolunteer.infra;

import ktvolunteer.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class AssociationInfoHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<AssociationInfo>> {

    @Override
    public EntityModel<AssociationInfo> process(
        EntityModel<AssociationInfo> model
    ) {
        return model;
    }
}
