package org.poem.controller;

import org.poem.service.ChatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChatController {

    @Autowired
    private ChatServiceImpl chatService;

    /**
     * 回答问题
     * @param question
     * @return
     */
    @RequestMapping("/ask")
    @ResponseBody
    public String response(String question){
        return chatService.response(question);
    }
}
