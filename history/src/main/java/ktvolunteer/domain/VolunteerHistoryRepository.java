package ktvolunteer.domain;

import ktvolunteer.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "volunteerHistories",
    path = "volunteerHistories"
)
public interface VolunteerHistoryRepository
    extends PagingAndSortingRepository<VolunteerHistory, Long> {}
