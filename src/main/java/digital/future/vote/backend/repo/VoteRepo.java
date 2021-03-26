package digital.future.vote.backend.repo;

import digital.future.vote.backend.domain.Vote;
import digital.future.vote.backend.util.UID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepo extends CrudRepository<Vote, UID> {

}
