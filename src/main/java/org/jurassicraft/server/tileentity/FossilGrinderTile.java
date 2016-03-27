package org.jurassicraft.server.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import org.jurassicraft.JurassiCraft;
import org.jurassicraft.server.api.IGrindableItem;
import org.jurassicraft.server.container.FossilGrinderContainer;

import java.util.Random;

public class FossilGrinderTile extends MachineBaseTile
{
    private int[] inputs = new int[] { 0 };
    private int[] outputs = new int[] { 1, 2, 3, 4, 5, 6 };

    private ItemStack[] slots = new ItemStack[7];

    @Override
    protected int getProcess(int slot)
    {
        return 0;
    }

    @Override
    protected boolean canProcess(int process)
    {
        ItemStack input = slots[0];

        IGrindableItem grindableItem = IGrindableItem.getGrindableItem(input);

        if (grindableItem != null && grindableItem.isGrindable(input))
        {
            for (int i = 1; i < 7; i++)
            {
                if (slots[i] == null)
                {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    protected void processItem(int process)
    {
        Random rand = new Random();

        ItemStack input = slots[0];

        IGrindableItem grindableItem = IGrindableItem.getGrindableItem(input);

        ItemStack output = grindableItem.getGroundItem(input, rand);

        int emptySlot = getOutputSlot(output);

        if (emptySlot != -1)
        {
            mergeStack(emptySlot, output);
            decreaseStackSize(0);
        }
    }

    @Override
    protected int getMainOutput(int process)
    {
        return 1;
    }

    @Override
    protected int getStackProcessTime(ItemStack stack)
    {
        return 200;
    }

    @Override
    protected int getProcessCount()
    {
        return 1;
    }

    @Override
    protected int[] getInputs()
    {
        return inputs;
    }

    @Override
    protected int[] getInputs(int process)
    {
        return getInputs();
    }

    @Override
    protected int[] getOutputs()
    {
        return outputs;
    }

    @Override
    protected ItemStack[] getSlots()
    {
        return slots;
    }

    @Override
    protected void setSlots(ItemStack[] slots)
    {
        this.slots = slots;
    }

    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
        return new FossilGrinderContainer(playerInventory, this);
    }

    @Override
    public String getGuiID()
    {
        return JurassiCraft.MODID + ":fossil_grinder";
    }

    @Override
    public String getName()
    {
        return hasCustomName() ? customName : "container.fossil_grinder";
    }

    public String getCommandSenderName() // Forge Version compatibility, keep both getName and getCommandSenderName
    {
        return getName();
    }
}
