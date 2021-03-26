package digital.future.vote.backend.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Vote {
    // Generated vote unique id that identifies this vote action
    @Id
    @NonNull String voteUid = new VoteId().toString();
    // references the poll
    @NonNull Long pollId;
    // user that performs this voting action
    @NonNull String voterId;

    @CreationTimestamp
    Timestamp creation;

    // The Vote itself
    @OneToMany
    @NonNull List<QuestionAnswer> answers;

    @OneToOne (cascade = CascadeType.ALL)
    VotingFacts facts;

    // previous vote in case the user has changed his mind and wants to update their decision
   // VoteId updatedVoteUid; stas: тогда надо реализовать такую возможность в отдельном сервисе и перевести эту сущность в нужное состояние

}
