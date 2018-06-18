package priv.cx.carl.common.module.player;

/**
 * 玩家模块
 *
 * @author chenxuan
 */
public interface PlayerCmd {

    /**
     * 创建并登录帐号
     */
    short REGISTER_AND_LOGIN = 1;

    /**
     * 登录帐号
     */
    short LOGIN = 2;
}
                                                  