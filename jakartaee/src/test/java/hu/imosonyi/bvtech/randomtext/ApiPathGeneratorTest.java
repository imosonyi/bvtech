package hu.imosonyi.bvtech.randomtext;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.in;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import hu.imosonyi.bvtech.dto.TextRequest;

public class ApiPathGeneratorTest {

    @Test
    public void testBaseUrlShouldMatch () {
        String baseUrl = "http://www.randomtext.me/api/giberish/";

        assertThat(ApiPathGenerator.BASE_URL, is(equalTo(baseUrl)));
    }

    @Test
    public void testGetPathsShouldReturnCorrectPaths () {
        TextRequest textRequest = new TextRequest();
        textRequest.setStart(2);
        textRequest.setEnd(4);
        textRequest.setMin(1);
        textRequest.setMax(5);

        List<String> result = new ApiPathGenerator().getPaths(textRequest);

        List<String> expected = Arrays.asList("p-2/1-5", "p-3/1-5", "p-4/1-5");
        assertThat(result.size(), is(equalTo(result.size())));
        assertThat(result, everyItem(is(in(expected))));
    }

}
