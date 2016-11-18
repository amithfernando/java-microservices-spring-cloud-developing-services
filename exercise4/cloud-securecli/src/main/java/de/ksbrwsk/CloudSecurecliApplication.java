package de.ksbrwsk;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

import java.util.Arrays;
import java.util.Set;

@SpringBootApplication
public class CloudSecurecliApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CloudSecurecliApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("cron job started");

        ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceDetails.setAccessTokenUri("http://localhost:9000/services/oauth/token");
        resourceDetails.setAuthenticationScheme(AuthenticationScheme.header);
        resourceDetails.setClientId("pluralsight");
        resourceDetails.setClientSecret("pluralsightsecret");
        resourceDetails.setScope(Arrays.asList("toll_read"));
        resourceDetails.setUsername("bgoldberg");
        resourceDetails.setPassword("pass2");

        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails);
        String s = restTemplate.getAccessToken().toString();
        System.out.println("Token: " + s);

        String tolldata = restTemplate.getForObject("http://localhost:9001/services/tolldata", String.class);
        System.out.println(tolldata);
    }
}
