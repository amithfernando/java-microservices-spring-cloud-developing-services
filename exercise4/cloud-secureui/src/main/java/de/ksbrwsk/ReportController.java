package de.ksbrwsk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@EnableOAuth2Sso
public class ReportController {

    @Autowired
    private OAuth2ClientContext oAuth2ClientContext;

    @Autowired
    private OAuth2RestTemplate oAuth2RestTemplate;


    @GetMapping("/")
    public String loadHome() {
        return "home";
    }

    @GetMapping("/reports")
    public String loadReports(Model model) {
        //OAuth2AccessToken token = this.oAuth2ClientContext.getAccessToken();
        //System.out.println("Token: " + token.getValue());
        ResponseEntity<ArrayList<TollUsage>> tolls =
                this.oAuth2RestTemplate.exchange("http://localhost:9001/services/tolldata",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<ArrayList<TollUsage>>(){});
        model.addAttribute("tolls", tolls.getBody());
        return "reports";
    }

    public static class TollUsage {
        String id;
        String stationId;
        String licensePlate;
        String timestamp;

        public TollUsage() {}

        public TollUsage(String id, String stationId, String licensePlate, String timestamp) {
            this.id = id;
            this.stationId = stationId;
            this.licensePlate = licensePlate;
            this.timestamp = timestamp;
        }

    }
}
