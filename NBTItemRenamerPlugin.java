import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class NBTItemRenamer extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin NBTItemRenamer ativado!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin NBTItemRenamer desativado!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("renamenbt") && sender instanceof Player) {
            Player player = (Player) sender;
            ItemStack itemInHand = player.getInventory().getItemInMainHand();

            if (itemInHand != null) {
                // Altere "NovoNome" para o novo nome que você deseja aplicar ao item
                String novoNome = "NovoNome";

                // Obtém as NBT tags do item
                itemInHand = NBTUtils.renameItem(itemInHand, novoNome);

                player.getInventory().setItemInMainHand(itemInHand);
                player.sendMessage("Item renomeado para " + novoNome);
            } else {
                player.sendMessage("Segure um item para renomear!");
            }

            return true;
        }
        return false;
    }
}
