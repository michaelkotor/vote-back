package digital.future.vote.backend.controller;

import digital.future.vote.backend.domain.ParticipantList;
import digital.future.vote.backend.domain.Poll;
import digital.future.vote.backend.domain.PollQuestion;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
public class PollDto {
    @NonNull String title;
    String description;

    @NonNull
    Timestamp timeStart;

    @NonNull
    Timestamp timeEnd;

    @NonNull List<PollQuestion> questions;

    ParticipantList participantList;

    public void updateEntity(Poll poll) {
        poll.setTitle(title);
        poll.setDescription(description);
        poll.setTimeStart(timeStart);
        poll.setTimeEnd(timeEnd);
        poll.setQuestions(questions);
        poll.setParticipantList(participantList);
    }
}
