import net.minecraft.server.v1_16_R3.NBTTagCompound;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class NBTUtils {

    public static ItemStack renameItem(ItemStack item, String newName) {
        net.minecraft.server.v1_16_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);
        NBTTagCompound tag = nmsItem.getTag();

        if (tag == null) {
            tag = new NBTTagCompound();
        }

        tag.setString("CustomName", newName);
        nmsItem.setTag(tag);

        return CraftItemStack.asBukkitCopy(nmsItem);
    }
}
