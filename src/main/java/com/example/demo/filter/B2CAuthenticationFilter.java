package com.example.demo.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import com.example.demo.model.B2CAccessToken;
import com.example.demo.model.ErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class B2CAuthenticationFilter implements Filter {

  private SecurityManager securityManager;

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;

    try {
      // Check existed Authorization header
      String accessToken = req.getHeader("Authorization");
      if (accessToken == null || accessToken.isBlank() || accessToken.isEmpty()) {
        // throw exception
        throw new Exception("Authorization header is missing.");
      }

      // Apache Shiro authenticate token
      SecurityUtils.setSecurityManager(securityManager);
      Subject subject = SecurityUtils.getSubject();
      B2CAccessToken token = new B2CAccessToken(accessToken);
      subject.login(token);

      chain.doFilter(request, response);
    } catch (Exception e) {
      // custom error response class used across my project
      ErrorResponse errorResponse =
          new ErrorResponse(e.getMessage(), e.getCause() != null ? e.getCause().toString() : "");

      ((HttpServletResponse) response).setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
      ((HttpServletResponse) response).setHeader("Content-Type", "application/json");
      response.getWriter().write(convertObjectToJson(errorResponse));
    }
  }

  public void setSecurityManager(SecurityManager securityManager) {
    this.securityManager = securityManager;
  }

  public String convertObjectToJson(Object object) throws JsonProcessingException {
    if (object == null) {
      return null;
    }
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(object);
  }
}
