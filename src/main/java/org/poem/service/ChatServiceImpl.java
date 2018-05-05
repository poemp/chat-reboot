package org.poem.service;

import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.AliceBotMother;
import org.poem.api.ChatService;
import org.poem.utils.logger.LoggerUtils;
import org.poem.utils.string.StringUtils;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class ChatServiceImpl implements ChatService {

    /**
     * 默认回答
     */
    private static final String DEFAULT_MESSAGE = "你说的啥捏，我不知道怎么回答( ▼-▼ )";

    /**
     * 询问
     *
     * @param question 询问
     * @return
     */
    public String response(String question) {
        AliceBot bot = AliceBotMother.newInstance();
        String result = bot.respond(question);
        LoggerUtils.info("**************************************************");
        LoggerUtils.info("question:" + question);
        LoggerUtils.info("bot response:" + (StringUtils.isEmpty(result) || "null".equals(result) ? DEFAULT_MESSAGE : result));
        LoggerUtils.info("**************************************************");
        return StringUtils.isEmpty(result) || "null".equals(result) ? DEFAULT_MESSAGE : result;
    }

}
