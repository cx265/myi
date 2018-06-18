package priv.cx.carl.client.module.player.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import priv.cx.carl.client.swing.ResultCodeTip;
import priv.cx.carl.client.swing.Swingclient;
import priv.cx.carl.common.core.model.ResultCode;
import priv.cx.carl.common.module.player.response.PlayerResponse;

/**
 * 玩家模块
 * @author chenxuan
 *
 */
@Component
public class PlayerHandlerImpl implements PlayerHandler{
	
	@Autowired
	private Swingclient swingclient;
	@Autowired
	private ResultCodeTip resultCodeTip;

	@Override
	public void registerAndLogin(int resultCode, byte[] data) {
		if(resultCode == ResultCode.SUCCESS){
			PlayerResponse playerResponse = new PlayerResponse();
			playerResponse.readFromBytes(data);
			
			swingclient.setPlayerResponse(playerResponse);
			swingclient.getTips().setText("注册登录成功");
		}else{
			swingclient.getTips().setText(resultCodeTip.getTipContent(resultCode));
		}
	}

	@Override
	public void login(int resultCode, byte[] data) {
		if(resultCode == ResultCode.SUCCESS){
			PlayerResponse playerResponse = new PlayerResponse();
			playerResponse.readFromBytes(data);
			
			swingclient.setPlayerResponse(playerResponse);
			swingclient.getTips().setText("登录成功");
		}else{
			swingclient.getTips().setText(resultCodeTip.getTipContent(resultCode));
		}
	}
}
