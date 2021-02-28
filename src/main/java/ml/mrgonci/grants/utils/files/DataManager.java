package ml.mrgonci.grants.utils.files;

import ml.mrgonci.grants.utils.files.files.MessagesFile;
import ml.mrgonci.grants.utils.files.files.SettingsFile;
import org.bukkit.configuration.file.FileConfiguration;

public class DataManager {

    private static final SettingsFile settingsFile = new SettingsFile();
    private static final MessagesFile messagesFile = new MessagesFile();

    public static FileConfiguration getSettingsConfig() {
        return settingsFile.getConfig();
    }
    public static void saveSettings() {
        settingsFile.saveConfig();
    }
    public static SettingsFile getSettingsFile() {
        return settingsFile;
    }

    public static FileConfiguration getMessagesConfig(){
        return messagesFile.getConfig();
    }
    public static void saveMessages(){
        messagesFile.saveConfig();
    }
    public static MessagesFile getMessagesFile(){
        return messagesFile;
    }
}
