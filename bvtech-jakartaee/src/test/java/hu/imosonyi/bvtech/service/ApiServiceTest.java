package hu.imosonyi.bvtech.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import hu.imosonyi.bvtech.dto.ApiResponse;
import hu.imosonyi.bvtech.dto.TextRequest;
import hu.imosonyi.bvtech.dto.TextResponse;
import hu.imosonyi.bvtech.randomtext.ApiClient;
import hu.imosonyi.bvtech.randomtext.ApiPathGenerator;
import hu.imosonyi.bvtech.service.impl.ApiServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ApiServiceTest {

    @Mock
    private ApiPathGenerator apiPathGenerator;

    @Mock
    private ApiClient apiClient;

    @InjectMocks
    private ApiService apiService = new ApiServiceImpl();

    @Test
    public void testApiServiceShouldSetTotalTime () {
        when(apiPathGenerator.getPaths(any(TextRequest.class))).thenReturn(Arrays.asList(""));
        when(apiClient.request(any(String.class))).thenReturn(CompletableFuture.supplyAsync(() -> {
            try {
                return Executors.newSingleThreadScheduledExecutor().schedule(() -> {
                    ApiResponse response = new ApiResponse();
                    response.setGeneratedParagraphs("<p>This is a very long paragraph.</p>\r<p>This is not.</p>\r");
                    return response;
                }, 1000, TimeUnit.MILLISECONDS).get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return null;
            }
        }));

        TextResponse result = apiService.analyze(new TextRequest());

        assertThat(result.getTotalTime(), is(greaterThanOrEqualTo(1000L)));
    }

    @Test
    public void testApiServiceShouldCalculateAverageTime () {
        when(apiPathGenerator.getPaths(any(TextRequest.class))).thenReturn(Arrays.asList(""));
        when(apiClient.request(any(String.class))).thenReturn(CompletableFuture.supplyAsync(() -> {
            ApiResponse response = new ApiResponse();
            response.setGeneratedParagraphs("<p>This is a very long paragraph.</p>\r<p>This is not.</p>\r");
            return response;
        }));

        TextResponse result = apiService.analyze(new TextRequest());

        assertThat(result.getAverageTime(), is(not(nullValue())));
    }

    @Test
    public void testApiServiceShouldCalculateAverageParagraphSize () {
        when(apiPathGenerator.getPaths(any(TextRequest.class))).thenReturn(Arrays.asList(""));
        when(apiClient.request(any(String.class))).thenReturn(CompletableFuture.supplyAsync(() -> {
            ApiResponse response = new ApiResponse();
            response.setGeneratedParagraphs("<p>This is a very long paragraph.</p>\r<p>This is not.</p>\r");
            return response;
        }));

        TextResponse result = apiService.analyze(new TextRequest());

        assertThat(result.getAverageSize(), is(equalTo(4.5)));
    }

    @Test
    public void testApiServiceShouldCalculateMostFrequentWord () {
        when(apiPathGenerator.getPaths(any(TextRequest.class))).thenReturn(Arrays.asList(""));
        when(apiClient.request(any(String.class))).thenReturn(CompletableFuture.supplyAsync(() -> {
            ApiResponse response = new ApiResponse();
            response.setGeneratedParagraphs("<p>The word test should be.</p>\r<p>Counted twice in this test.</p>\r");
            return response;
        }));

        TextResponse result = apiService.analyze(new TextRequest());

        assertThat(result.getMostFrequent(), is(equalTo("test")));
    }

}
