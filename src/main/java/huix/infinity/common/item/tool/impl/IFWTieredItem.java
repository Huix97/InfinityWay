package huix.infinity.common.item.tool.impl;

import huix.infinity.common.item.tier.IIFWTier;
import huix.infinity.util.DurationHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class IFWTieredItem extends Item implements IRepairableItem {
    private final IIFWTier tier;
    private final int numComponents;

    public IFWTieredItem(IIFWTier tier, int numComponents, Properties properties) {
        super(properties.durability(DurationHelper.getMultipliedDurability(numComponents, tier.getDurability())));
        this.tier = tier;
        this.numComponents = numComponents;
    }

    public Tier getTier() {
        return this.tier;
    }

    @Override
    public int getEnchantmentValue() {
        return this.tier.getEnchantmentValue();
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return this.tier.getRepairIngredient().test(repair) || super.isValidRepairItem(toRepair, repair);
    }

    @Override
    public int getRepairCost() {
        return this.numComponents * 2;
    }
}
