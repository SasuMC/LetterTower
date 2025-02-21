package vermillion.productions.plugin.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Subcommand;
import org.bukkit.entity.Player;
import vermillion.productions.plugin.enums.TowerDirection;
import vermillion.productions.plugin.tower.TowerGenerator;
import vermillion.productions.utils.ChatColorFormatter;

@CommandAlias("lettertower|letter|tower")
public class PluginCommand extends BaseCommand {

    @Subcommand("toggle")
    public void toggleDirection(Player sender) {
        TowerGenerator.direction = TowerGenerator.direction == TowerDirection.HORIZONTAL ? TowerDirection.VERTICAL : TowerDirection.HORIZONTAL;
        sender.sendMessage(ChatColorFormatter.stringToStringWithPrefix("La direccion ha sido cambiada a &f&l" + TowerGenerator.direction.name() + "&r."));
    }

}
