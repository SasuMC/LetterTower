package vermillion.productions.plugin.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import org.bukkit.entity.Player;
import vermillion.productions.plugin.enums.TowerDirection;
import vermillion.productions.plugin.tower.TowerGenerator;

import java.util.Arrays;

@CommandAlias("respuesta")
public class AnswerCommand extends BaseCommand {

    @Default
    public void generateAnswer(Player sender, String... answer) {
        StringBuilder words = new StringBuilder();
        for (String word : answer) {
            boolean noSpace = Arrays.stream(answer).toList().indexOf(word) == (answer.length - 1) && TowerGenerator.direction == TowerDirection.VERTICAL;
            words.append(word).append(noSpace ? "" : " ");
        }
        new TowerGenerator(sender, words.toString()).generateWord();
    }
}
