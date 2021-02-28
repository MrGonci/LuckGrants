package ml.mrgonci.grants;
;
import ml.mrgonci.grants.utils.PluginLoader;
import org.bukkit.plugin.java.JavaPlugin;

public final class Grants extends JavaPlugin{

    @Override
    public void onEnable() {
        new PluginLoader().enable();
    }

    @Override
    public void onDisable() {
        new PluginLoader().disable();
    }

}