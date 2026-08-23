package buildcraft.additionalpipes.chunkloader;

import java.util.List;

import javax.annotation.Nullable;

import buildcraft.additionalpipes.APConfiguration;
import buildcraft.additionalpipes.AdditionalPipes;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTeleportTether extends BlockContainer {

	public BlockTeleportTether()
	{
		super(Material.CLOTH);
		setCreativeTab(AdditionalPipes.instance.creativeTab);
		setUnlocalizedName("teleport_tether");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileTeleportTether();
	}
	
	public boolean isFullCube()
    {
        return true;
    }

    public boolean isOpaqueCube()
    {
        return true;
    }
    
    /**
     * The type of render function called. 3 for standard block models, 2 for TESR's, 1 for liquids, -1 is no render
     */
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn)
    {
        if(!APConfiguration.enableChunkloaderRecipe) {
            list.add(I18n.format("tooltip.teleport_tether_crafting_disabled"));
        }
    }
}