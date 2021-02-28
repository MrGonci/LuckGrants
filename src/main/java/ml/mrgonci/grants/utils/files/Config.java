package ml.mrgonci.grants.utils.files;

import ml.mrgonci.grants.utils.interfaces.Grant;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public abstract class Config implements Grant {

    private final File file;
    private FileConfiguration config;

    private final String fileName;

    public Config(String fileName) {
        this.fileName = fileName;
        file = new File(plugin.getDataFolder(), this.fileName + ".yml");
        config = new YamlConfiguration();
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public String getFileName() {
        return fileName;
    }

    public File getFile() {
        return file;
    }

    public void saveConfig() {
        try {
            config.save(file);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(file);
    }

    public abstract void loadConfig();

}
