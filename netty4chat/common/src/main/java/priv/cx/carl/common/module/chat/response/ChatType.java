package priv.cx.carl.common.module.chat.response;

/**
 * 聊天类型定义
 *
 * @author chenxuan
 */
public interface ChatType {

    /**
     * 广播消息
     */
    public byte PUBLIC_CHAT = 0;

    /**
     * 私聊消息
     */
    public byte PRIVATE_CHAT = 1;
}