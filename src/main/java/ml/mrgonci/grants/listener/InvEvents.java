package ml.mrgonci.grants.listener;

import ml.mrgonci.grants.commands.GrantCommand;
import ml.mrgonci.grants.utils.interfaces.Grant;
import ml.mrgonci.grants.utils.interfaces.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class InvEvents implements Listener, Grant{

    @EventHandler
    public void onInvClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        String title = StringUtils.toColor(getSettings.getString("Menu.title"));
        if(e.getView().getTitle().equalsIgnoreCase(title)) {
            for (String rank : Objects.requireNonNull(getSettings.getConfigurationSection("Ranks")).getKeys(false)) {
                if (e.getSlot() == getSettings.getInt("Ranks." + rank + ".slot")) {
                    e.setCancelled(true);
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Objects.requireNonNull(getSettings.getString("Ranks." + rank + ".command")
                            .replaceAll("%player%", GrantCommand.players.get(p.getName()))));
                }
            }
        }
    }
}
