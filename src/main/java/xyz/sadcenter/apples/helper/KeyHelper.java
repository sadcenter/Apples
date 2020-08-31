package xyz.sadcenter.apples.helper;

import java.awt.*;

/**
 * @author sadcenter on 31.08.2020
 * @project Jablka
 */

public final class KeyHelper {

    public static int getPointfromSlot(int slot) {
        int ver = 891;
        if(slot == 3)
            return ver;
        return ver+(40*(slot/3));
    }

}
