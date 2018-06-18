package priv.cx.carl.server.module.chat.handler;

import priv.cx.carl.common.core.annotion.SocketCommand;
import priv.cx.carl.common.core.annotion.SocketModule;
import priv.cx.carl.common.core.model.Result;
import priv.cx.carl.common.module.ModuleId;
import priv.cx.carl.common.module.chat.ChatCmd;
import priv.cx.carl.common.module.chat.request.PrivateChatRequest;
import priv.cx.carl.common.module.chat.request.PublicChatRequest;

/**
 * 聊天
 *
 * @author chenxuan
 */
@SocketModule(module = ModuleId.CHAT)
public interface ChatHandler {


    /**
     * 广播消息
     *
     * @param playerId
     * @param data     {@link PublicChatRequest}
     * @return
     */
    @SocketCommand(cmd = ChatCmd.PUBLIC_CHAT)
    public Result<?> publicChat(long playerId, byte[] data);

    /**
     * 私人消息
     *
     * @param playerId
     * @param data     {@link PrivateChatRequest}
     * @return
     */
    @SocketCommand(cmd = ChatCmd.PRIVATE_CHAT)
    public Result<?> privateChat(long playerId, byte[] data);
}
