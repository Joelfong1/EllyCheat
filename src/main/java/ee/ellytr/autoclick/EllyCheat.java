package ee.ellytr.autoclick;

import ee.ellytr.autoclick.command.CPSCommand;
import ee.ellytr.autoclick.cps.CPSListener;
import ee.ellytr.autoclick.cps.CPSRunnable;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class EllyCheat extends JavaPlugin {

    private static EllyCheat instance;

    @Override
    public void onEnable() {
        instance = this;

        getConfig().options().copyDefaults(true);
        saveConfig();

        new CPSListener();
        getCommand("cps").setExecutor(new CPSCommand());

        Bukkit.getScheduler().runTaskLater(this, new CPSRunnable(), 20);
    }

    @Override
    public void onDisable() {

    }

    public static EllyCheat getInstance() {
        return instance;
    }

}
