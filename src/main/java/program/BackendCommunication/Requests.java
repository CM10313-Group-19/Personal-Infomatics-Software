package program.BackendCommunication;

import okhttp3.*;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Objects;

public class Requests {
    private static final String base_url = "http://188.166.144.209:8000";

    /**
     * Submits a Post Request to the backend server
     *
     * @param sub_dir The subdirectory for the request
     * @param form    Form data to post in the request
     * @return An okHttp `Response` object from the request
     * @throws IOException If the request fails
     */
    public static Response post_request(String sub_dir, Dictionary<String, String> form) throws IOException {
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(base_url + sub_dir)).newBuilder();

        // Create a new form and add the values from the passed in dictionary
        var body = new FormBody.Builder();
        for (Enumeration<String> enm = form.keys(); enm.hasMoreElements(); ) {
            var key = enm.nextElement();
            body.add(key, form.get(key));
        }

        // Create url and request
        String url = urlBuilder.build().toString();
        var request = new Request.Builder().url(url).post(body.build()).build();

        // Execute the request
        Call call = new OkHttpClient().newCall(request);

        // Return the response of the request
        return call.execute();
    }

    /**
     * @param sub_dir    The subdirectory for the request
     * @param parameters Parameters for the request
     * @return An okHttp `Response` object from the request
     * @throws IOException If the request fails
     */
    public static Response get_request(String sub_dir, Dictionary<String, String> parameters) throws IOException {
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(base_url + sub_dir)).newBuilder();

        // Iterate over the parameters and add them as query parameters
        for (Enumeration<String> enm = parameters.keys(); enm.hasMoreElements(); ) {
            var key = enm.nextElement();
            urlBuilder.addQueryParameter(key, parameters.get(key));
        }

        // Create url and request
        String url = urlBuilder.build().toString();
        var request = new Request.Builder().url(url).get().build();

        // Execute the request
        Call call = new OkHttpClient().newCall(request);

        return call.execute();
    }
}
