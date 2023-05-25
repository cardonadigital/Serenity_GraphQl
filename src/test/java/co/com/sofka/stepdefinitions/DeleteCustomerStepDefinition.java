package co.com.sofka.stepdefinitions;

import co.com.sofka.questions.CustomerId;
import co.com.sofka.stepdefinitions.setup.SetupApi;
import co.com.sofka.tasks.DeleteCustomer;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import org.apache.http.HttpStatus;
import org.hamcrest.CoreMatchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class DeleteCustomerStepDefinition extends SetupApi {
    @Cuando("ingresa el id {int} del cliente que quiere eliminar")
    public void ingresaElIdDelClienteQueQuiereEliminar(Integer id) {
        actor.attemptsTo(
                DeleteCustomer.withInfo(id)
        );
    }

    @Entonces("podra ver que el cliente con el id {int} a sido eliminado correctamente")
    public void podraVerQueElClienteConElIdASidoEliminadoCorrectamente(Integer id) {
        actor.should(
                seeThatResponse("el codigo de respuesta debe ser " + HttpStatus.SC_OK,
                        validatableResponse -> validatableResponse.statusCode(HttpStatus.SC_OK)),
                seeThat(CustomerId.value(), CoreMatchers.equalTo(id))
        );
    }
}
