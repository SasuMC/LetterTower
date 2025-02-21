package vermillion.productions.plugin.enums;

import lombok.Getter;
import org.bukkit.Material;

public enum Letters {

    A(Material.TERRACOTTA),
    B(Material.WHITE_TERRACOTTA),
    C(Material.LIGHT_GRAY_TERRACOTTA),
    D(Material.GRAY_TERRACOTTA),
    E(Material.BLACK_TERRACOTTA),
    F(Material.BROWN_TERRACOTTA),
    G(Material.RED_TERRACOTTA),
    H(Material.ORANGE_TERRACOTTA),
    I(Material.YELLOW_TERRACOTTA),
    J(Material.LIME_TERRACOTTA),
    K(Material.GREEN_TERRACOTTA),
    L(Material.CYAN_TERRACOTTA),
    M(Material.LIGHT_BLUE_TERRACOTTA),
    N(Material.BLUE_TERRACOTTA),
    O(Material.PURPLE_TERRACOTTA),
    P(Material.MAGENTA_TERRACOTTA),
    Q(Material.PINK_TERRACOTTA),
    R(Material.WAXED_WEATHERED_COPPER),
    S(Material.CHISELED_COPPER),
    T(Material.EXPOSED_COPPER_GRATE),
    U(Material.WEATHERED_COPPER_GRATE),
    V(Material.COPPER_BLOCK),
    W(Material.OXIDIZED_COPPER),
    X(Material.OXIDIZED_CHISELED_COPPER),
    Y(Material.EXPOSED_CHISELED_COPPER),
    Z(Material.EXPOSED_COPPER),

    ;

    public final @Getter Material block;

    Letters(Material block) {
        this.block = block;
    }

    public static Material getBlockByLetter(char letter) {
        String letterString = String.valueOf(letter);
        for (Letters eachLetter : Letters.values()) {
            if (letterString.equalsIgnoreCase("Ñ")) return N.getBlock();
            if (eachLetter.name().equalsIgnoreCase(letterString)) return eachLetter.getBlock();
        }

        return Material.GREEN_GLAZED_TERRACOTTA;
    }
}
