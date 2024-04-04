package com.emailapi.email_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emailapi.email_api.model.EmailRequest;
import com.emailapi.email_api.model.EmailResponce;
import com.emailapi.email_api.servieces.EmailServices;

@RestController
@CrossOrigin
public class EmailController {

    @Autowired
    private EmailServices emailServices;

    @RequestMapping("/welcome")
    public String welcome(){
        return "hello bro";
    }

    //Api to send email
    @RequestMapping(value = "/sendemail", method = RequestMethod.POST)
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
        System.out.println(request);
        boolean result = this.emailServices.sendEmail(request.getSubject(), request.getMessage(), request.getTo()); 
        if (result) {
            return ResponseEntity.ok(new EmailResponce("Email is sent successfully..."));
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponce("Email not found!!"));
        }
        
    }
    
}
