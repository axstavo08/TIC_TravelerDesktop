/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Route;

/**
 *
 * @author Gustavo Ramos
 */
public interface RouteDao {

    public List<Route> getAll();
    public List<Route> getAllCoincidences(String search);
    public Boolean save(Route route);
    public Boolean update(Integer id, Route route);
    public Boolean delete(Integer id);
}
