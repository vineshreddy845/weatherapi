package com.example.weatherapi.controller;

import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/tom")
public class weather {


        private static final String API_KEY = "17e797212503cc0a479750841bd7f36b";
        private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";
        private static final String API_URLL="https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";
    //http://localhost:8080/tom/weather?cityname=Hyderabad
   @GetMapping("/weather")
    public String getweather(@RequestParam(value="cityname") String cityname)
    {
      // call api using another api or URL
                try {
                    // Build the API URL
                    String urlString = String.format(API_URLL, cityname, API_KEY);
                    URL url = new URL(urlString);

                    // Open the connection and make the request
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setDoOutput(true);
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);

                    // Read the response
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();

                    return response.toString();
                } catch (Exception e) {
                    return "Error: " + e.getMessage();
                }
            }
            /*The StringBuilder class in Java is a mutable sequence of characters. It is used to build a string by appending characters or other strings to it. One of the main advantages of using StringBuilder is that it can be more efficient than using the + operator or the String.concat() method to concatenate strings,
            especially when dealing with a large number of concatenations.

When you get a response from an API, the response may contain a large amount of data.
 If you use the + operator or the String.concat() method to concatenate this data,
 it can cause multiple instances of String objects to be created,
 each with its own memory allocation, which can lead to high memory consumption and slow performance.

On the other

important.string class is immutable.


*/
        }



