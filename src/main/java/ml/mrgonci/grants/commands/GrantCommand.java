package ml.mrgonci.grants.commands;

import ml.mrgonci.grants.utils.files.DataManager;
import ml.mrgonci.grants.utils.interfaces.Grant;
import ml.mrgonci.grants.utils.interfaces.StringUtils;
import ml.mrgonci.grants.utils.menus.PermMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;


public class GrantCommand implements CommandExecutor, Grant  {

    public static HashMap<String, String> players = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission(Grant.grant_open_menu)){
                if(args.length == 1){
                    if(args[0].startsWith("[") && args[0].endsWith("]")){
                        if(args[0].replaceAll("\\s", "").equalsIgnoreCase("[reload]")){
                            DataManager.getMessagesFile().reloadConfig();
                            DataManager.getSettingsFile().reloadConfig();
                            p.sendMessage(StringUtils.toColor("&6LuckGrants &f>> &aConfig reloaded"));
                        }
                    }else{
                        String playername = args[0];
                        PermMenu menu = new PermMenu();
                        p.openInventory(menu.getInventory());
                        players.put(p.getName(),playername);
                    }
                }else{
                    p.sendMessage(StringUtils.toColor(getMessages.getString("Messages.correct-usage")));
                }
            }else {
                p.sendMessage(StringUtils.toColor(getMessages.getString("Messages.no-permission")));
            }
        }else{
            sender.sendMessage(StringUtils.toColor("&6LuckGrants &f> &cCommand only for players."));
        }
        return false;
    }
}
