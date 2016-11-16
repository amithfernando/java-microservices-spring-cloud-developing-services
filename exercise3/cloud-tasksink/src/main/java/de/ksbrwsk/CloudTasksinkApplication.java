package de.ksbrwsk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

@EnableTaskLauncher
@SpringBootApplication
public class CloudTasksinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudTasksinkApplication.class, args);
	}
}
