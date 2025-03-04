package ktvolunteer.domain;

import ktvolunteer.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "volunteerInfos",
    path = "volunteerInfos"
)
public interface VolunteerInfoRepository
    extends PagingAndSortingRepository<VolunteerInfo, Long> {}
