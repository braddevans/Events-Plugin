package uk.co.breadhub.events.listeners;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import uk.co.breadhub.events.utils.EventsUtil;
import uk.co.breadhub.events.utils.MiscUtils;

public class CommandListener implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        switch (command.getName().toLowerCase()) {
            case "event":
            case "events":
            case "eventadmin":
            case "eventsadmin": {
                if (args.length > 0) {
                    switch (args[0].toLowerCase()) {
                        case "start": {
                            if (sender.hasPermission("events.admin") || sender.hasPermission("events.*")) {
                                EventsUtil.startEventByName(args[1]);
                            }
                            else {
                                sender.sendMessage(MiscUtils.toColorText("&4You do not have permission to do that command!&r"));
                            }
                            break;
                        }
                        case "list": {
                            sender.sendMessage(MiscUtils.toColorText("&6Events&7: &4[&3" + EventsUtil.getEvents().toString() + "&4]"));
                            break;
                        }
                        case "active": {
                            sender.sendMessage(MiscUtils.toColorText("&6Active Events&7: &4[&2" + EventsUtil.getActiveEvents().toString() + "&4]"));
                            break;
                        }
                        default:
                            sendHelpMessage(sender);
                            break;
                    }
                    break;
                }
                else {
                    sendHelpMessage(sender);
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
            sender.sendMessage(MiscUtils.toColorText(" "));
            sender.sendMessage(MiscUtils.toColorText(" &7(&6Events &4Admin&7):&r"));
            sender.sendMessage(MiscUtils.toColorText(" &6/events &2start &7<EventName>&r"));
            sender.sendMessage(MiscUtils.toColorText(" &6/events &3list"));
            sender.sendMessage(MiscUtils.toColorText(" &6/events &3active"));
            sender.sendMessage(MiscUtils.toColorText(" &6/events &4stop &7<EventName>&r"));
            sender.sendMessage(MiscUtils.toColorText(" &6/events &4stopall"));
            sender.sendMessage(MiscUtils.toColorText(" "));
            sender.sendMessage(MiscUtils.toColorText("&6-&5=&6-&5=&6-&5=&6-&5=&6-&5=&6-&5=&6-&5=&6-&5=&6-&r"));
        }
        sender.sendMessage(MiscUtils.toColorText(" "));
        sender.sendMessage(MiscUtils.toColorText(" &7(&6Events&7):&r"));
        sender.sendMessage(MiscUtils.toColorText(" &6/events &3active"));
        sender.sendMessage(MiscUtils.toColorText(" "));
        sender.sendMessage(MiscUtils.toColorText("&6-&5=&6-&5=&6-&5=&6-&5=&6-&5=&6-&5=&6-&5=&6-&5=&6-&r"));
    }
}
