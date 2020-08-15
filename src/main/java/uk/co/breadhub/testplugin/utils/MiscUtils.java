package uk.co.breadhub.testplugin.utils;

import org.bukkit.ChatColor;

public class MiscUtils {
    public static String toColorText(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
