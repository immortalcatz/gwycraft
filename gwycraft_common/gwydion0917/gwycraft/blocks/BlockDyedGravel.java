package gwydion0917.gwycraft.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGravel;
import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class BlockDyedGravel extends BlockGravel {

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;

	public BlockDyedGravel() {
		super();
		setBlockName("dyedGravel");
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(0.5F);
		setStepSound(Block.soundTypeGravel);

	}

	@Override
	public IIcon getIcon(int par1, int par2) {
		return this.iconArray[par2 % this.iconArray.length];
	}

	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item par1, CreativeTabs tab, List subItems) {
		for (int i = 0; i < 16; i++) {
			subItems.add(new ItemStack(this, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.iconArray = new IIcon[16];

		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister.registerIcon("gwycraft:gravel_"
					+ i);
		}
	}

}
