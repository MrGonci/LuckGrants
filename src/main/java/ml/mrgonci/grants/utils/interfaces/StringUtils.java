package ml.mrgonci.grants.utils.interfaces;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public interface StringUtils {
    static String toColor(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    static String stipColor(String msg){
        return ChatColor.stripColor(msg);
    }
}
