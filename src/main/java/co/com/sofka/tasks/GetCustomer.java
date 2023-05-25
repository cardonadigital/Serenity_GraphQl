package co.com.sofka.tasks;

import co.com.sofka.models.RequestBody;
import io.restassured.http.ContentType;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class GetCustomer implements Task {

    String id;


    public GetCustomer(Integer id){
        this.id = String.valueOf(id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        RequestBody body = new RequestBody();
        body.setQuery("query getCustomer($id: String!){\n" +
                "    customer: customers(id: $id){\n" +
                "        id\n" +
                "        frstname\n" +
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



    public static GetCustomer withInfo(Integer id){
        return Instrumented.instanceOf(GetCustomer.class).withProperties(id);
    }
}
