package priv.cx.carl.server.module.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import priv.cx.carl.common.core.exception.ErrorCodeException;
import priv.cx.carl.common.core.model.ResultCode;
import priv.cx.carl.common.core.session.SessionManager;
import priv.cx.carl.common.module.ModuleId;
import priv.cx.carl.common.module.chat.ChatCmd;
import priv.cx.carl.common.module.chat.response.ChatResponse;
import priv.cx.carl.common.module.chat.response.ChatType;
import priv.cx.carl.server.module.player.dao.PlayerDao;
import priv.cx.carl.server.module.player.dao.entity.Player;

import java.util.Set;

/**
 * 聊天服务
 *
 * @author chenxuan
 */
@Component
public class ChatServiceImpl implements ChatService {

    @Autowired
    private PlayerDao playerDao;

    @Override
    public void publicChat(long playerId, String content) {

        Player player = playerDao.getPlayerById(playerId);


        //获取所有在线玩家
        Set<Long> onlinePlayers = SessionManager.getOnlinePlayers();

        //创建消息对象
        ChatResponse chatResponse = new ChatResponse();
        chatResponse.setChatType(ChatType.PUBLIC_CHAT);
        chatResponse.setSendPlayerId(player.getPlayerId());
        chatResponse.setSendPlayerName(player.getPlayerName());
        chatResponse.setMessage(content);

        //发送消息
        for (long targetPlayerId : onlinePlayers) {
            SessionManager.sendMessage(targetPlayerId, ModuleId.CHAT, ChatCmd.PUSHCHAT, chatResponse);
        }

    }

    @Override
    public void privateChat(long playerId, long targetPlayerId, String content) {
        //不能和自己私聊
        if (playerId == targetPlayerId) {
            throw new ErrorCodeException(ResultCode.CAN_CHAT_YOUSELF);
        }

        Player player = playerDao.getPlayerById(playerId);

        //判断目标是否存在
        Player targetPlayer = playerDao.getPlayerById(targetPlayerId);
        if (targetPlayer == null) {
            throw new ErrorCodeException(ResultCode.PLAYER_NO_EXIST);
        }

        //判断对方是否在线
        if (!SessionManager.isOnlinePlayer(targetPlayerId)) {
            throw new ErrorCodeException(ResultCode.PLAYER_NO_ONLINE);
        }

        //创建消息对象
        ChatResponse chatResponse = new ChatResponse();
        chatResponse.setChatType(ChatType.PRIVATE_CHAT);
        chatResponse.setSendPlayerId(player.getPlayerId());
        chatResponse.setSendPlayerName(player.getPlayerName());
        chatResponse.setTartgetPlayerName(targetPlayer.getPlayerName());
        chatResponse.setMessage(content);

        //给目标对象发送消息
        SessionManager.sendMessage(targetPlayerId, ModuleId.CHAT, ChatCmd.PUSHCHAT, chatResponse);
        //给自己也回一个(偷懒做法)
        SessionManager.sendMessage(playerId, ModuleId.CHAT, ChatCmd.PUSHCHAT, chatResponse);
    }
}
