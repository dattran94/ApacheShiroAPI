package com.example.demo.model;

import org.apache.shiro.authc.HostAuthenticationToken;

public class B2CAccessToken implements HostAuthenticationToken {

  
  /**
   * 
   */
  private static final long serialVersionUID = -1346132790478202428L;
  
  private final String token;
  private String host;

  public B2CAccessToken(String token) {
    super();
    this.token = token;
  }

  public B2CAccessToken(String token, String host) {
    super();
    this.token = token;
    this.host = host;
  }

  @Override
  public Object getPrincipal() {
    return token;
  }

  @Override
  public Object getCredentials() {
    return token;
  }

  @Override
  public String getHost() {
    return host;
  }

}
