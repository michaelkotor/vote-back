package digital.future.vote.backend.domain;

import digital.future.vote.backend.util.UID;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.Id;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Poll {
    public enum Status {DRAFT, PUBLISHED, ACTIVE, ENDED}

    @Id
    @GeneratedValue
    Long id;

    @NonNull
    String title;

    String description;

    @NonNull
    Timestamp timeStart;

    @NonNull
    Timestamp timeEnd;

    @CreationTimestamp
    Timestamp created;

    @UpdateTimestamp
    Timestamp updated;

    @OneToMany
    List<PollQuestion> questions;

    @OneToOne
    ParticipantList participantList;

    @Transient
    public Status getStatus(UID publicUid) {
        Instant now = Instant.now();
        if (now.isAfter(timeEnd.toInstant())) {
            return Status.ENDED;
        }
        if (now.isAfter(timeStart.toInstant())) {
            return Status.ACTIVE;
        }
        if (publicUid != null) {
            return Status.PUBLISHED;
        }
        return Status.DRAFT;
    }
}
