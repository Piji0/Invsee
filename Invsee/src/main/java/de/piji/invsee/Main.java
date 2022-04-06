package de.piji.invsee;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().fine("§4 InvSee wurde geladen!");


    }

    public static String getPrefix() {
        return ChatColor.DARK_GRAY+"[" + ChatColor.GOLD + "Invsee" + ChatColor.DARK_GRAY + "]";
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().fine("§4 InvSee wurde deaktiviert!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
        if(label.equalsIgnoreCase("invsee")) {
            if(sender.isOp()) {
                if(sender instanceof Player) {

                    if (args.length == 1) {
                        String name = args[0];
                        if(Bukkit.getPlayer(name) == null) {
                            sender.sendMessage("§4DerSpieler ist nicht online!");
                            return false;

                        }
                        Player target = Bukkit.getPlayer(name);
                        Player player = (Player) sender;

                        player.openInventory(target.getInventory());
                        player.sendMessage("§1Du hast das Inventar von " + target.getDisplayName() + "§1 geöffnet");
                        return true;
                    } else
                        sender.sendMessage(" §4/invsee §0<§4Spieler§0>");
                }else
                    sender.sendMessage("§4Du bist kein Spieler!");
            }else
                sender.sendMessage("§4Du kannst diesen Befehl nicht ausführen");
        }

        return false;

    }

}
