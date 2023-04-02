package com.services.UserSkillAssociation.RESTapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class RequestingFromSkillsMS {
    @Value("${skillservice.url}")
    private String url ;
    public boolean existsBySkill(String skill) {
        RestTemplate restTemplate = new RestTemplate();


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create a map to hold the skill value
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("skill", skill);

        // Pass the map directly to the HttpEntity constructor
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);

        // Use exchange instead of postForObject for better error handling
        boolean response = restTemplate.exchange(url, HttpMethod.POST, entity, Boolean.class).getBody();

        return response;
    }

}
