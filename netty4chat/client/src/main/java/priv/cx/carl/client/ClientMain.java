package priv.cx.carl.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import priv.cx.carl.client.swing.Swingclient;

/**
 * 启动函数
 *
 * @author chenxuan
 */
public class ClientMain {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Swingclient swing = applicationContext.getBean(Swingclient.class);
        swing.setVisible(true);
    }

}
