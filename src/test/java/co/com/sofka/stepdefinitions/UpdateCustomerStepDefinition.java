package co.com.sofka.stepdefinitions;

import co.com.sofka.models.Customer;
import co.com.sofka.questions.CustomerId;
import co.com.sofka.questions.CustomerName;
import co.com.sofka.stepdefinitions.setup.SetupApi;
import co.com.sofka.tasks.UpdateCustomer;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import org.apache.http.HttpStatus;
import org.hamcrest.CoreMatchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class UpdateCustomerStepDefinition extends SetupApi {

    @Cuando("ingresa el nuevo nombre del cliente: {string}")
    public void ingresaElNuevoNombreDelCliente(String name) {
        actor.attemptsTo(
                UpdateCustomer.withInfo(new Customer(1, name))
        );
    }

    @Entonces("podra ver que el cliente tiene el nombre {string} actualizado")
    public void podraVerQueElClienteTieneElNombreActualizado(String name) {
        actor.should(
                seeThatResponse("el codigo de respuesta debe ser " + HttpStatus.SC_OK,
                        validatableResponse -> validatableResponse.statusCode(HttpStatus.SC_OK)),
                seeThat(CustomerName.value(), CoreMatchers.equalTo(name))
        );
    }
}
