package command_services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.logging.Logger;

public class HttpService {

    private final Logger LOGGER = Logger.getLogger(HttpService.class.getName());
    private final Scanner SCANNER = new Scanner(System.in);

    public String getRequest() {
        try {
            LOGGER.info("Please enter the GET request url: ");
            URL url = new URL(SCANNER.nextLine());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.addRequestProperty("User-Agent", "JCon");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);

            BufferedReader inStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = inStream.readLine()) != null) {
                response.append(line);
                response.append(System.lineSeparator());
            }

            return response.toString();
        } catch (MalformedURLException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
