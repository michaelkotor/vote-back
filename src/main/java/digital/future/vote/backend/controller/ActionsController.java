package digital.future.vote.backend.controller;

import com.google.common.collect.Lists;
import digital.future.vote.backend.domain.Poll;
import digital.future.vote.backend.domain.StatusActions;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

@Controller("actions")
@Secured(SecurityRule.IS_ANONYMOUS) //TODO
public class ActionsController {

    private List<StatusActions> statusActionsSet;

    {
        statusActionsSet = new ArrayList<>();
        statusActionsSet.add(new StatusActions(Poll.Status.DRAFT, Lists.newArrayList(StatusActions.Action.DELETE, StatusActions.Action.EDIT)));
        statusActionsSet.add(new StatusActions(Poll.Status.PUBLISHED, Lists.newArrayList(StatusActions.Action.DELETE, StatusActions.Action.EDIT)));
        statusActionsSet.add(new StatusActions(Poll.Status.ACTIVE, Lists.newArrayList(StatusActions.Action.VIEW)));
        statusActionsSet.add(new StatusActions(Poll.Status.ENDED, Lists.newArrayList(StatusActions.Action.VIEW)));
    }

    @Get
    public List<StatusActions.Action> getActionsByStatus(@QueryValue String status) {
        for(StatusActions statusActions : statusActionsSet) {
            if(statusActions.getStatus().name().equals(status)) {
                return statusActions.getActions();
            }
        }
        throw new InvalidParameterException("No such Status: " + status);
    }
}
