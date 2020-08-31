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
    private final int seconds = Main.getConfiguration().getStorage().getRepairCooldownInSeconds();
    private final boolean anvil = Main.getConfiguration().getStorage().isAnvil();


    @Override
    @SneakyThrows
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        if (NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()).equalsIgnoreCase(Main.getConfiguration().getStorage().getKey())) {
            Main.setEnabled(Main.isEnabled());
            new AppleProgram(r, seconds, anvil).start();
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
    }
}
