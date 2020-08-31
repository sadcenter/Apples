package xyz.sadcenter.apples.configuration.storage;

/**
 * @author sadcenter on 31.08.2020
 * @project Jablka
 */

public final class ConfigurationStorage {

    private final String key;
    private final int repairCooldownInSeconds;
    private final boolean anvil;

    public ConfigurationStorage() {
        this.key = "F8";
        this.repairCooldownInSeconds = 45;
        this.anvil = false;
    }

    public String getKey() {
        return key;
    }

    public int getRepairCooldownInSeconds() {
        return repairCooldownInSeconds;
    }

    public boolean isAnvil() {
        return anvil;
    }
}
