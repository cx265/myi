package priv.cx.carl.server.module.player.handler;

import priv.cx.carl.common.core.annotion.SocketCommand;
import priv.cx.carl.common.core.annotion.SocketModule;
import priv.cx.carl.common.core.model.Result;
import priv.cx.carl.common.core.session.Session;
import priv.cx.carl.common.module.ModuleId;
import priv.cx.carl.common.module.player.PlayerCmd;
import priv.cx.carl.common.module.player.request.LoginRequest;
import priv.cx.carl.common.module.player.request.RegisterRequest;
import priv.cx.carl.common.module.player.response.PlayerResponse;

/**
 * 玩家模块
 * @author chenxuan
 *
 */
@SocketModule(module = ModuleId.PLAYER)
public interface PlayerHandler {
	
	
	/**
	 * 创建并登录帐号
	 * @param session
	 * @param data {@link RegisterRequest}
	 * @return
	 */
	@SocketCommand(cmd = PlayerCmd.REGISTER_AND_LOGIN)
	public Result<PlayerResponse> registerAndLogin(Session session, byte[] data);
	

	/**
	 * 登录帐号
	 * @param session
	 * @param data {@link LoginRequest}
	 * @return
	 */
	@SocketCommand(cmd = PlayerCmd.LOGIN)
	public Result<PlayerResponse> login(Session session, byte[] data);

}
