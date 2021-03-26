package digital.future.vote.backend.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import digital.future.vote.backend.util.UID;

public class VoteId extends UID {
    public VoteId() {
        super();
    }

    public VoteId(String fromString) throws FormatException {
        super(fromString);
    }

    @Override
    protected String getPrefix() {
        return "V";
    }

    @Override
    protected int getSizeBytes() {
        return 20;
    }

    @JsonValue
    @Override
    public String toString() {
        return super.toString();
    }
}
