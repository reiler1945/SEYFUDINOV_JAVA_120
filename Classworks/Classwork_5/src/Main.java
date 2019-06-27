public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
        logger.log("Hello1");
        logger.setPrefix("WARNING");
        logger.log("Hello2");
    }
}
