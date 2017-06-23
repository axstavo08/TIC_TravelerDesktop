/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import Factory.ConnectionDb;
import Factory.FactoryConnectionDb;
import dao.RouteDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Route;

/**
 *
 * @author Gustavo Ramos
 */
public class RouteDaoImpl implements RouteDao {

    ConnectionDb conn;
    public static final String GET_ALL = "SELECT idruta, origen, destino FROM ruta";

    public RouteDaoImpl() {
        this.conn = FactoryConnectionDb.Open();
    }

    @Override
    public List<Route> getAll() {
        StringBuilder sql = new StringBuilder();
        sql.append(GET_ALL + " ORDER BY idruta");
        List<Route> list = new ArrayList<>();
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while (rs.next()) {
                list.add(new Route(rs.getInt("idruta"), rs.getString("origen"), rs.getString("destino")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conn.close();
        }
        return list;
    }
    
    @Override
    public List<Route> getAllCoincidences(String search) {
        StringBuilder sql = new StringBuilder();
        sql.append(GET_ALL + " WHERE origen LIKE '%").append(search).append("%' OR destino LIKE '%")
                .append(search).append("%' ORDER BY idruta");
        List<Route> list = new ArrayList<>();
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while (rs.next()) {
                list.add(new Route(rs.getInt("idruta"), rs.getString("origen"), rs.getString("destino")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conn.close();
        }
        return list;
    }

    @Override
    public Boolean save(Route route) {
        Boolean save = Boolean.FALSE;
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ruta(origen, destino) VALUES ('")
                .append(route.getOrigin()).append("','")
                .append(route.getDestiny()).append("')");
        try {
            this.conn.execute(sql.toString());
            save = Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.conn.close();
        }
        return save;
    }

    @Override
    public Boolean update(Integer idRoute, Route route) {
        Boolean save = Boolean.FALSE;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE ruta SET origen='").append(route.getOrigin()).append("', ")
                .append("destino='").append(route.getDestiny()).append("'")
                .append(" WHERE idruta=").append(idRoute);
        try {
            this.conn.execute(sql.toString());
            save = Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.conn.close();
        }
        return save;
    }

    @Override
    public Boolean delete(Integer idRoute) {
        Boolean save = Boolean.FALSE;
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM ruta WHERE idruta=").append(idRoute);
        try {
            this.conn.execute(sql.toString());
            save = Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.conn.close();
        }
        return save;
    }

}
