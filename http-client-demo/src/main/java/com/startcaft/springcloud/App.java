package com.startcaft.springcloud;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class App {
    public static void main( String[] args ) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        for(int i=0;i<5;i++){
            HttpGet httpGet = new HttpGet("http://localhost:9000/router");
            HttpResponse response = httpClient.execute(httpGet);
            System.out.println(EntityUtils.toString(response.getEntity()));
        }
    }
}
