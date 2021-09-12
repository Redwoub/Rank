package fr.redwoub.rank.database;


import fr.redwoub.rank.Main;

import java.sql.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class MySQL {
    private Connection connection;

    public void connected(String host, int port, String database, String user, String password){
        if(!isConnected()){
            try {
                connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, password);
                Main.getInstance().getServer().getConsoleSender().sendMessage("§6[Mydoria] §aConnection etablie avec la bdd");

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void disconnect(){
        if(isConnected()){
            try {
                Main.getInstance().getServer().getConsoleSender().sendMessage("§6[Mydoria] §cDeconnection avec la bdd...");
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isConnected(){

        try {
            if((connection == null) || (connection.isClosed()) || (connection.isValid(5))){
                return false;
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public void update (String qry){
        try {
            PreparedStatement sts = connection.prepareStatement(qry);
            sts.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTables(){
        update("CREATE TABLE IF NOT EXISTS players_info (" +
                "uuid VARCHAR(255), " +
                "pseudo VARCHAR(255)," +
                "grade VARCHAR(255)," +
                "coins BIGINT)");
    }

    public Connection getConnection() {
        return connection;
    }

    public void query(String qry, Consumer<ResultSet> consumer){
        try (PreparedStatement sts = connection.prepareStatement(qry);
             ResultSet rs = sts.executeQuery()) {
            consumer.accept(rs);
        } catch(SQLException e){
            throw new IllegalStateException(e.getMessage());
        }
    }

    public Object query(String qry, Function<ResultSet, Object> consumer){
        try (PreparedStatement sts = connection.prepareStatement(qry);
             ResultSet rs = sts.executeQuery()) {
            return consumer.apply(rs);
        } catch(Exception e){
            throw new IllegalStateException(e.getMessage());
        }
    }

}
