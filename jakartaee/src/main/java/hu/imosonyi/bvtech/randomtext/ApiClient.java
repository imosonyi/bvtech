package hu.imosonyi.bvtech.randomtext;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import hu.imosonyi.bvtech.dto.ApiResponse;

/**
 * Creates the asynchronous call to the RandomText API.
 *
 * @author István Mosonyi
 */
public class ApiClient {

    private static WebTarget target = ClientBuilder.newClient().target(ApiPathGenerator.BASE_URL);

    /**
     * Make request to RandomText API with the given path.
     *
     * @param path RandomText API URL path.
     * @return Asynchronous response from the API.
     */
    public CompletableFuture<ApiResponse> request (String path) {
        return CompletableFuture.supplyAsync(getRequest(path));
    }

    private Supplier<ApiResponse> getRequest (String path) {
        return () -> target.path(path).request(MediaType.APPLICATION_JSON).get(ApiResponse.class);
    }

}
