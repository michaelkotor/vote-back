package digital.future.vote.backend.web;

import digital.future.vote.backend.controller.ParticipantListController;
import digital.future.vote.backend.domain.ParticipantList;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
public class ParticipantListControllerTest {
    @Inject
    private ParticipantListController participantListController;

    @Inject
    @Client("/")
    private RxHttpClient client;

    @Test
    public void test() {

        String first = "1@gmail.com";
        String second = "2@gmail.com";
        String title = "name";

        String request = "{\n" +
                "    \"title\": \"name\",\n" +
                "    \"participants\":\"1@gmail.com,2@gmail.com\"\n" +
                "}";

        final ParticipantList result = client.toBlocking().retrieve(HttpRequest.POST("/participants", request), ParticipantList.class);
        Assertions.assertEquals(title, result.getTitle());
        Assertions.assertEquals(2, result.getParticipants().size());
        Assertions.assertEquals(first, result.getParticipants().get(0));
        Assertions.assertEquals(second, result.getParticipants().get(1));

        int a = 0;

    }
}
