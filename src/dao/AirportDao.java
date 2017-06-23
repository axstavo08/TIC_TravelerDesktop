/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Airport;

/**
 *
 * @author Gustavo Ramos
 */
public interface AirportDao {
    
    public List<Airport> getAll();
    public List<Airport> getAllCoincidences(String search);
    public Boolean save(Airport airport);
    public Boolean update(Integer id, Airport airport);
    public Boolean delete(Integer id);
}
