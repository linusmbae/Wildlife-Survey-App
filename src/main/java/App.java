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

        get("/animals/new", (request, response) ->
        {
            Map<String, Object>model= new HashMap<String, Object>();
            return new ModelAndView(model,"register_animals_form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/animals/new", (request, response) ->
        {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int rangerId = Integer.parseInt(request.queryParams("rangerId"));
            EndangeredAnimals endangeredAnimals= new EndangeredAnimals(name,rangerId);
            model.put("endangeredAnimals",endangeredAnimals);
            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());
        get("/animals/endangered", (request, response) ->
        {
            Map<String, Object>model=new HashMap<String, Object>();
            List<EndangeredAnimals> endangeredAnimals=EndangeredAnimals.getAll();
            model.put("endangeredAnimals", endangeredAnimals);
            return new ModelAndView(model, "endangered_animal_form.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
