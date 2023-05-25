package co.com.sofka.questions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CustomerId implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        String response = SerenityRest.lastResponse().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(response);
            return  rootNode
                    .findValue("id")
                    .asInt();
        } catch (JsonProcessingException e) {
            System.out.println("verificar que el customer con ese id exista");
            throw new RuntimeException(e);
        }
    }

    public static CustomerId value(){
        return Instrumented.instanceOf(CustomerId.class).withProperties();
    }

}
