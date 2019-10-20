package reports;

import org.apache.log4j.Logger;

public class Logs {

	private static Logger log = Logger.getLogger(Logs.class);

	public static void info(String message) {
		log.info(message);
	}

}
