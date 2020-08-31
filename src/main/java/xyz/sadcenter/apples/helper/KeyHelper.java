package xyz.sadcenter.apples.helper;

/**
 * @author sadcenter on 31.08.2020
 * @project Jablka
 */

public final class KeyHelper {

    public static int getLocationFromSlot(int slot) {
        int deafult = 891;
        if (slot <= 3)
            return deafult;
        return deafult + (40 * (slot / 3));
    }

}
