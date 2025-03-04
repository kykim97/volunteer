package ktvolunteer.infra;

import java.util.List;
import ktvolunteer.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "volunteerhistories",
    path = "volunteerhistories"
)
public interface VolunteerhistoryRepository
    extends PagingAndSortingRepository<Volunteerhistory, Long> {}
