package dk.sebsa.updateme;

import eu.midnightdust.lib.config.MidnightConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class UpdateMEClient {
	public static final String MOD_ID = "updateme";
	public static Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	public static String currVer, newVer;
	public static boolean needsUpdate;
	public static boolean screenShown = false;

	public static void init() {
		// Init config
		MidnightConfig.init(MOD_ID, Config.class);
		currVer = Config.versionString;
		newVer = currVer;
		LOGGER.info("Update ME! Running. Current modpack version: " + currVer);

		// Check for newest version
		if(!Config.newestVersionUrl.isEmpty() && !Config.newestVersionUrl.equalsIgnoreCase("none")) {
			try {
				URL url = new URL(Config.newestVersionUrl);
				Scanner s = new Scanner(url.openStream());
				// read from your scanner
				newVer = s.nextLine();
				LOGGER.info("Modpacks newest version: " + newVer);
			}
			catch(IOException ex) {
				LOGGER.error("A IOException occured getting newest version", ex);
				return;
			}
		}

		// Check if an update is needed
		if(!currVer.equals(newVer)) {
			LOGGER.warn("Modpack needs an update");
			needsUpdate = true;
		} else {
			LOGGER.info("Modpack is up-to date");
			needsUpdate = false;
		}
	}
}
