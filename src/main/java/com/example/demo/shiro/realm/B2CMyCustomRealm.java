package com.example.demo.shiro.realm;

import java.util.Map;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.store.JwtClaimsSetVerifier;
import org.springframework.stereotype.Service;
import com.example.demo.AADClaimsVerifier;
import com.example.demo.model.B2CAccessToken;
import com.example.demo.model.UserInfoTest;

@Service
public class B2CMyCustomRealm extends AuthorizingRealm {

  @Autowired
  JwtClaimsSetVerifier claimSetVerifier;

  private AADClaimsVerifier aADClaimsVerifier;

  public B2CMyCustomRealm() {
    super();
  }

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
    for (Object principal : principals.fromRealm(getName())) {
      UserInfoTest userInfo = (UserInfoTest) principal;
      String scope = userInfo.getScp();
      authorizationInfo.addRole(scope);
    }
    return authorizationInfo;
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
      throws AuthenticationException {
    if (!supports(token)) {
      // Token type is not supported by this realm
      return null;
    }

    // Using MSAL Authenticate token to get
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (!authentication.isAuthenticated()) {
      throw new ShiroException("Access token un-authentication");
    }

    aADClaimsVerifier = (AADClaimsVerifier) claimSetVerifier;
    Map<String, Object> claims = aADClaimsVerifier.getClaims();
    UserInfoTest userInfoTest = new UserInfoTest();
    userInfoTest.setName((String) claims.get("name"));
    userInfoTest.setScp((String) claims.get("scp"));

    SimpleAuthenticationInfo authenticationInfo =
        new SimpleAuthenticationInfo(userInfoTest, token.getCredentials(), getName());

    return authenticationInfo;
  }

  @Override
  public boolean supports(AuthenticationToken token) {
    return token instanceof B2CAccessToken;
  }
}
