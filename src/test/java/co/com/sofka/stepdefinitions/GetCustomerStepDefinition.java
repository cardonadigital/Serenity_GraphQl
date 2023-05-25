package co.com.sofka.stepdefinitions;

import co.com.sofka.questions.CustomerId;
import co.com.sofka.questions.CustomerName;
import co.com.sofka.stepdefinitions.setup.SetupApi;
import co.com.sofka.tasks.GetCustomer;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import org.apache.http.HttpStatus;
import org.hamcrest.CoreMatchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class GetCustomerStepDefinition extends SetupApi {
    @Cuando("ingresa el id {int} del cliente que quiere obtener")
    public void ingresaElIdDelClienteQueQuiereObtener(Integer id) {
        actor.attemptsTo(
                GetCustomer.withInfo(id)
        );
    }

    @Entonces("podra ver que el nombre de usuario retornado es {string}")
    public void podraVerQueElNombreDeUsuarioRetornadoEs(String name) {
        actor.should(
                seeThatResponse("el codigo de respuesta debe ser " + HttpStatus.SC_OK,
                        validatableResponse -> validatableResponse.statusCode(HttpStatus.SC_OK)),
                seeThat(CustomerName.value(), CoreMatchers.equalTo(name))
        );
    }
}
