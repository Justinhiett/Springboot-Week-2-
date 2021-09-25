package com.promineotech.jeep.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import io.swagger.v3.oas.annotations.responses.ApiResponse; 
import io.swagger.v3.oas.annotations.Operation; 
import io.swagger.v3.oas.annotations.info.Info; 
import io.swagger.v3.oas.annotations.OpenAPIDefinition; 
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.Parameter;

@RequestMapping("/jeeps")
public interface JeepSalesController {  
  
  // @formatter:off 
  @Operation(
      summary = "Returns a list of Jeeps", 
      description = "Returns a list of Jeeps given an optional model and/or trim", 
      responses = {
          @ApiResponse(responseCode = "200", description = "Success"), 
          @ApiResponse(responseCode = "400", description = "bad input"), 
          @ApiResponse(responseCode = "404", description = "not found"), 
          @ApiResponse(responseCode = "500", description = "unplanned error")
      }, 
      parameters = { 
          @Parameter(name = "model", allowEmptyValue = false), 
          @Parameter(name = "trim", allowEmptyValue = false)
      
          
      }
      
      
   ) 
   // @formatter:on 
  
  @GetMapping 
  @ResponseStatus(code = HttpStatus.OK)
  List<Jeep> fetchJeeps(@RequestParam JeepModel model, @RequestParam String trim);

}
