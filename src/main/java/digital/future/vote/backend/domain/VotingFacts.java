package digital.future.vote.backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Additional info about voting action: circumstances and environment details.
 */
@Data
@Entity
@NoArgsConstructor
public class VotingFacts {
    @Id
    @GeneratedValue
    Long id;
    public enum DeviceType {PHONE, TABLET, PC}
    DeviceType device;
    String os;
    String ip;
    String location;
}
