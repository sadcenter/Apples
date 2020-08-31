package xyz.sadcenter.apples.configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.SneakyThrows;
import xyz.sadcenter.apples.configuration.storage.ConfigurationStorage;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author sadcenter on 31.08.2020
 * @project Jablka
 */

public final class Configuration {

    private final File file;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    @Getter
    private ConfigurationStorage storage;

    @SneakyThrows
    public Configuration(File file) {
        this.file = file;
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdir();
        }
        if (!file.exists()) {
            file.createNewFile();
            storage = new ConfigurationStorage();
            saveConfiguration();
        } else
            loadConfiguration();


    }

    @SneakyThrows
    void saveConfiguration() {
        FileWriter fileWriter = new FileWriter(file);
        gson.toJson(storage, fileWriter);
        fileWriter.flush();
        fileWriter.close();
    }

    @SneakyThrows
    void loadConfiguration() {
        FileReader fileReader = new FileReader(file);
        storage = gson.fromJson(fileReader, ConfigurationStorage.class);
        fileReader.close();
    }

}
