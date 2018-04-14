package org.poem.service;

import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.AliceBotMother;
import org.poem.api.ChatService;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class ChatServiceImpl implements ChatService{


    /**
     * 询问
     * @param question 询问
     * @return
     */
    public String response(String question){
        AliceBot bot  = AliceBotMother.newInstance();
        return bot.respond(question);
    }

}
