package huix.infinity.common.item.tier;

import net.minecraft.world.item.Tier;

public interface IIFWTier extends Tier {

    int getDurability();

    EnumQuality getQuality();
}