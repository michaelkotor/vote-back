package digital.future.vote.backend.domain;

import digital.future.vote.backend.util.UID;
import io.micronaut.data.annotation.DateCreated;
import io.micronaut.data.annotation.DateUpdated;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Transient;
import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.model.DataType;
import java.time.Instant;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@MappedEntity
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
    @TypeDef(type = DataType.TIMESTAMP)
    Instant timeStart;

    @NonNull
    @TypeDef(type = DataType.TIMESTAMP)
    Instant timeEnd;

    @DateCreated
    @TypeDef(type = DataType.TIMESTAMP)
    Instant created;

    @DateUpdated
    @TypeDef(type = DataType.TIMESTAMP)
    Instant updated;

    @TypeDef(type = DataType.JSON)
    List<PollQuestion> questions;

    @TypeDef(type = DataType.JSON)
    ParticipantList participantList;

    UID publicUid;

    @Transient
    public Status getStatus() {
        Instant now = Instant.now();
        if (now.isAfter(timeEnd)) {
            return Status.ENDED;
        }
        if (now.isAfter(timeStart)) {
            return Status.ACTIVE;
        }
        if (publicUid != null) {
            return Status.PUBLISHED;
        }
        return Status.DRAFT;
    }
}
