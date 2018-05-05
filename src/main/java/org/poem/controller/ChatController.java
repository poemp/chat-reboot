package org.poem.controller;

import org.poem.core.json.JsonBean;
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
    public org.poem.core.json.JsonBean response(String question){
        return new JsonBean(0,chatService.response(question));
    }
}
