package com.deltastrium.deltacraft.recyclecraft.data;

import com.deltastrium.deltacraft.recyclecraft.gui.ConIncinerator;
import com.deltastrium.deltacraft.recyclecraft.gui.GuiIncinerator;
import com.deltastrium.deltacraft.recyclecraft.tiles.TileIncinerator;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity tile = world.getTileEntity(x, y, z);

        if (tile instanceof TileIncinerator) return new ConIncinerator(player.inventory, (TileIncinerator) tile);

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity tile = world.getTileEntity(x, y, z);

        if (tile instanceof TileIncinerator) return new GuiIncinerator(new ConIncinerator(player.inventory, (TileIncinerator) tile));

        return null;
    }
}
