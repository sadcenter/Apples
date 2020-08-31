package xyz.sadcenter.apples.listener;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import xyz.sadcenter.apples.Main;
import xyz.sadcenter.apples.apple.AppleProgram;

import java.awt.*;

/**
 * @author sadcenter on 25.08.2020
 * @project Jablka
 */

@RequiredArgsConstructor
public class KeyListener implements NativeKeyListener {

    private final Robot r;


    @Override @SneakyThrows
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        if(nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_F7) {
            Point c = MouseInfo.getPointerInfo().getLocation();
            System.out.println(c.x + " " +c.y);
        }
        if(NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()).equalsIgnoreCase(Main.getConfiguration().getStorage().getKey())) {
            Main.isEnabled = !Main.isEnabled;
            new AppleProgram(r, Main.getConfiguration().getStorage().getRepairCooldownInSeconds(), Main.getConfiguration().getStorage().isAnvil()).start();
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }
}
