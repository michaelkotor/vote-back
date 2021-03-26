package digital.future.vote.backend.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class QuestionAnswer {
    @Id
    @NonNull Integer question;
    @NonNull Integer answer;
}
