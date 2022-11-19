package jonsilvestrini.BFFSOA.external;

import java.util.concurrent.Future;

import org.springframework.web.reactive.function.client.WebClient;

public class WebClientEngine {
    private static final WebClient client = WebClient.create();

    public Future<String> callUrl(String url) {


        return client.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .toFuture();

    }

    
}
