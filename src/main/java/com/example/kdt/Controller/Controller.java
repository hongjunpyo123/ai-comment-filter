package com.example.kdt.Controller;

import com.example.kdt.Dto.ChatDto;
import com.example.kdt.Service.Service;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    private Service service;

    @PostMapping("/chat/input")
    public ResponseEntity<?> chatInput(@RequestBody ChatDto chatDto){
        return service.sendChatBot(chatDto.getMessage());
    }
}
