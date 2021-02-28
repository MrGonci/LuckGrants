package ml.mrgonci.grants.utils.interfaces;

import ml.mrgonci.grants.Grants;
import ml.mrgonci.grants.utils.files.DataManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.java.JavaPlugin;


public interface Grant {


    Grants plugin = (Grants) JavaPlugin.getProvidingPlugin(Grants.class);


    String version = plugin.getDescription().getVersion();

    Console out = new Console();


    Permission grant_open_menu = new Permission("luckgrants.open", "Open the main menu of the plugin", PermissionDefault.OP);

    FileConfiguration getSettings = DataManager.getSettingsConfig();



    FileConfiguration getMessages = DataManager.getMessagesConfig();


    Integer versionID = Integer.parseInt(StringUtils.stipColor(version)
            .replaceAll("[aA-zZ]", "")
            .replace(".", "")
            .replace(" ", ""));
}
