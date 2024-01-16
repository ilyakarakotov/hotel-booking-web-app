package edu.wgu.d387_sample_code.i18n;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import static java.util.concurrent.Executors.newFixedThreadPool;

@Component
public class WelcomeThread {
    static ExecutorService messageExecutor=newFixedThreadPool(5);
    Properties properties=new Properties();
    public ArrayList<String> getWelcomeMessage() {
        ArrayList<String> messages = new ArrayList<>();
        messageExecutor.execute(()-> {
            try {
                InputStream stream = new ClassPathResource("welcome_en_US.properties").getInputStream();
                properties.load(stream);
                messages.add(properties.getProperty("welcome"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        messageExecutor.execute(()-> {
            try {
                InputStream stream = new ClassPathResource("welcome_fr_CA.properties").getInputStream();
                properties.load(stream);
                messages.add(properties.getProperty("welcome"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return messages;
    }
}
