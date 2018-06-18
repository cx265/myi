package priv.cx.carl.server.module.player.service;

import priv.cx.carl.common.core.session.Session;
import priv.cx.carl.common.module.player.response.PlayerResponse;

/**
 * 玩家服务
 *
 * @author chenxuan
 */
public interface PlayerService {


    /**
     * 登录注册用户
     *
     * @param playerName
     * @param passward
     * @return
     */
    public PlayerResponse registerAndLogin(Session session, String playerName, String passward);


    /**
     * 登录
     *
     * @param playerName
     * @param passward
     * @return
     */
    public PlayerResponse login(Session session, String playerName, String passward);

}
