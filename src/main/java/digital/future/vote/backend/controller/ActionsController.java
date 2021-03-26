package digital.future.vote.backend.controller;

import com.google.common.collect.Lists;
import digital.future.vote.backend.domain.Poll;
import digital.future.vote.backend.domain.StatusActions;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/actions")
//@Secured({"ROLE_ANONYMOUS"}) //TODO
public class ActionsController {

    private List<StatusActions> statusActionsSet;

    {
        statusActionsSet = new ArrayList<>();
        statusActionsSet.add(new StatusActions(Poll.Status.DRAFT, Lists.newArrayList(StatusActions.Action.DELETE, StatusActions.Action.EDIT)));
        statusActionsSet.add(new StatusActions(Poll.Status.PUBLISHED, Lists.newArrayList(StatusActions.Action.DELETE, StatusActions.Action.EDIT)));
        statusActionsSet.add(new StatusActions(Poll.Status.ACTIVE, Lists.newArrayList(StatusActions.Action.VIEW)));
        statusActionsSet.add(new StatusActions(Poll.Status.ENDED, Lists.newArrayList(StatusActions.Action.VIEW)));
    }

    @GetMapping
    public List<StatusActions.Action> getActionsByStatus( String status) {
        for(StatusActions statusActions : statusActionsSet) {
            if(statusActions.getStatus().name().equals(status)) {
                return statusActions.getActions();
            }
        }
        throw new InvalidParameterException("No such Status: " + status);
    }
}
