package digital.future.vote.backend.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import digital.future.vote.backend.domain.Vote;
import digital.future.vote.backend.domain.VoteId;
import digital.future.vote.backend.repo.VoteRepo;
import digital.future.vote.backend.util.UID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nullable;

@RestController
@RequestMapping("/vote")
//@Secured({"ROLE_ANONYMOUS"}) //TODO
public class VoteController {
    @Autowired
    VoteRepo voteRepo;

    @PostMapping
    public String registerVote(VoteDto dto, @JsonProperty("updateVote") @Nullable String updateVote)
            throws UID.FormatException {
        Vote vote = new Vote();
        dto.updateEntity(vote);
        vote.setVoterId("TODO!!!");//TODO
        if (updateVote != null && !updateVote.isEmpty()) {
            //TODO: check that user attempts to update their own vote
            //TODO: check that the vote to be updated was not yet updated
           // vote.setUpdatedVoteUid(new VoteId(updateVote)); stas : запилить это в сервис
        } else {
            //TODO: check that the user has not yet voted
        }
        return voteRepo.save(vote).getVoteUid().toString(); //Stas:returns string as uid of vote
    }

    @GetMapping("uid/{uid}")
    public Vote getVote(@NotNull VoteId uid) {
        //TODO: ensure this is current user's vote
        return voteRepo.findById(uid).get();
    }
}
