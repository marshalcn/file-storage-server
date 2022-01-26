package com.github.marshalcn.auth.handler;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

@Component
public class UserAuthSuccessHandler implements AuthenticationSuccessHandler {
    @Resource
    private ClientDetailsService clientDetailsService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //1.从请求参数中拿到ClientId
//        String header = request.getHeader("Authorization");
//        if (header == null && !header.toLowerCase().startsWith("basic ")) {
//            throw new UnapprovedClientAuthenticationException("请求头中无client信息！");
//        }
//        String[] tokens = this.extractAndDecodeHeader(header, request);
//        assert tokens.length == 2;
//        String clientId = tokens[0];
//        ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);
//        String clientSecret = tokens[1];
//        TokenRequest tokenRequest = new TokenRequest(request.getParameterMap(), clientId, );
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(JSONObject.toJSONString(authentication));
    }
    private String[] extractAndDecodeHeader(String header, HttpServletRequest request) throws IOException {
        byte[] base64Token = header.substring(6).getBytes("UTF-8");

        byte[] decoded;
        try {
            decoded = Base64.getDecoder().decode(base64Token);
        } catch (IllegalArgumentException var7) {
            throw new BadCredentialsException("Failed to decode basic authentication token");
        }

        String token = new String(decoded, "UTF-8");
        int delim = token.indexOf(":");
        if (delim == -1) {
            throw new BadCredentialsException("Invalid basic authentication token");
        } else {
            return new String[]{token.substring(0, delim), token.substring(delim + 1)};
        }
    }
}
