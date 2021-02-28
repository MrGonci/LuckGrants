package ml.mrgonci.grants.utils;

import ml.mrgonci.grants.commands.GrantCommand;
import ml.mrgonci.grants.listener.InvEvents;
import ml.mrgonci.grants.listener.JoinVersionChecker;
import ml.mrgonci.grants.utils.files.DataManager;
import ml.mrgonci.grants.utils.interfaces.Grant;
import ml.mrgonci.grants.utils.version.GrantVersion;
import ml.mrgonci.grants.utils.version.VersionChecker;
import org.bukkit.Bukkit;

import java.util.List;
import java.util.Objects;

public final class PluginLoader {

    public final void enable(){
        Grant.out.Message("");
        Grant.out.Message("&6LuckGrants &8| &aEnabled ");
        Grant.out.Message("&eVersion: &f" + Grant.version);
        Grant.out.Message("&eAuthor: &fGonci");
        Grant.out.Message("&eSupport discord: &fdiscord.gg/DKBMpY3uSs");
        Grant.out.Message("");
        registerCommands();
        registerConfig();
        registerEvents();
        version();
    }

    public final void disable(){
        Grant.out.Message("");
        Grant.out.Message("&6LuckGrants &8| &cDisabled ");
        Grant.out.Message("&eVersion: &f" + Grant.version);
        Grant.out.Message("&eAuthor: &fGonci");
        Grant.out.Message("");
    }


    private void registerCommands(){
        Objects.requireNonNull(Grant.plugin.getCommand("grant")).setExecutor(new GrantCommand());
    }

    private void registerEvents(){
        Bukkit.getPluginManager().registerEvents(new InvEvents(), Grant.plugin);
        Bukkit.getPluginManager().registerEvents(new JoinVersionChecker(), Grant.plugin);
    }

    private void registerConfig(){
        DataManager.getSettingsFile().loadConfig();
        DataManager.getMessagesFile().loadConfig();
    }

    private void version(){
        if (GrantVersion.isOutdated()){
            Grant.out.Message("&8( &6LuckGrants&8 ) &cNew version available for LuckGrants &f( &3" + GrantVersion.version + " &f)");
            Grant.out.Message("&cDownload it: " + GrantVersion.updateURL);
            Grant.out.Message("");
            GrantVersion.sendChangeLog();
        }else{
            Grant.out.Message("&8( &6LuckGrants&8 ) &aThe plugin is up-to-date");
        }
    }

}
