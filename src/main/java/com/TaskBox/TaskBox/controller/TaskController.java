package com.TaskBox.TaskBox.controller;


import com.TaskBox.TaskBox.entity.TaskEntity;
import com.TaskBox.TaskBox.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class TaskController {

    private static final org.slf4j.Logger logMessage = LoggerFactory.getLogger(TaskController.class);

   final String tag ="USER";

    @Autowired
    private TaskService service;

    @Value("${app.version}")
    private String verison;


 @SecurityRequirement(name = "APIKeyAuth")
 @Operation(tags = tag,description = "API to check the version of application")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "422", description = "Request cannot be proceed",content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "404",description = "Page not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "403",description = "Access Denied", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "401",description = "Unauthorized", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "400",description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "200",description = "Success", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    @Tag(name = "v1",description = "verison v1")
    @GetMapping("/version")
    public String getVersion(){
        logMessage.info("Version API IS working");
        return "Version : "+ verison;
    }


 @SecurityRequirement(name = "APIKeyAuth")
 @Operation(tags = tag,description = "API to get list of all Tasks")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "422", description = "Request cannot be proceed",content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "404",description = "Page not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "403",description = "Access Denied", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "401",description = "Unauthorized", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "400",description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "200",description = "Success", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    @Tag(name = "v1",description = "verison v1")
    @GetMapping("/getall")
    public List<TaskEntity> getAll(){
        logMessage.info("getAll API is Working");
        return service.readAll();
    }


 @SecurityRequirement(name = "APIKeyAuth")
 @Operation(tags = tag,description = "API to save the Tasks")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "422", description = "Request cannot be proceed",content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "404",description = "Page not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "403",description = "Access Denied", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "401",description = "Unauthorized", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "400",description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "200",description = "Success", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    @Tag(name = "v1",description = "verison v1")
    @PostMapping("/save")
    public TaskEntity saveNote( @Valid @RequestBody TaskEntity taskEntity ){
       return service.saveNote(taskEntity);
    }


 @SecurityRequirement(name = "APIKeyAuth")
 @Operation(tags = tag,description = "API to find the Task by using ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "422", description = "Request cannot be proceed",content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "404",description = "Page not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "403",description = "Access Denied", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "401",description = "Unauthorized", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "400",description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "200",description = "Success", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    @Tag(name = "v1",description = "verison v1")
    @GetMapping("/task/{id}")
    public TaskEntity getTask(@PathVariable Long id){
         return service.findById(id);

    }


 @SecurityRequirement(name = "APIKeyAuth")
 @Operation(tags = tag,description = "API to delete the Task")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "422", description = "Request cannot be proceed",content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "404",description = "Page not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "403",description = "Access Denied", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "401",description = "Unauthorized", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "400",description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "200",description = "Success", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    @Tag(name = "v1",description = "verison v1")
    @DeleteMapping("/del/{id}")
    public ResponseEntity<HttpStatus> deleteNote(@PathVariable Long id){
         service.removeNote(id);
        return new  ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }




 @SecurityRequirement(name = "APIKeyAuth")
 @Operation(tags = tag,description = "API to update the Task")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal Server Error",content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "422", description = "Request cannot be proceed",content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "404",description = "Page not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "403",description = "Access Denied", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "401",description = "Unauthorized", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "400",description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse( responseCode = "200",description = "Success", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
    })
    @Tag(name = "v1",description = "verison v1")
    @PutMapping("/update")
    public TaskEntity updateNote(@RequestBody TaskEntity updatedNote){
         return service.saveNote(updatedNote);
    }

}
