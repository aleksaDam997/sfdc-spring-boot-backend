package com.spring.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.dto.DataToPredictDto;
import com.spring.dto.Prediction;
import com.spring.dto.TrainingDto;
import com.spring.entity.Category;
import com.spring.entity.Data;
import com.spring.entity.User;
import com.spring.service.AppServiceImplementation;
import com.spring.service.NNServiceImplementation;
import com.spring.service.user.UserServiceImplementation;

import artificial_neural_network.Network;

@RestController
//@CrossOrigin
//"api"
@RequestMapping("api")
public class AppController {

	@Autowired
	private AppServiceImplementation appService;
	
	@Autowired
	private UserServiceImplementation userService;
	
	@Autowired
	private NNServiceImplementation nnService;
	
	@GetMapping("/add/data/{id}")
	public ResponseEntity<Data> addData(@RequestParam(value = "value1", defaultValue = "0") double value1, @RequestParam(value = "value2", defaultValue = "0") double value2, 
			@RequestParam(value = "value3", defaultValue = "0") double value3, @RequestParam(value = "value4", defaultValue = "0") double value4, @RequestParam(value = "value5", defaultValue = "0") double value5, 
			@RequestParam(value = "value6", defaultValue = "0") double value6, @RequestParam(value = "value7", defaultValue = "0") double value7, @PathVariable("id") int categoryId) throws Exception {
		return ResponseEntity.ok().body(this.appService.addData(value1, value2, value3, value4, value5, value6, value7, categoryId));
	}
	
	@PostMapping()
	public String helloWorld(@RequestBody String s) {
		return s;
	}

	@GetMapping("/category/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
		return ResponseEntity.ok().body(this.appService.getCategoryById(id));
	}
	
	@GetMapping("/category")
	public ResponseEntity<List<Category>> getAllCategories() {
		return ResponseEntity.ok().body(this.appService.getAllCategories());
	}
	
	@PostMapping("/category")
	public ResponseEntity<Category> saveCategory(@RequestBody Category cat) {
		return ResponseEntity.ok().body(this.appService.addCategory(cat));
	}
	
	@PutMapping("/category/{id}")
	public ResponseEntity<Category> editCategory(@PathVariable int id, @RequestBody Category cat) {
		return ResponseEntity.ok().body(this.appService.editCategory(cat, id));
	}
	
	@PostMapping("/neural/network/train")
	public ResponseEntity<Prediction> trainNetwork(@RequestBody TrainingDto trainingDto) {
		return ResponseEntity.ok().body(this.nnService.trainNetwork(trainingDto));
	}
	
	@PostMapping("/neural/network/predict")
	public ResponseEntity<Prediction> predict(@RequestBody DataToPredictDto data) {
		return ResponseEntity.ok().body(this.nnService.predict(data));
	}
	
	
	
	
	
	@GetMapping("/token/refresh")
	public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws StreamWriteException, DatabindException, IOException {
		String authorizationHeader = request.getHeader("Authorization");
		
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			try {
				String refreshToken = authorizationHeader.substring("Bearer ".length());
				Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
				JWTVerifier verifier = JWT.require(algorithm).build();
				DecodedJWT decodedJWT = verifier.verify(refreshToken);
				
//				if(decodedJWT.getExpiresAt().getSeconds() < new Date(System.currentTimeMillis()).getSeconds()) {
//					throw new Exception("Refresh token istekao");
//				}
				
				String username = decodedJWT.getSubject();
				User user = this.userService.getUserByUsername(username);

				String accessToken = JWT.create()
						.withSubject(user.getUsername())
						.withClaim("id", request.getRemoteAddr())
						.withExpiresAt(new Date(System.currentTimeMillis() + 4 * 1000 * 60))
						.withIssuer(request.getRequestURI().toString())
						.withClaim("role", user.getRole())
						.sign(algorithm);
				
				String refreshTokenToResponse = JWT.create()
						.withSubject(user.getUsername())
						.withClaim("id", request.getRemoteAddr())
						.withExpiresAt(new Date(System.currentTimeMillis() + 45 * 1000 * 60))
						.withIssuer(request.getRequestURI().toString())
						.sign(algorithm);
				
				Map<String, String> tokens = new HashMap<>();
				tokens.put("access_token", accessToken);
				tokens.put("refresh_token", refreshTokenToResponse);
				
				response.setContentType("application/json");
				
				new ObjectMapper().writeValue(response.getOutputStream(), tokens);
				
			}catch (Exception e) {
//				Logger.error("Error logging in {}", e.getMessage());
				response.setHeader("error", e.getMessage());
				response.setStatus(403);
//				response.sendError(FORBIDDEN.value()); FORBIDDEN.value() = 403
				Map<String, String> error = new HashMap<>();
				error.put("error_message", e.getMessage());
				response.setContentType("application/json");
				new ObjectMapper().writeValue(response.getOutputStream(), error);

			}
		}else {
			throw new RuntimeException("Refresh token is missing..");
		}
	}
}
