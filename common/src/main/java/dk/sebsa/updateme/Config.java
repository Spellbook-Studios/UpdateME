package dk.sebsa.updateme;

import eu.midnightdust.lib.config.MidnightConfig;

public class Config extends MidnightConfig {
    @Comment public static Comment versionStringComment;
    @Entry public static String versionString  = "1.0.0";
    @Comment public static Comment newestVersionUrlComment;
    @Entry public static String newestVersionUrl  = "none";
}
