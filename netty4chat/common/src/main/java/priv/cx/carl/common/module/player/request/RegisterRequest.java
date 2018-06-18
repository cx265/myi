package priv.cx.carl.common.module.player.request;

import priv.cx.carl.common.core.serial.Serializer;

/**
 * 注册请求
 *
 * @author chenxuan
 */
public class RegisterRequest extends Serializer {

    /**
     * 用户名
     */
    private String playerName;

    /**
     * 密码
     */
    private String passward;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    @Override
    protected void read() {
        this.playerName = readString();
        this.passward = readString();
    }

    @Override
    protected void write() {
        writeString(playerName);
        writeString(passward);
    }
}
