package de.ksbrwsk;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@EnableTask
@SpringBootApplication
public class CloudTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudTaskApplication.class, args);
	}

    @Bean
    public TollProcessor tollProcessor() {
        return new TollProcessor();
    }

	class TollProcessor implements CommandLineRunner {

		@Override
		public void run(String... strings) throws Exception {

			if(strings != null) {
                String stationId = strings[0];
                String licensePlate = strings[1];
                String timestamp = strings[2];

                System.out.println("*** Station ID: " + stationId
                        + ", License plate: " + licensePlate
                        + ", Timestamp: " + timestamp);
            }
		}
	}
}
