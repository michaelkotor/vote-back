package digital.future.vote.backend.web;

import digital.future.vote.backend.controller.ActionsController;
import digital.future.vote.backend.domain.StatusActions;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import java.util.List;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest(transactional = false)
public class ActionControllerTest {
    @Inject
    private ActionsController actionsController;

    @Test
    public void testStates() {
        final String DRAFT = "DRAFT";
        List<StatusActions.Action> actionsByStatus = actionsController.getActionsByStatus(DRAFT);
        Assertions.assertEquals(2, actionsByStatus.size());
        Assertions.assertEquals(actionsByStatus.get(0), StatusActions.Action.DELETE);
        Assertions.assertEquals(actionsByStatus.get(1), StatusActions.Action.EDIT);
    }

    @Test
    public void testStates1() {
        final String PUBLISHED = "PUBLISHED";
        List<StatusActions.Action> actionsByStatus = actionsController.getActionsByStatus(PUBLISHED);
        Assertions.assertEquals(2, actionsByStatus.size());
        Assertions.assertEquals(actionsByStatus.get(0), StatusActions.Action.DELETE);
        Assertions.assertEquals(actionsByStatus.get(1), StatusActions.Action.EDIT);
    }

    @Test
    public void testStates2() {
        final String ACTIVE = "ACTIVE";
        List<StatusActions.Action> actionsByStatus = actionsController.getActionsByStatus(ACTIVE);
        Assertions.assertEquals(1, actionsByStatus.size());
        Assertions.assertEquals(actionsByStatus.get(0), StatusActions.Action.VIEW);
    }

    @Test
    public void testStates3() {
        final String ENDED = "ENDED";
        List<StatusActions.Action> actionsByStatus = actionsController.getActionsByStatus(ENDED);
        Assertions.assertEquals(1, actionsByStatus.size());
        Assertions.assertEquals(actionsByStatus.get(0), StatusActions.Action.VIEW);
    }
}
