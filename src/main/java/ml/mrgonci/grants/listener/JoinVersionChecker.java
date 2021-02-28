package ml.mrgonci.grants.listener;

import ml.mrgonci.grants.utils.interfaces.StringUtils;
import ml.mrgonci.grants.utils.version.GrantVersion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinVersionChecker implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent e){
        if(e.getPlayer().isOp() || e.getPlayer().hasPermission("*")){
            if(GrantVersion.isOutdated()) {
                e.getPlayer().sendMessage(StringUtils.toColor("&8( &6LuckGrants&8 ) &cNew version available for LuckGrants &f( &3" + GrantVersion.version + " &f)"));
                e.getPlayer().sendMessage(StringUtils.toColor("&cUpdate LuckGrants on: " + GrantVersion.updateURL));
            }
        }
    }
}
