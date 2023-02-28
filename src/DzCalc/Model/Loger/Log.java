package DzCalc.Model.Loger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
    private Logger logger;
    private FileHandler fileHandler;

    public Log() {
        logger = Logger.getAnonymousLogger();
        try {
            fileHandler = new FileHandler("log.log", true);
        }catch (IOException e){
            e.printStackTrace();
        }
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);
        logger.setUseParentHandlers(false);
    }

    public void log(String example, String res) {
        logger.info(example+" = "+res);

    }
}
