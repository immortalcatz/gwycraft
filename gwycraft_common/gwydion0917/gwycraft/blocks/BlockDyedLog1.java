package gwydion0917.gwycraft.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDyedLog1 extends Block {
	/** The type of tree this log came from. */
	public static final String[] woodType = new String[] { "white", "orange",
			"magenta", "light blue" };
	public static final String[] treeTextureTypes = new String[] {
			"gwycraft:logside_0", "gwycraft:logside_1", "gwycraft:logside_2",
			"gwycraft:logside_3" };
	public static final String[] treeTopTextureTypes = new String[] {
			"gwycraft:logtop_0", "gwycraft:logtop_1", "gwycraft:logtop_2",
			"gwycraft:logtop_3" };
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray1;

	public BlockDyedLog1() {
		super(Material.wood);
		//setUnlocalizedName("dyedLog1");
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(2.0F);
		setStepSound(Block.soundTypeWood);

	}

	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType() {
		return 31;
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random par1Random) {
		return 1;
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	//FIXME: Broke @Override
	//public int idDropped(int par1, Random par2Random, int par3) {
	//	return ConfigGwycraft.blockDyedLog1ID;
	//}

	/**
	 * ejects contained items into the world, and notifies neighbours of an
	 * update, as appropriate
	 */
	// FIXME: Broke @Override
/*	public void breakBlock(World par1World, int par2, int par3, int par4,
			int par5, int par6) {
		byte b0 = 4;
		int j1 = b0 + 1;

		if (par1World.checkChunksExist(par2 - j1, par3 - j1, par4 - j1, par2
				+ j1, par3 + j1, par4 + j1)) {
			for (int k1 = -b0; k1 <= b0; ++k1) {
				for (int l1 = -b0; l1 <= b0; ++l1) {
					for (int i2 = -b0; i2 <= b0; ++i2) {
						int j2 = par1World.getBlockId(par2 + k1, par3 + l1,
								par4 + i2);

						if (Block.blocksList[j2] != null) {
							Block.blocksList[j2].beginLeavesDecay(par1World,
									par2 + k1, par3 + l1, par4 + i2);
						}
					}
				}
			}
		}
	}*/

	/**
	 * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z,
	 * side, hitX, hitY, hitZ, block metadata
	 */
	@Override
	public int onBlockPlaced(World par1World, int par2, int par3, int par4,
			int par5, float par6, float par7, float par8, int par9) {
		int j1 = par9 & 3;
		byte b0 = 0;

		switch (par5) {
			case 0:
			case 1:
				b0 = 0;
				break;
			case 2:
			case 3:
				b0 = 8;
				break;
			case 4:
			case 5:
				b0 = 4;
		}

		return j1 | b0;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	@Override
	public IIcon getIcon(int par1, int par2) {
		int k = par2 & 12;
		int l = par2 & 3;
		return k == 0 && (par1 == 1 || par1 == 0) ? this.iconArray1[l]
				: (k == 4 && (par1 == 5 || par1 == 4) ? this.iconArray1[l]
						: (k == 8 && (par1 == 2 || par1 == 3) ? this.iconArray1[l]
								: this.iconArray[l]));
	}

	/**
	 * Determines the damage on the item the block drops. Used in cloth and
	 * wood.
	 */
	@Override
	public int damageDropped(int par1) {
		return par1 & 3;
	}

	/**
	 * returns a number between 0 and 3
	 */
	public static int limitToValidMetadata(int par0) {
		return par0 & 3;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs,
			List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, 2));
		par3List.add(new ItemStack(par1, 1, 3));
	}

	/**
	 * Returns an item stack containing a single instance of the current block
	 * type. 'i' is the block's subtype/damage and is ignored for blocks which
	 * do not support subtypes. Blocks which cannot be harvested should return
	 * null.
	 */
/*	@Override
	protected ItemStack createStackedBlock(int par1) {
		return new ItemStack(this.blockID, 1, limitToValidMetadata(par1));
	}*/

	@SideOnly(Side.CLIENT)
	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.iconArray1 = new IIcon[treeTopTextureTypes.length];
		this.iconArray = new IIcon[treeTextureTypes.length];

		for (int i = 0; i < this.iconArray.length; ++i) {
			this.iconArray[i] = par1IconRegister
					.registerIcon(treeTextureTypes[i]);
			this.iconArray1[i] = par1IconRegister
					.registerIcon(treeTopTextureTypes[i]);
		}
	}

    @Override
    public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }

    @Override
    public boolean isWood(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }
}
