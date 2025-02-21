package vermillion.productions;

import co.aikar.commands.PaperCommandManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import vermillion.productions.plugin.commands.AnswerCommand;
import vermillion.productions.plugin.commands.PluginCommand;
import vermillion.productions.utils.CommandUtils;
import vermillion.productions.utils.ListenerUtils;
import vermillion.productions.utils.blocks.GhostBlockListeners;
import vermillion.productions.utils.item.InteractionManager;

public class Main extends JavaPlugin {

    private static @Getter Main instance;

    @Override
    public void onEnable() {
        instance = this;
        ListenerUtils.registerListener(new InteractionManager()); // Registra las interacciones.
        ListenerUtils.registerListener(new GhostBlockListeners()); // Registra los eventos de GhostBlock.

        PaperCommandManager commandManager = new PaperCommandManager(this);
        CommandUtils.registerCommands(commandManager, new AnswerCommand(), new PluginCommand());
    }

    @Override
    public void onDisable() {}

}
