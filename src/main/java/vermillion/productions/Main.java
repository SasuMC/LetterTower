package vermillion.productions;

import co.aikar.commands.PaperCommandManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import vermillion.productions.plugin.commands.AnswerCommand;
import vermillion.productions.plugin.commands.PluginCommand;
import vermillion.productions.utils.CommandUtils;

public class Main extends JavaPlugin {

    private static @Getter Main instance;

    @Override
    public void onEnable() {
        instance = this;

        PaperCommandManager commandManager = new PaperCommandManager(this);
        CommandUtils.registerCommands(commandManager, new AnswerCommand(), new PluginCommand());
    }

    @Override
    public void onDisable() {}

}
