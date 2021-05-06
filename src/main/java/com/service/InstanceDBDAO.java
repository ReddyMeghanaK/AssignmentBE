package com.service;
import com.model.Instance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstanceDBDAO {

    private static final  String CREATE_INSTANCE_QUERY = "insert into instance (name,createdby,teamId,deletedat,isfree,isdeleted) values(?,?,?,?,?,?)";
    private static final  String UPDATE_INSTANCE_QUERY = "update instance set isfree = true where id = ?";
    private static final  String DELETE_INSTANCE_QUERY = "Delete from instance where id = ?";
    private static final  String GET_INSTANCE_QUERY = "select * from instance where name = ?";
    private static final  String GET_INSTANCE_BY_ID_QUERY = "select * from instance where id = ?";
    private static final  String GET_ALL_INSTANCE_QUERY = "select * from instance order by createdat desc";

    public Instance getInstance(String name){
        Connection connection = null;
        PreparedStatement statement = null;
        Instance instance1 = new Instance();
       // Attributes attributes = new Attributes();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/data1","root","");
            statement = connection.prepareStatement(GET_INSTANCE_QUERY);
            statement.setString(1,name);
            ResultSet rs=statement.executeQuery();
            if(rs.next()){
                long id = rs.getInt(1);
                instance1.setId(id);
                String name1 =rs.getString(2);
                instance1.setName(name1);
                long createdBy =rs.getLong(3);
                instance1.setCreatedBy(createdBy);
                long teamId = rs.getLong(4);
                instance1.setTeamId(teamId);
                Timestamp createdAt = rs.getTimestamp(5);
                instance1.setCreatedAt(createdAt);
                Timestamp updateAt = rs.getTimestamp(6);
                instance1.setUpdatedAt(updateAt);
                Timestamp deleteAt = rs.getTimestamp(7);
                instance1.setDeletedAt(deleteAt);
                Boolean isFree = rs.getBoolean(8);
                instance1.setFree(isFree);
                Boolean isDeleted = rs.getBoolean(9);
                instance1.setDeleted(isDeleted);
                return instance1;
        }
        }
        catch(Exception e){
            System.out.println(e);}
        finally{
            try {
                connection.close();
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return  instance1;
    }
    public Instance getInstanceById(long id){
        Connection connection = null;
        PreparedStatement statement = null;
        Instance instance1 = new Instance();
        // Attributes attributes = new Attributes();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/data1","root","");
            statement = connection.prepareStatement(GET_INSTANCE_BY_ID_QUERY);
            statement.setLong(1,id);
            ResultSet rs=statement.executeQuery();
            if(rs.next()){
                long id1 = rs.getInt(1);
                instance1.setId(id1);
                String name1 =rs.getString(2);
                instance1.setName(name1);
                long createdBy =rs.getLong(3);
                instance1.setCreatedBy(createdBy);
                long teamId = rs.getLong(4);
                instance1.setTeamId(teamId);
                Timestamp createdAt = rs.getTimestamp(5);
                instance1.setCreatedAt(createdAt);
                Timestamp updateAt = rs.getTimestamp(6);
                instance1.setUpdatedAt(updateAt);
                Timestamp deleteAt = rs.getTimestamp(7);
                instance1.setDeletedAt(deleteAt);
                Boolean isFree = rs.getBoolean(8);
                instance1.setFree(isFree);
                Boolean isDeleted = rs.getBoolean(9);
                instance1.setDeleted(isDeleted);
                return instance1;
            }
        }
        catch(Exception e){
            System.out.println(e);}
        finally{
            try {
                connection.close();
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return  instance1;
    }

    public List<Instance> getALLInstance(){
        List<Instance> instanceSet = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/data1","root","");
            statement = connection.prepareStatement(GET_ALL_INSTANCE_QUERY);
            ResultSet rs=statement.executeQuery();
            while (rs!=null && rs.next()){
                Instance instance1 = new Instance();
                long id = rs.getInt(1);
                instance1.setId(id);
                String name1 =rs.getString(2);
                instance1.setName(name1);
                long createdBy =rs.getLong(3);
                instance1.setCreatedBy(createdBy);
                long teamId = rs.getLong(4);
                instance1.setTeamId(teamId);
                Timestamp createdAt = rs.getTimestamp(5);
                instance1.setCreatedAt(createdAt);
                Timestamp updateAt = rs.getTimestamp(6);
                instance1.setUpdatedAt(updateAt);
                Timestamp deleteAt = rs.getTimestamp(7);
                instance1.setDeletedAt(deleteAt);
                Boolean isFree = rs.getBoolean(8);
                instance1.setFree(isFree);
                Boolean isDeleted = rs.getBoolean(9);
                instance1.setDeleted(isDeleted);
                instance1.setType("instance");
                instanceSet.add(instance1);
            }
        }
        catch(Exception e){
            System.out.println(e);}
        finally{
            try {
                connection.close();
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return  instanceSet;
    }

    public void createInstance(Instance instance){
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/data1","root","");
            statement = connection.prepareStatement(CREATE_INSTANCE_QUERY);
            int param = 1;
            statement.setString(param++,instance.getName());
            statement.setLong(param++,instance.getCreatedBy());
            statement.setLong(param++,instance.getTeamId());
            statement.setTimestamp(param++,instance.getDeletedAt());
            statement.setBoolean(param++,instance.isFree());
            statement.setBoolean(param++,instance.isDeleted());
            statement.execute();
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            try {
                connection.close();
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }


    public void updateInstance(long id){
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/data1","root","");
            statement = connection.prepareStatement(UPDATE_INSTANCE_QUERY);
            statement.setLong(1,id);
            statement.execute();
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            try {
                connection.close();
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public void deleteInstance(long id){
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/data1","root","");
            statement = connection.prepareStatement(DELETE_INSTANCE_QUERY);
            statement.setLong(1,id);
            statement.execute();
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            try {
                connection.close();
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

}