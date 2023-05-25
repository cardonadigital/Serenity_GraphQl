package co.com.sofka.tasks;

import co.com.sofka.models.Customer;
import co.com.sofka.models.RequestBody;
import io.restassured.http.ContentType;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class DeleteCustomer implements Task {

    Integer id;


    public DeleteCustomer(Integer id){
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        RequestBody body = new RequestBody();
        body.setQuery("mutation deleteCustomer($id: Int!){\n" +
                "    deleteCustomer(id: $id){\n" +
                "        id\n" +
                "    }\n" +
                "}");
        body.setVariable("id", id);


        actor.attemptsTo(
                Post.to("/").with(requestSpecification -> requestSpecification
                        .body(body)
                        .contentType(ContentType.JSON)
                        .log().all()
                )
        );
    }



    public static DeleteCustomer withInfo(Integer id){
        return Instrumented.instanceOf(DeleteCustomer.class).withProperties(id);
    }
}
