package hu.imosonyi.bvtech.analyzer.randomtext;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import hu.imosonyi.bvtech.analyzer.dto.TextRequest;

/**
 * Utility class that stores the RandomText API URL and generates all the URL
 * paths that is needed from the /betvictor/text endpoint's request.
 *
 * @author István Mosonyi
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ApiPathGenerator {

    /**
     * RandomText API base URL.
     */
    public static final String BASE_URL = "http://www.randomtext.me/api/giberish/";

    private static final String PATH_FORMAT = "p-%d/%d-%d";

    /**
     * Generates the paths to be requested from the RandomText API.
     *
     * @param textRequest Request that contains how many paragraphs needs to be
     *                    generated.
     * @return List of URL paths.
     */
    public List<String> getPaths (TextRequest textRequest) {
        List<String> paths = new ArrayList<>();
        for (int p = textRequest.getStart(); p <= textRequest.getEnd(); p++) {
            paths.add(String.format(PATH_FORMAT, p, textRequest.getMin(), textRequest.getMax()));
        }
        return paths;
    }

}
