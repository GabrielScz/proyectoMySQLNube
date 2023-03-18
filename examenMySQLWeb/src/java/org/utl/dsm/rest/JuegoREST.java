/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.utl.dsm.controller.ControllerJuego;
import org.utl.dsm.model.Juego;


@Path("juegos")
public class JuegoREST {
    
    @Path("insert")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(@FormParam("datos") @DefaultValue("") String datos){
        Gson gson = new Gson();
        Juego j = new Juego();
        
        j = gson.fromJson(datos, Juego.class);
        String out = "";
        ControllerJuego objCJ = new ControllerJuego();
        try {
            objCJ.insert(j);
            out = gson.toJson(j);
        } catch (Exception ex) {
            ex.printStackTrace();
            out = """
                     {"result": "error"}
                     """;
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAll")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@FormParam("estatus") @DefaultValue("1") String estatus) {

        String out = "";
        try {
            ControllerJuego objCJ = new ControllerJuego();
            List<Juego> juegos = objCJ.getAll(estatus);
            Gson gs = new Gson();
            out = gs.toJson(juegos);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();

    }
    
    @Path("update")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@FormParam("datos") @DefaultValue("") String datos) {

        Gson gson = new Gson();
        Juego j = new Juego();
        j = gson.fromJson(datos, Juego.class);
        String out = "";
        ControllerJuego objCJ = new ControllerJuego();
        
        try {
                j = gson.fromJson(datos, Juego.class);
                objCJ.update(j);
                out = gson.toJson(j);
            
        } catch (Exception ex) {
            ex.printStackTrace();
            out = """
                     {"result": "error"}
                     """;
        }
        
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("delete")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@FormParam("datos") @DefaultValue("") String datos) {

        Gson gson = new Gson();
        Juego j = new Juego();
        String out = "";
        j = gson.fromJson(datos, Juego.class);
        ControllerJuego objCJ = new ControllerJuego();
        
        try {
                j = gson.fromJson(datos, Juego.class);
                objCJ.delete(j);
                out = gson.toJson(j);
           
        } catch (Exception ex) {
            ex.printStackTrace();
            out = """
                     {"result": "error"}
                     """;
        }
        
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("activate")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response activate(@FormParam("datos") @DefaultValue("") String datos) {

        Gson gson = new Gson();
        Juego j = new Juego();
        String out = "";
        j = gson.fromJson(datos, Juego.class);
        ControllerJuego objCJ = new ControllerJuego();
        
        try {
            
                j = gson.fromJson(datos, Juego.class);
                objCJ.activate(j);
                out = gson.toJson(j);
            
        } catch (Exception ex) {
            ex.printStackTrace();
            out = """
                     {"result": "error"}
                     """;
        }
        
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("buscar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(@QueryParam("busqueda") @DefaultValue("Car") String busqueda) {

        String out = "";
        try {
            ControllerJuego objCJ = new ControllerJuego();
            List<Juego> juegos = objCJ.search(busqueda);
            Gson gs = new Gson();
            out = gs.toJson(juegos);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();

    }
    
    
}
