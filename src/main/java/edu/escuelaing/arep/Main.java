package edu.escuelaing.arep;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.escuelaing.arep.utilities.Sorts;
import edu.escuelaing.arep.webfram.WebFramework;
import spark.Request;
import spark.Response;
import static spark.Spark.*;
import static edu.escuelaing.arep.webfram.WebFramework.getPlain;
import static edu.escuelaing.arep.webfram.WebFramework.getImage;
public class Main {

    public static void main(String[] args) {
        setPort(getPort());
        staticFileLocation("/public");
        setFiles();

    }

    /**
     * Configura todas las rutas a los archivos de texto plano, mapenado con rutas de acceso
     */
    private static void setFiles(){
        get("/", (req, resp)->{
            resp.redirect("index.html");
            return null;
        });
        post("/result", (req, resp)-> {
            resp.status(200);
            resp.type("application/json");
            String[] values=req.body().split(",");
            ArrayList<Integer> list= new ArrayList<Integer>();
            for (String i:values) {
                list.add(Integer.parseInt(i));
            }
            Sorts.bubbleSort(list);
            return "{ lista: "+list +  "}";
        });
    }

    public static String processList(Request res, Response resp){
        System.out.println(res.queryParams("YYAAA"));
        System.out.println(res.queryParams("text"));
        System.out.println(res.body());
        String[] lista= res.queryParams("text").split("\\%");
        System.out.println(Arrays.toString(lista));
        System.out.println("prueba");
        return "prueba";
    }

    /**
     * Retorna el puerto del ambiente
     * @return Retorna el puerto configurado en el servidor, si hay un configurado, de lo contrario toma como defecto el 36000
     */
    public static int getPort(){
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

}
