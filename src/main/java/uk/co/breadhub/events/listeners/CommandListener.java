package uk.co.breadhub.events.listeners;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import uk.co.breadhub.events.Events;
import uk.co.breadhub.events.utils.MiscUtils;

public class CommandListener implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        switch (command.toString().toLowerCase()) {
            case "events": {
                switch (args[0].toLowerCase()) {
                    case "start": {
                        if (sender.hasPermission("events.admin") || sender.hasPermission("events.*")) {
                            Events.startEventByName(args[1]);
                        } else {
                            sender.sendMessage(MiscUtils.toColorText("&4You do not have permission to do that command!&r"));
                        }
                        break;
                    }
                    case "list": {
                        sender.sendMessage(MiscUtils.toColorText("&6Events&7: &4[&3" + Events.getEvents().toString() + "&4]"));
                        break;
                    }
                    case "active": {
                        sender.sendMessage(MiscUtils.toColorText("&6Active Events&7: &4[&2 " + Events.getActiveEvents().toString() +" &4]"));
                        break;
                    }
                }
                break;
            }
            default:
                sendHelpMessage(sender);
                break;
        }
        return false;
    }

    private void sendHelpMessage(CommandSender sender) {
        sender.sendMessage(MiscUtils.toColorText("&6-&5=&6-&5=&6-&5=&7[ &6Events &5Plugin &7]&6-&5=&6-&5=&6-&5=&6-&r"));
        if (sender.hasPermission("events.admin") || sender.hasPermission("events.*")) {
            sender.sendMessage(MiscUtils.toColorText("&6-&5=&6-&5=&6-&5=&6-&5=&6-&5=&6-&5=&6-&5=&6-&5=&6-&r"));
            sender.sendMessage(MiscUtils.toColorText(" "));
            sender.sendMessage(MiscUtils.toColorText(" &7(&6Events &4Admin&7):&r"));
            sender.sendMessage(MiscUtils.toColorText(" &9/&6events &2start &7<EventName>&r"));
            sender.sendMessage(MiscUtils.toColorText(" &9/&6events &3list"));
            sender.sendMessage(MiscUtils.toColorText(" &9/&6events &3active"));
            sender.sendMessage(MiscUtils.toColorText(" &9/&6events &4stop &7<EventName>&r"));
            sender.sendMessage(MiscUtils.toColorText(" &9/&6events &4stopall"));
            sender.sendMessage(MiscUtils.toColorText(" "));
            sender.sendMessage(MiscUtils.toColorText("&6-&5=&6-&5=&6-&5=&6-&5=&6-&5=&6-&5=&6-&5=&6-&5=&6-&r"));
        }
        sender.sendMessage(MiscUtils.toColorText(" "));
        sender.sendMessage(MiscUtils.toColorText(" &7(&6Events&7):&r"));
        sender.sendMessage(MiscUtils.toColorText(" &9/&6events &3active"));
        sender.sendMessage(MiscUtils.toColorText(" "));
        sender.sendMessage(MiscUtils.toColorText("&6-&5=&6-&5=&6-&5=&6-&5=&6-&5=&6-&5=&6-&5=&6-&5=&6-&r"));
    }
}
