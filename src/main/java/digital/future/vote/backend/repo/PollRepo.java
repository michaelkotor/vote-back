package digital.future.vote.backend.repo;

import digital.future.vote.backend.domain.Poll;
import digital.future.vote.backend.util.UID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PollRepo extends CrudRepository<Poll, Long> {
   // @Query("SELECT * FROM poll WHERE publicId=:publicId")
   // Optional<Poll> findByPublicId(UID publicId);
}
