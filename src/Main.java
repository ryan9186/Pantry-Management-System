import java.util.List;

public class Main {
    public static void main(String[] args) {
        InterfacingAPI apiClient = new InterfacingAPI();
        List<Food> foodResults = apiClient.searchFood("Milk");

        if (foodResults.isEmpty()) {
            System.out.println("No results found.");
        } else {
            for (Food food : foodResults) {
                System.out.println(food);
            }
        }
    }
}



