package com.service;

import com.google.gson.Gson;
import com.response.InstanceResponse;
import org.json.*;
import com.model.Instance;
import com.response.InstancesResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Path("/instances")
public class InstanceService {

    @POST
    public Response createInstance(String instanceJson) {
        InstanceDBDAO instanceDBDAO = new InstanceDBDAO();
        JSONObject jsonObject = new JSONObject(instanceJson);
        String instance = String.valueOf(jsonObject.get("instance"));
        Instance instance1 = new Gson().fromJson(instance, Instance.class);
        instanceDBDAO.createInstance(instance1);
        Instance inst = instanceDBDAO.getInstance(instance1.getName());
        InstancesResponse response = new InstancesResponse();
        response.setInstances(Arrays.asList(inst));
        return Response.status(Response.Status.OK).entity(new Gson().toJson(response)).build();
    }

    @GET
    @QueryParam("name")
    @Produces("application/json")
    public Response getInstance(String name){
        InstanceDBDAO instanceDBDAO = new InstanceDBDAO();
        Instance instance = instanceDBDAO.getInstance(name);
        InstancesResponse response = new InstancesResponse();
        response.setInstances(Arrays.asList(instance));
        return Response.status(Response.Status.OK).entity(new Gson().toJson(response)).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getInstanceById(@PathParam("id") long id){
        InstanceDBDAO instanceDBDAO = new InstanceDBDAO();
        Instance instance = instanceDBDAO.getInstanceById(id);
        InstanceResponse response = new InstanceResponse();
        response.setInstance(instance);
        return Response.status(Response.Status.OK).entity(new Gson().toJson(response)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInstances(){
        InstanceDBDAO instanceDBDAO = new InstanceDBDAO();
        List<Instance> instances = instanceDBDAO.getALLInstance();
        InstancesResponse response = new InstancesResponse();
        response.setInstances(instances);
        return Response.status(Response.Status.OK).entity(new Gson().toJson(response)).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateInstance(@PathParam("id") long id){
        InstanceDBDAO instanceDBDAO = new InstanceDBDAO();
        instanceDBDAO.updateInstance(id);
        Instance inst = instanceDBDAO.getInstanceById(id);
        InstanceResponse response = new InstanceResponse();
        response.setInstance(inst);
        return Response.status(Response.Status.OK).entity(new Gson().toJson(response)).build();
    }


    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deleteInstance(@PathParam("id") long id){
        InstanceDBDAO instanceDBDAO = new InstanceDBDAO();
        instanceDBDAO.deleteInstance(id);
        return Response.status(Response.Status.OK).entity(new Gson().toJson("instance has been deleted")).build();
    }


}
