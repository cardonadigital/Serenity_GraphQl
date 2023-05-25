package co.com.sofka.tasks;

import co.com.sofka.models.Customer;
import co.com.sofka.models.RequestBody;
import io.restassured.http.ContentType;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class AddCustomer implements Task {
    Customer customer;


    public AddCustomer(Customer customer){
        this.customer = customer;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        RequestBody body = new RequestBody();
        body.setQuery("mutation createCustomers($id: Int!, $lastname: String!, $frstname: String!, $orders: [Int]!){\n" +
                "    addCustomer(id: $id, lastname: $lastname, frstname : $frstname,orders: $orders){\n" +
                "        id\n" +
                "        lastname\n" +
                "    }\n" +
                "}");
        body.setVariable("id", customer.getId());
        body.setVariable("lastname", customer.getLastName());
        body.setVariable("frstname", customer.getFirstName());
        body.setVariable("orders", customer.getOrders());


        actor.attemptsTo(
                Post.to("/").with(requestSpecification -> requestSpecification
                        .body(body)
                        .contentType(ContentType.JSON)
                        .log().all()
                )
        );
    }


    public static AddCustomer withInfo(Customer customer){
        return Instrumented.instanceOf(AddCustomer.class).withProperties(customer);
    }
}
