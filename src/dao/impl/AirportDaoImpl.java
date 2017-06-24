/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import Factory.ConnectionDb;
import Factory.FactoryConnectionDb;
import dao.AirportDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Airport;
import model.Route;

/**
 *
 * @author Gustavo Ramos
 */
public class AirportDaoImpl implements AirportDao {

    ConnectionDb conn;
    public static final String GET_ALL = "SELECT idaeropuerto, nombre, ubicacion, aforo, cantpistas FROM aeropuerto";

    public AirportDaoImpl() {
        this.conn = FactoryConnectionDb.Open();
    }

    @Override
    public List<Airport> getAll() {
        StringBuilder sql = new StringBuilder();
        sql.append(GET_ALL + " ORDER BY idaeropuerto");
        List<Airport> list = new ArrayList<>();
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while (rs.next()) {
                list.add(new Airport(rs.getInt("idaeropuerto"), rs.getString("nombre"), rs.getString("ubicacion"),
                        rs.getInt("aforo"), rs.getInt("cantpistas")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.conn.close();
        }
        return list;
    }

    @Override
    public List<Airport> getAllCoincidences(String search) {
        StringBuilder sql = new StringBuilder();
        sql.append(GET_ALL + " WHERE nombre LIKE '%").append(search).append("%' OR ubicacion LIKE '%")
                .append(search).append("%' OR aforo LIKE '%").append(search)
                .append("%' OR cantpistas LIKE '%").append(search).append("%' ORDER BY idaeropuerto");
        List<Airport> list = new ArrayList<>();
        try {
            ResultSet rs = this.conn.query(sql.toString());
            while (rs.next()) {
                list.add(new Airport(rs.getInt("idaeropuerto"), rs.getString("nombre"), rs.getString("ubicacion"),
                        rs.getInt("aforo"), rs.getInt("cantpistas")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conn.close();
        }
        return list;
    }

    @Override
    public Boolean save(Airport airport) {
        Boolean save = Boolean.FALSE;
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO aeropuerto(nombre, ubicacion, aforo, cantpistas) VALUES ('")
                .append(airport.getName()).append("','")
                .append(airport.getLocation()).append("',")
                .append(airport.getCapacity()).append(",")
                .append(airport.getTracks()).append(")");
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
    public Boolean update(Integer id, Airport airport) {
        Boolean save = Boolean.FALSE;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE aeropuerto SET nombre='").append(airport.getName()).append("', ")
                .append("ubicacion='").append(airport.getLocation()).append("', ")
                .append("aforo=").append(airport.getCapacity()).append(", ")
                .append("cantpistas=").append(airport.getTracks())
                .append(" WHERE idaeropuerto=").append(id);
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
    public Boolean delete(Integer id) {
        Boolean save = Boolean.FALSE;
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM aeropuerto WHERE idaeropuerto=").append(id);
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
