package com.arcomona.WebNovelReader.Input;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class UserInput {

    private Scanner input = new Scanner(System.in);

    public String getUserInput() throws IOException {

        System.out.print("Enter Novel Url: ");
        String url = input.nextLine();

        if(isValidNovelURL(url))
            return url;
        return null;
    }

    private boolean isValidNovelURL(String url) throws IOException {

        HttpURLConnection connection = (HttpURLConnection) (new URL(url)).openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        return responseCode == HttpURLConnection.HTTP_OK;
    }
}
