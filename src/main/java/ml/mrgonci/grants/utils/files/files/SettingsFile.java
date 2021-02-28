package ml.mrgonci.grants.utils.files.files;

import ml.mrgonci.grants.utils.files.Config;
import ml.mrgonci.grants.utils.interfaces.Grant;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;

public class SettingsFile extends Config implements Grant {
    public SettingsFile() {
        super("settings");
    }

    @Override
    public void loadConfig() {
        File file = getFile();
        if(!file.exists()) {
            file.getParentFile().mkdirs();
            plugin.saveResource("Settings.yml", false);
        }
        FileConfiguration conf = getConfig();
        try{
            conf.load(file);
        }catch(IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        conf.options().copyDefaults(true);
    }
}
