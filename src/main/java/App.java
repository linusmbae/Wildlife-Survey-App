import models.EndangeredAnimals;
import models.Sightings;
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
            endangeredAnimals.save();
            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());
        get("/animals/:id/update", (request, response) ->
        {
            Map<String, Object>model=new HashMap<String, Object>();
            int idToUpdate=Integer.parseInt(request.params(":id"));
            EndangeredAnimals editAnimal=EndangeredAnimals.findById(idToUpdate);
            model.put("editAnimal", editAnimal);
            return new ModelAndView(model, "endangered_animal_form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/animals/:id/update", (request, response) ->
        {
            Map<String , Object>model=new HashMap<String, Object>();
            String age = request.queryParams("age");
            String health = request.queryParams("health");
            int idToUpdate = Integer.parseInt(request.params(":id"));
            EndangeredAnimals updateAnimal=EndangeredAnimals.findById(idToUpdate);
            updateAnimal.update();
            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());


        get("/sight", (request, response) ->
        {
            Map<String , Object>model=new HashMap<String, Object>();
            List<Sightings>sights=Sightings.getAll();
            model.put("sights",sights);
            return new ModelAndView(model,"sight.hbs");
        },new HandlebarsTemplateEngine());

        get("/sight/new", (request, response) ->
        {
            Map<String, Object>model= new HashMap<String, Object>();
            return new ModelAndView(model,"newSight.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sight/new", (request, response) ->
        {
            Map<String, Object>model=new HashMap<String, Object>();
            int animalId=Integer.parseInt(request.queryParams("animalId"));
            String location=request.queryParams("location");
            String rangerName = request.queryParams("rangerName");

            Sightings newSight=new Sightings(animalId,location,rangerName);
            newSight.save();
            response.redirect("/sight");
            return null;
        },new HandlebarsTemplateEngine());

        get("/sight/:id/update",(request, response) ->
        {
            Map<String, Object>model=new HashMap<String, Object>();
            int idToUpdate=Integer.parseInt(request.params(":id"));
            Sightings editSight=Sightings.findById(idToUpdate);
            model.put("editSight", editSight);
            return new ModelAndView(model, "update-sight.hbs");
        },new HandlebarsTemplateEngine());
        post("/sight/:id/update", (request, response) ->
        {
            Map<String, Object>model=new HashMap<String, Object>();
            int animalId=Integer.parseInt(request.queryParams("animalId"));
            String location=request.queryParams("location");
            String rangerName = request.queryParams("rangerName");
            int idToUpdate = Integer.parseInt(request.params(":id"));
            Sightings updateSight=Sightings.findById(idToUpdate);
            updateSight.update();
            response.redirect("/sight");
            return null;
        },new HandlebarsTemplateEngine());
        get("/animals/:id/remove", (request, response) ->
        {
            Map<String, Object>model = new HashMap<String, Object>();
            int idToRemove=Integer.parseInt(request.params("id"));
            EndangeredAnimals remove =EndangeredAnimals.findById(idToRemove);
            remove.removeById();
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/sight/:id/remove", (request, response) ->
        {
            Map<String, Object>model = new HashMap<String, Object>();
            int idToRemove=Integer.parseInt(request.params("id"));
            Sightings remove =Sightings.findById(idToRemove);
            remove.removeById();
            response.redirect("/sight");
            return null;
        }, new HandlebarsTemplateEngine());
    }
}
