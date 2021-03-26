package digital.future.vote.backend.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class ParticipantList {
    @Id
    @GeneratedValue
    Long id;

    @NonNull
    String title;

    String description;

    @ElementCollection
    /** Participants - list of voters in the form of opaque string user identifiers. */
    List<String> participants;
}
