package xyz.sadcenter.apples;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.jnativehook.GlobalScreen;
import xyz.sadcenter.apples.configuration.Configuration;
import xyz.sadcenter.apples.listener.KeyListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * @author sadcenter on 25.08.2020
 * @project Jablka
 */

public class Main {

    @Getter
    private static final Configuration configuration = new Configuration(new File("config", "config.json"));
    @Getter
    @Setter
    public static boolean enabled;

    @SneakyThrows
    public static void main(String... args) {

        GlobalScreen.registerNativeHook();
        GlobalScreen.addNativeKeyListener(new KeyListener(new Robot()));
        LogManager.getLogManager().reset();
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);

        final JFrame jframe = new JFrame();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setTitle("SENTRIA.PL - sadcenter jablka");
        jframe.setSize(400, 400);
        jframe.setBackground(Color.CYAN);
        jframe.setVisible(true);
        String path = "https://i.imgur.com/v81F0BF.png";
        URL url;
        try {
            url = new URL(path);
            BufferedImage image;
            image = ImageIO.read(url);
            jframe.setIconImage(image);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
