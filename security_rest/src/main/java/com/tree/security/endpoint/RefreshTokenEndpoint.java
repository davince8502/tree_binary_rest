package com.tree.security.endpoint;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.tree.security.auth.exceptions.InvalidJwtToken;
import com.tree.security.auth.extractor.TokenExtractor;
import com.tree.security.auth.jwt.verifier.TokenVerifier;
import com.tree.security.config.JwtSettings;
import com.tree.security.config.WebSecurityConfig;
import com.tree.security.model.UserContext;
import com.tree.security.model.token.JwtTokenFactory;
import com.tree.security.model.token.RawAccessJwtToken;
import com.tree.security.model.token.RefreshToken;


/**
 * RefreshTokenEndpoint
 * 
 * 
 *
 * Aug 17, 2016
 */
public abstract class RefreshTokenEndpoint {
    @Autowired protected JwtTokenFactory tokenFactory;
    @Autowired private JwtSettings jwtSettings;
    @Autowired private TokenVerifier tokenVerifier;
    @Autowired @Qualifier("jwtHeaderTokenExtractor") private TokenExtractor tokenExtractor;
    
    
    public Object refreshToken(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String tokenPayload = tokenExtractor.extract(request.getHeader(WebSecurityConfig.JWT_TOKEN_HEADER_PARAM));
        
        RawAccessJwtToken rawToken = new RawAccessJwtToken(tokenPayload);
        RefreshToken refreshToken = RefreshToken.create(
        								rawToken, 
        								Base64.getEncoder().encodeToString(jwtSettings.getTokenSigningKey().getBytes()))
        							.orElseThrow(() -> new InvalidJwtToken());

        String jti = refreshToken.getJti();
        if (!tokenVerifier.verify(jti)) {
            throw new InvalidJwtToken();
        }

        String subject = refreshToken.getSubject();
        UserContext userContext = getUserWithPermissions(subject);

        return tokenFactory.createAccessJwtToken(userContext);
    }

	protected abstract  UserContext getUserWithPermissions(String subject) throws Throwable;
}
