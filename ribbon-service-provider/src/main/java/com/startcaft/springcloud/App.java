package com.startcaft.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Scanner;

/**
 * @author pikai
 */
@SpringBootApplication
public class App {
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        String port = scanner.nextLine();
        new SpringApplicationBuilder(App.class).properties("server.port=" + port).web(true).run(args);
    }
}
