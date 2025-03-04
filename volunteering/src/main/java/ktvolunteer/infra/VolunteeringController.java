package ktvolunteer.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import ktvolunteer.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/volunteerings")
@Transactional
public class VolunteeringController {

    @Autowired
    VolunteeringRepository volunteeringRepository;

    @RequestMapping(
        value = "/volunteerings/{id}/editvolunteering",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Volunteering editVolunteering(
        @PathVariable(value = "id") Long id,
        @RequestBody EditVolunteeringCommand editVolunteeringCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /volunteering/editVolunteering  called #####"
        );
        Optional<Volunteering> optionalVolunteering = volunteeringRepository.findById(
            id
        );

        optionalVolunteering.orElseThrow(() -> new Exception("No Entity Found")
        );
        Volunteering volunteering = optionalVolunteering.get();
        volunteering.editVolunteering(editVolunteeringCommand);

        volunteeringRepository.save(volunteering);
        return volunteering;
    }

    @RequestMapping(
        value = "/volunteerings/{id}/cancelvolunteering",
        method = RequestMethod.DELETE,
        produces = "application/json;charset=UTF-8"
    )
    public Volunteering cancelVolunteering(
        @PathVariable(value = "id") Long id,
        @RequestBody CancelVolunteeringCommand cancelVolunteeringCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /volunteering/cancelVolunteering  called #####"
        );
        Optional<Volunteering> optionalVolunteering = volunteeringRepository.findById(
            id
        );

        optionalVolunteering.orElseThrow(() -> new Exception("No Entity Found")
        );
        Volunteering volunteering = optionalVolunteering.get();
        volunteering.cancelVolunteering(cancelVolunteeringCommand);

        volunteeringRepository.delete(volunteering);
        return volunteering;
    }

    @RequestMapping(
        value = "/volunteerings/{id}/completevolunteering",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Volunteering completeVolunteering(
        @PathVariable(value = "id") Long id,
        @RequestBody CompleteVolunteeringCommand completeVolunteeringCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /volunteering/completeVolunteering  called #####"
        );
        Optional<Volunteering> optionalVolunteering = volunteeringRepository.findById(
            id
        );

        optionalVolunteering.orElseThrow(() -> new Exception("No Entity Found")
        );
        Volunteering volunteering = optionalVolunteering.get();
        volunteering.completeVolunteering(completeVolunteeringCommand);

        volunteeringRepository.save(volunteering);
        return volunteering;
    }
}
//>>> Clean Arch / Inbound Adaptor
