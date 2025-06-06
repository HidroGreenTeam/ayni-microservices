package com.ayni.user_service.Iam.infrastructure.tokens.jwt;

import com.ayni.user_service.Iam.application.internal.outboundservices.tokens.TokenService;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import jakarta.servlet.http.HttpServletRequest;


public interface BearerTokenService extends TokenService {
    String getBearerTokenFrom(HttpServletRequest request);
    String generateToken(Authentication authentication);
}
