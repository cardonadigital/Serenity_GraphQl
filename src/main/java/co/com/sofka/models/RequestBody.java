package co.com.sofka.models;

import java.util.HashMap;

public class RequestBody {
    private HashMap<String, Object> variables = new HashMap<>();
    private String query;



    public void setVariable(String key, Object value) {
        variables.put(key, value);
    }

    public HashMap<String, Object> getVariables() {
        return variables;
    }

    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query;
    }

    public void setQuery(String id, Integer id1) {
    }
}
