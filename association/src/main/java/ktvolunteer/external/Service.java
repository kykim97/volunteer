package ktvolunteer.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ktvolunteer.domain.AssociationInfo;

import java.util.Date;

@FeignClient(name = "association", url = "${api.url.association}")
public interface Service {
    @RequestMapping(method = RequestMethod.POST, path = "/associations")
    public void createAssociation(@RequestBody AssociationInfo associationInfo);
}
