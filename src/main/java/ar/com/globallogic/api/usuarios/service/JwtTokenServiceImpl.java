package ar.com.globallogic.api.usuarios.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import ar.com.globallogic.api.usuarios.entity.Usuario;

@Service
public class JwtTokenServiceImpl implements IJwtTokenService {
	
	 public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	@Override
	public String generateToken(Usuario user) {
		Map<String, Object> infoToken = new HashMap<>();
		
	     infoToken.put("name", user.getName());
	     infoToken.put("email", user.getEmail());
		
	     return doGenerateToken(infoToken, user);
	}
	
	private String doGenerateToken(Map<String, Object> infoToken, Usuario user) {
		
		return Jwts.builder().setClaims(infoToken).setSubject(user.getEmail()).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, "yisusxp90-secret").compact();

    }


}
