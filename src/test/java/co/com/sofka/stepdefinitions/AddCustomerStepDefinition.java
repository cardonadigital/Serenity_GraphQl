package co.com.sofka.stepdefinitions;

import co.com.sofka.models.Customer;
import co.com.sofka.questions.CustomerId;
import co.com.sofka.stepdefinitions.setup.SetupApi;
import co.com.sofka.tasks.AddCustomer;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.apache.http.HttpStatus;
import org.hamcrest.CoreMatchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class AddCustomerStepDefinition extends SetupApi {

    @Cuando("ingresa los datos de cliente id {int}, nombre {string} ,apellido {string} , ordenes de compra {int} y {int}")
    public void ingresaLosDatosDeClienteIdNombreApellidoOrdenesDeCompraY(Integer id, String nombre, String apellido, Integer order1, Integer order2) {
        actor.attemptsTo(
                AddCustomer.withInfo(new Customer(id, nombre, apellido, order1, order2))
        );
    }

    @Entonces("podra ver el nuevo cliente creado con el id {int}")
    public void podraVerElNuevoClienteCreadoConElId(Integer id) {
        actor.should(
                seeThatResponse("el codigo de respuesta debe ser " + HttpStatus.SC_OK,
                        validatableResponse -> validatableResponse.statusCode(HttpStatus.SC_OK)),
                seeThat(CustomerId.value(), CoreMatchers.equalTo(id))
        );
    }
}
