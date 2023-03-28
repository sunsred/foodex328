package untitled.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "getaddressApis",
    path = "getaddressApis"
)
public interface GetaddressApiRepository
    extends PagingAndSortingRepository<GetaddressApi, Long> {}
