package digital.future.vote.backend.repo;

import digital.future.vote.backend.domain.ParticipantList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantListRepo extends CrudRepository<ParticipantList, Long> {

   // @Query("SELECT pl.participants FROM participant_list AS pl WHERE pl.id = :listId")
   // Iterable<String> listParticipants(Long listId);

//    //TODO
//    void addParticipantsBulk(Long listId, String... participantIds);
//
//    //TODO
//    void removeParticipant(Long listId, String... participantId);
}
