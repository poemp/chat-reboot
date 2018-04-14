package org.poem.api;

/**
 * 询问服务
 */
public interface ChatService {

    /**
     * 询问
     * @param question
     * @return
     */
    public String response(String question);
}
