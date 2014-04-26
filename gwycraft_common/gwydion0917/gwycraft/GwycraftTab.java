package gwydion0917.gwycraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GwycraftTab extends CreativeTabs {
	GwycraftTab(String par2Str) {
		super(par2Str);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Item getTabIconItem() {
		//return Item.getItemFromBlock(Gwycraft.blockGemCompressed);
		return Item.getItemFromBlock(Blocks.cake);
	}
}
