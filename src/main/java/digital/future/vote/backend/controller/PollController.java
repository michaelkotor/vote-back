package digital.future.vote.backend.controller;

import digital.future.vote.backend.domain.Poll;
import digital.future.vote.backend.repo.PollRepo;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

//@Slf4j
//@Secured({"ROLE_ANONYMOUS"}) //TODO
@RestController
@RequestMapping("/poll")
public class PollController {
    @Autowired
    PollRepo pollRepository;

    @GetMapping
    public Iterable<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    @PostMapping(consumes = "application/json")
    public Poll createPoll(@NonNull PollDto dto)  {
        Poll poll = new Poll();
        dto.updateEntity(poll);
        return pollRepository.save(poll);
    }

    @GetMapping("/id/{id}")
    public Poll getPoll(@NonNull Long id) {
        return pollRepository.findById(id).get();
    }

    @PutMapping(path = "/id/{id}",consumes = "application/json" )
    public Poll updatePoll(@NonNull Long id, @NonNull PollDto dto)  {
        Poll poll = pollRepository.findById(id).get();
        dto.updateEntity(poll);
        return pollRepository.save(poll);
    }

    @DeleteMapping(value = "/id/{id}")
    public void deletePoll(@NonNull Long id) {
        pollRepository.deleteById(id);
    }
}