package xyz.sadcenter.apples.apple;

import lombok.SneakyThrows;
import xyz.sadcenter.apples.Main;
import xyz.sadcenter.apples.helper.KeyHelper;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

/**
 * @author sadcenter on 25.08.2020
 * @project Jablka
 */

public final class AppleProgram extends Thread {

    private final Robot robot;
    private final boolean anvil;
    private final int seconds;
    private long repair;
    private int slot;

    public AppleProgram(Robot robot, int seconds, boolean anvil) {
        super();
        setDaemon(true);
        this.robot = robot;
        this.repair = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(seconds);
        this.anvil = anvil;
        this.seconds = seconds;
        this.slot = 3;
    }

    void clickKey(int keycode) throws InterruptedException {
        robot.keyPress(keycode);
        robot.keyRelease(keycode);
        sleep(35L);
    }

    void clickMouse(int mousecode) throws InterruptedException {
        robot.mousePress(mousecode);
        robot.mouseRelease(mousecode);
        sleep(25L);
    }

    void clickInAnvil(int mousecode) throws InterruptedException {
        robot.mousePress(mousecode);
        robot.mouseRelease(mousecode);
        sleep(200L);
    }

    @SneakyThrows
    void repair() {
        if (this.anvil) {
            Point point = MouseInfo.getPointerInfo().getLocation();
            sleep(100L);
            robot.mouseMove((int) point.getX() + 5000, (int) point.getY());
            sleep(100L);
            robot.mouseMove((int) point.getX() + 5000, (int) point.getY());
            sleep(50L);
            clickInAnvil(4);
            robot.mouseMove(808, 655);
            clickInAnvil(16);
            robot.mouseMove(858, 477);
            clickInAnvil(16);
            robot.mouseMove(KeyHelper.getLocationFromSlot(slot), 664);
            clickInAnvil(16);
            robot.mouseMove(948, 473);
            clickInAnvil(16);
            robot.mouseMove(1060, 472);
            clickInAnvil(16);
            robot.mouseMove(799, 674);
            clickInAnvil(16);
            sleep(300L);
            clickKey(KeyEvent.VK_E);
            sleep(100L);
            robot.mouseMove((int) point.getX() - 5000, (int) point.getY());
            sleep(100L);
            robot.mouseMove((int) point.getX() - 5000, (int) point.getY());
            slot++;
        } else {
            clickKey(KeyEvent.VK_T);
            clickKey(KeyEvent.VK_SLASH);
            clickKey(KeyEvent.VK_R);
            clickKey(KeyEvent.VK_E);
            clickKey(KeyEvent.VK_P);
            clickKey(KeyEvent.VK_A);
            clickKey(KeyEvent.VK_I);
            clickKey(KeyEvent.VK_R);
            clickKey(KeyEvent.VK_ENTER);
        }
    }

    @SneakyThrows
    void advertisement() {
        sleep(100L);
        clickKey(KeyEvent.VK_T);

        clickKey(KeyEvent.VK_J);
        clickKey(KeyEvent.VK_A);
        clickKey(KeyEvent.VK_B);
        clickKey(KeyEvent.VK_L);
        clickKey(KeyEvent.VK_K);
        clickKey(KeyEvent.VK_A);

        clickKey(KeyEvent.VK_SPACE);

        clickKey(KeyEvent.VK_B);
        clickKey(KeyEvent.VK_Y);

        clickKey(KeyEvent.VK_SPACE);

        clickKey(KeyEvent.VK_S);
        clickKey(KeyEvent.VK_A);
        clickKey(KeyEvent.VK_D);
        clickKey(KeyEvent.VK_C);
        clickKey(KeyEvent.VK_E);
        clickKey(KeyEvent.VK_N);
        clickKey(KeyEvent.VK_T);
        clickKey(KeyEvent.VK_E);
        clickKey(KeyEvent.VK_R);
        clickKey(KeyEvent.VK_ENTER);
        Main.setEnabled(true);
    }

    @Override
    @SneakyThrows
    public void run() {
        if (!Main.isEnabled())
            this.stop();


        clickMouse(16);
        sleep(50L);
        clickMouse(16);
        sleep(50L);

        clickKey(KeyEvent.VK_2);

        clickMouse(4);
        sleep(50L);
        clickMouse(4);
        sleep(50L);

        clickKey(KeyEvent.VK_1);
        sleep(50L);

        if (repair < System.currentTimeMillis()) {
            repair = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(seconds);
            repair();
            sleep(250L);
            advertisement();
        }
        run();
    }
}
