package tn.esprit.mssequence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsSequenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsSequenceApplication.class, args);
    }

}
