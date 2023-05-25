package co.com.sofka.stepdefinitions.setup;

import net.serenitybdd.screenplay.Actor;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import static com.google.common.base.StandardSystemProperty.USER_DIR;

public class SetupApi {
    private String LOG4J_PROPERTIES_FILE_PATH = "\\src\\main\\resources\\log4j2.properties";
    protected static final Logger LOGGER = Logger.getLogger(SetupApi.class);
    protected static final Actor actor = new Actor("Pepe");
    protected static final String URL= "https://www.predic8.de/fruit-shop-graphql?";

    protected void setUpLog4j2() {
        try {
            PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH);
        }catch (Exception e){
            LOGGER.warn(e.getMessage(), e);
        }
    }
}
