package uk.co.breadhub.events.utils;

import org.bukkit.ChatColor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MiscUtils {
    public static String toColorText(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static List<File> getSubFilesFromFile(File file) {
        List<File> files = new ArrayList<>();
        File[] allFiles = file.listFiles();
        if (allFiles == null) {
            return files;
        }
        for (File subFile : allFiles) {
            if (! subFile.getName().endsWith(".yml")) {
                continue;
            }
            if (subFile.isFile()) {
                files.add(subFile);
            }
            else {
                files.addAll(getSubFilesFromFile(subFile));
            }
        }
        return files;
    }
}
