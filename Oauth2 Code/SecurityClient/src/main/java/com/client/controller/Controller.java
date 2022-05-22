package com.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/security")
public class Controller {
	

	@Autowired
	OAuth2AuthorizedClientService auth2AuthorizedClientService;
	
	@GetMapping("/clientCheck")
	public String clientCheck(@AuthenticationPrincipal OidcUser oidcUser) {

		OidcIdToken idToken = oidcUser.getIdToken();
		System.out.println("Value of Objetc {}"+oidcUser);
		System.out.println(idToken.getTokenValue());
		
		Authentication authetication=SecurityContextHolder.getContext().getAuthentication();
		OAuth2AuthenticationToken auth2AuthenticationToken = (OAuth2AuthenticationToken) authetication;
		OAuth2AuthorizedClient auth2AuthorizedClient=auth2AuthorizedClientService.
		loadAuthorizedClient(auth2AuthenticationToken.getAuthorizedClientRegistrationId(), auth2AuthenticationToken.getName());
		System.out.println(auth2AuthorizedClient.getAccessToken().getTokenValue());
		String token = idToken.getTokenValue();
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer"+" "+token);
		HttpEntity entity = new HttpEntity<>(headers);
		ResponseEntity< String> response= restTemplate.exchange("http://localhost:8082/albem", HttpMethod.GET, entity, String.class);
		System.out.println("Response "+response.getBody());
		return "Working on Client Side";
	}
}
