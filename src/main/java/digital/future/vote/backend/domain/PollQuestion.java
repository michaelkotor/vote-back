package digital.future.vote.backend.domain;

import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class PollQuestion {
    @Id
    @GeneratedValue
    Long id;
    @NonNull String question;
    @ElementCollection
    @NonNull List<String> options;
}
