import models.EndangeredAnimals;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");


        get("/",(request, response) ->
{
    Map<String, Object>model=new HashMap<String, Object>();
    List<EndangeredAnimals> endangeredAnimals=EndangeredAnimals.getAll();
    model.put("endangeredAnimals", endangeredAnimals);
    return new ModelAndView(model, "index.hbs");
}, new HandlebarsTemplateEngine());
    }
}
