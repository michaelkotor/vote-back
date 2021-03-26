package digital.future.vote.backend.controller;

import digital.future.vote.backend.domain.ParticipantList;
import digital.future.vote.backend.repo.ParticipantListRepo;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/participants")
//@Secured({"ROLE_ANONYMOUS"}) //TODO
public class ParticipantListController {
    @Autowired
    ParticipantListRepo participantListRepo;


    public Iterable<ParticipantList> getLists() {
        return participantListRepo.findAll();
    }

    @GetMapping("/id/{id}")
    public ParticipantList getListById(@NonNull Long id) {
        return participantListRepo.findById(id).get();
    }

    @PostMapping
    public ParticipantList saveList(ParticipantList list) {
        return participantListRepo.save(list);
    }

    @PutMapping(path = "/id/{id}", consumes = "application/json")
    public ParticipantList updateList(@NonNull Long id, @NonNull ParticipantList in)  {
        ParticipantList stored = participantListRepo.findById(id).get();
        // validate?
        return participantListRepo.save(in);
    }

    @DeleteMapping(value = "/id/{id}")
    public void deleteList(@NonNull Long id) {
        participantListRepo.deleteById(id);
    }
}
