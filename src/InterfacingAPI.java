import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class InterfacingAPI {
    //base URL for foodCentral api for search
    private static final String BASE_URL = "https://api.nal.usda.gov/fdc/v1/foods/search";
    // replace with api key
    private static final String API_KEY = "";

    //searches for food based on query
    public List<Food> searchFood(String query) {
        List<Food> foodResults = new ArrayList<>();

        try {
            //build the request URL
            String requestUrl = buildRequestUrl(query);

            //make the API call and get the JSON response as a string
            String jsonResponse = makeApiCall(requestUrl);

            //parse the JSON response and extract food data
            if (jsonResponse != null) {
                foodResults = parseFoodResults(jsonResponse);
            }
        } catch (Exception e) {
            System.out.println("Error during food search: " + e.getMessage());
        }

        return foodResults;
    }

    //builds api request with query and api key
    private String buildRequestUrl(String query) throws Exception {
        String encodedQuery = URLEncoder.encode(query, "UTF-8");
        //append the query and API key to the base URL
        return BASE_URL + "?api_key=" + API_KEY + "&query=" + encodedQuery;
    }

    //makes HTTP request to url and returns response as string
    private String makeApiCall(String requestUrl) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(requestUrl).openConnection();
            connection.setRequestMethod("GET");

            // Check the response code
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) { // HTTP OK
                // Read the response into a String
                InputStream inputStream = connection.getInputStream();
                String response = new String(inputStream.readAllBytes());
                return response; // Return the response as a string
            } else {
                System.out.println("API request failed with response code: " + responseCode);
            }
        } catch (Exception e) {
            System.out.println("Error making API call: " + e.getMessage());
        }

        return null; //if request fails
    }

    //parse JSON response and add top 10 food results
    private List<Food> parseFoodResults(String jsonResponse) {
        List<Food> foodResults = new ArrayList<>();

        try {
            //find "foods" array in the JSON response
            int startIndex = jsonResponse.indexOf("\"foods\":");
            if (startIndex == -1) {
                System.out.println("No 'foods' key found in the response.");
                return foodResults;
            }

            //extract array as a string
            String foodsArray = jsonResponse.substring(startIndex + 8, jsonResponse.lastIndexOf(']') + 1);

            // Split each food object
            String[] foodItems = foodsArray.split("\\},\\{");

            for (int i = 0; i < Math.min(foodItems.length, 10); i++) {
                String foodJson = foodItems[i];

                //extract description, servingSize, servingSizeUnit
                String name = extractValue(foodJson, "description");
                double servingSize = Double.parseDouble(extractValue(foodJson, "servingSize"));
                String servingUnit = extractValue(foodJson, "servingSizeUnit");

                Food food = new Food(name, new ServingInfo(servingSize, servingUnit), null, null);
                foodResults.add(food);
            }
        } catch (Exception e) {
            System.out.println("Error parsing food results: " + e.getMessage());
        }

        return foodResults;
    }

    //extract key
    private String extractValue(String json, String key) {
        int startIndex = json.indexOf("\"" + key + "\":");
        if (startIndex == -1) return "unknown";
        startIndex += key.length() + 3;
        int endIndex = json.indexOf(",", startIndex);
        if (endIndex == -1) endIndex = json.length();
        return json.substring(startIndex, endIndex).replaceAll("[\"{}]", "").trim();
    }
}
