package ktvolunteer.external;

import java.util.Date;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "association", url = "${api.url.association}")
public interface AssociationInfoService {
    @GetMapping(path = "/associationInfos/search/checkSchedule")
    public List<AssociationInfo> checkSchedule();
}
