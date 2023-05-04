import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test03 {
  private static final String API_URL = "URL";

    private static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("error! 引数にseedとnを指定してください");
            System.exit(1);
        }
        String seed = args[0];
        int n = 0;
        try {
            n = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("error! nは整数で指定してください");
            System.exit(1);
        }
        int result = calculateF(n, seed);
        System.out.println(result);
    }

    private static int calculateF(int n, String seed) {
        if (n == 0) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n < 0) {
            System.out.println("error! nは0以上の整数で指定してください");
            System.exit(1);
        }
        if (n % 2 == 0) {
            return calculateF(n - 1, seed) + calculateF(n - 2, seed)
                    + calculateF(n - 3, seed) + calculateF(n - 4, seed);
        } else {
            int result = 0;
            if(cache.containsKey(n)){
                result = cache.get(n);
            }else{
                result = callApi(seed, n);
                cache.put(n, result);
            }
            return result;
        }
    }

    private static int callApi(String seed, int n) {
        try {
          URL url = new URL(API_URL + "?seed=" + seed + "&n=" + n);
          HttpURLConnection connection = (HttpURLConnection) url.openConnection();
          connection.setRequestMethod("GET");
          connection.setConnectTimeout(5000);
          connection.setReadTimeout(5000);

          BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
          StringBuilder response = new StringBuilder();
          String line;
          while ((line = reader.readLine()) != null) {
              response.append(line);
          }
          reader.close();

          return extractResultFromJson(response.toString());
        } catch (IOException e) {
            System.out.println("error! API呼び出し中にエラーが発生しました");
            System.exit(1);
        }
        return -1;
    }

    private static int extractResultFromJson(String stJson) {
      ObjectMapper  objectMapper = new ObjectMapper();
      int result = 0;
      try{
        JsonNode json = objectMapper.readTree(stJson);
        result = json.get("result").intValue();           
      }catch(Exception ex){
        System.out.println("error! "+ex);
      }

      return result;
    }
}
