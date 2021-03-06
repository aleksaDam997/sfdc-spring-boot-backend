package com.spring.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomAuthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if(request.getServletPath().equals("/api/login") || request.getServletPath().equals("/api/token/refresh")) {
			filterChain.doFilter(request, response);
		}else {
			String authorizationHeader = request.getHeader("Authorization");
			
			if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
				try {
					String token = authorizationHeader.substring("Bearer ".length());
					Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
					JWTVerifier verifier = JWT.require(algorithm).build();
					DecodedJWT decodedJWT = verifier.verify(token);
					
					String username = decodedJWT.getSubject();
					String role = decodedJWT.getClaim("role").toString();
					log.info("SRBENDO: " + role);
					
					Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
					
						authorities.add(new SimpleGrantedAuthority(role));
					
					UsernamePasswordAuthenticationToken authentiactionToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
					SecurityContextHolder.getContext().setAuthentication(authentiactionToken);
					
					filterChain.doFilter(request, response);
				}catch (Exception e) {
//					Logger.error("Error logging in {}", e.getMessage());
					response.setHeader("error", e.getMessage());
					response.setStatus(403);
//					response.sendError(FORBIDDEN.value()); FORBIDDEN.value() = 403
					Map<String, String> error = new HashMap<>();
					error.put("error_message", e.getMessage() + " Golema sarmica");
					error.put("status", 403 + "");
					response.setContentType("application/json");
					new ObjectMapper().writeValue(response.getOutputStream(), error);

				}
			}else {
				filterChain.doFilter(request, response);
			}
		}
		
	}

}
