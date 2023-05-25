package co.com.sofka.stepdefinitions;

import co.com.sofka.stepdefinitions.setup.SetupApi;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class Transversal extends SetupApi {

    @Dado("que el usuario administrador ingreso al aplicativo")
    public void queElUsuarioAdministradorIngresoAlAplicativo() {
        setUpLog4j2();
        actor.whoCan(CallAnApi.at(URL));
    }
}
