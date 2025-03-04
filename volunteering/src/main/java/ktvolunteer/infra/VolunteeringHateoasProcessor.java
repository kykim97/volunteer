package ktvolunteer.infra;

import ktvolunteer.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class VolunteeringHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Volunteering>> {

    @Override
    public EntityModel<Volunteering> process(EntityModel<Volunteering> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/editvolunteering"
                )
                .withRel("editvolunteering")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/cancelvolunteering"
                )
                .withRel("cancelvolunteering")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/completevolunteering"
                )
                .withRel("completevolunteering")
        );

        return model;
    }
}
