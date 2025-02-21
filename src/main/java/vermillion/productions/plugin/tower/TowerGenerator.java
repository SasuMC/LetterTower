package vermillion.productions.plugin.tower;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import vermillion.productions.plugin.enums.Letters;
import vermillion.productions.plugin.enums.TowerDirection;

public record TowerGenerator(Player player, String words) {

    public static TowerDirection direction = TowerDirection.VERTICAL;

    public void generateWord() {
        for (int i = 0; i < words.length(); i++) {
            Location location = player.getLocation();
            char letter = words.charAt(i);
            Material letterBlock = Letters.getBlockByLetter(letter);
            switch (direction) {
                case HORIZONTAL -> {
                    location.add(i, -1, 0).getBlock().setType(letterBlock);
                    if (i == words.length() - 1) player.teleport(location.add(0, 1, 0));
                }
                case VERTICAL -> {
                    location.add(0, words.length() - (i + 1), 0).getBlock().setType(letterBlock);
                    if (i == words.length() - 1) player.teleport(location.add(0, words.length() + 0.2, 0));
                }
            }
        }

    }
}
