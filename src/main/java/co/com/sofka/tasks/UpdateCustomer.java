package co.com.sofka.tasks;

import co.com.sofka.models.Customer;
import co.com.sofka.models.RequestBody;
import io.restassured.http.ContentType;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class UpdateCustomer implements Task {

    Customer customer;


    public UpdateCustomer(Customer customer){
        this.customer = customer;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        RequestBody body = new RequestBody();
        body.setQuery("mutation createCustomers($id: Int, $frstname: String){\n" +
                "    updateCustomer(id: $id, frstname: $frstname){\n" +
                "        id\n" +
                "        frstname\n" +
                "    }\n" +
                "}");
        body.setVariable("id", customer.getId());
        body.setVariable("frstname", customer.getFirstName());


        actor.attemptsTo(
                Post.to("/").with(requestSpecification -> requestSpecification
                        .body(body)
                        .contentType(ContentType.JSON)
                        .log().all()
                )
        );
    }

    public static UpdateCustomer withInfo(Customer customer){
        return Instrumented.instanceOf(UpdateCustomer.class).withProperties(customer);
    }
}
