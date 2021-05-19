package com.example.demo.controller;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.AddressResponse;

@RestController
public class ApiController {

  @GetMapping("/")
  public String index() {
    return "API server is running.";
  }

  @RequiresAuthentication
  @RequiresRoles(value = { "sap.address.all" }, logical = Logical.OR)
  @RequestMapping(value = "user/test_api", //
      method = RequestMethod.GET, //
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseBody
  public List<AddressResponse> userAPITest() throws MalformedURLException {

    List<AddressResponse> lstResponse = new ArrayList<>();
    AddressResponse addressResponse =
        new AddressResponse("Norway", "Dietrichstad", "123", "Marta Creek", "110 Vincent Center");
    for (int i = 0; i < 5; i++) {
      lstResponse.add(addressResponse);
    }

    return lstResponse;
  }

  @RequiresAuthentication
  @RequiresRoles("admin.sap.address.all")
  @RequestMapping(value = "admin/test_api", //
      method = RequestMethod.GET, //
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ResponseBody
  public List<AddressResponse> adminAPITest() throws MalformedURLException {

    List<AddressResponse> lstResponse = new ArrayList<>();
    AddressResponse addressResponse =
        new AddressResponse("Norway", "Dietrichstad", "123", "Marta Creek", "110 Vincent Center");
    for (int i = 0; i < 5; i++) {
      lstResponse.add(addressResponse);
    }

    return lstResponse;
  }
}
