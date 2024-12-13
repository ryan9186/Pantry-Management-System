/*
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIcall {
    private static final String BASE_URL = "https://api.nal.usda.gov/fdc/v1/foods/search";
    private static final String API_KEY = "";

    public void testApiCall(String query) {
        try {
            String requestUrl = buildRequestUrl(query);

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(requestUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                System.out.println("API Response:\n" + response.body());
            } else {
                System.out.println("API request failed with response code: " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("Error during API call: " + e.getMessage());
        }
    }


    private String buildRequestUrl(String query) throws Exception {
        String encodedQuery = java.net.URLEncoder.encode(query, "UTF-8");
        return BASE_URL + "?api_key=" + API_KEY + "&query=" + encodedQuery;
    }
}
*/
