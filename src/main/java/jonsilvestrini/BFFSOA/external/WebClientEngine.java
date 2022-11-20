package jonsilvestrini.BFFSOA.external;

import java.util.concurrent.Future;

import org.springframework.web.reactive.function.client.WebClient;

public class WebClientEngine {
    private final WebClient client = WebClient.create();

    public Future<String> callUrlAsync(String url) {
        return client.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .toFuture();
    }

    public String callUrlSync(String url) {
        return client.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }


}
