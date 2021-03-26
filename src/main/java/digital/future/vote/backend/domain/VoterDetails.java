package digital.future.vote.backend.domain;

import lombok.Value;

/**
 * This is the only class that maps meaningless voterId to some meaningful data for getting statistics
 * without disclosing the particular user.
 */
@Value
public class VoterDetails {
    String voterId;
    String gender;
    Integer bornYear;
    String pollingStation;
    String locality;
    String education;
    String industry;
    String maritalStatus;
}
