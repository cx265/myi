package priv.cx.carl.client.module.player.handler;

import priv.cx.carl.common.core.annotion.SocketCommand;
import priv.cx.carl.common.core.annotion.SocketModule;
import priv.cx.carl.common.module.ModuleId;
import priv.cx.carl.common.module.player.PlayerCmd;

/**
 * 玩家模块
 *
 * @author chenxuan
 */
@SocketModule(module = ModuleId.PLAYER)
public interface PlayerHandler {


    /**
     * 创建并登录帐号
     *
     * @param resultCode
     * @param data       {@link null}
     */
    @SocketCommand(cmd = PlayerCmd.REGISTER_AND_LOGIN)
    public void registerAndLogin(int resultCode, byte[] data);


    /**
     * 创建并登录帐号
     *
     * @param resultCode
     * @param data       {@link null}
     */
    @SocketCommand(cmd = PlayerCmd.LOGIN)
    public void login(int resultCode, byte[] data);

}
