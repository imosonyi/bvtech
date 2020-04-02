package hu.imosonyi.bvtech.randomtext;

import java.util.ArrayList;
import java.util.List;

import hu.imosonyi.bvtech.dto.TextRequest;

public final class ApiPathGenerator {
    
    public static final String BASE_URL = "http://www.randomtext.me/api/giberish/";
    
    private static final String PATH_FORMAT = "p-%d/%d-%d";
    
    private ApiPathGenerator () {
    }
    
    /**
     * TODO.
     * @param textRequest TODO.
     * @return
     */
    public static List<String> getPaths (TextRequest textRequest) {
        List<String> paths = new ArrayList<>();
        for (int p = textRequest.getStart(); p <= textRequest.getEnd(); p++) {
            paths.add(String.format(PATH_FORMAT, p, textRequest.getMin(), textRequest.getMax()));
        }
        return paths;
    }
    
}
