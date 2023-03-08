package com.firstApp.exo1;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserApi {
    private String apiKey = "bfaf9df126594dc1ade88f0979177327";
    private String templateString = "https://emailvalidation.abstractapi.com/v1/?api_key=%s&email=%s";

    public InputStream verifyEmail(String email) throws IOException {
        String url = String.format(this.templateString, this.apiKey, email);
        URL URL = new URL(url);
        HttpURLConnection con = (HttpURLConnection) URL.openConnection();
        if (con.getResponseCode() == 200) {
            return con.getInputStream();
        }
        return con.getInputStream();
    }
}
