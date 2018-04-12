package org.poem.controller;

import org.poem.service.ChatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private ChatServiceImpl chatService;

    /**
     * 回答问题
     * @param question
     * @return
     */
    public String response(String question){
        return chatService.response(question);
    }
}
