package com.example.demo.controller;

import java.net.MalformedURLException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.UserInfoTest;

@RestController
public class ApiController {

  @GetMapping("/")
  public String index() {
    return "API server is running.";
  }

  @RequiresAuthentication
  @RequiresRoles("sap.address.all")
  @RequestMapping(value = "user/test_api", //
      method = RequestMethod.GET, //
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseBody
  public UserInfoTest userAPITest() throws MalformedURLException {

    UserInfoTest userInfoTest = new UserInfoTest();
    userInfoTest.setName("Dat Tran");

    return userInfoTest;
  }

  @RequiresAuthentication
  @RequiresRoles("admin.sap.address.all")
  @RequestMapping(value = "admin/test_api", //
      method = RequestMethod.GET, //
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseBody
  public UserInfoTest adminAPITest() throws MalformedURLException {

    UserInfoTest userInfoTest = new UserInfoTest();
    userInfoTest.setName("Dat Tran");
    return userInfoTest;
  }
}
