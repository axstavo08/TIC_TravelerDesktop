/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Gustavo Ramos
 */
public class Route {

    private Integer id;
    private String origin;
    private String destiny;

    public Route() {
    }
    
    public Route(String origin, String destiny) {
        this.origin = origin;
        this.destiny = destiny;
    }
    
    public Route(Integer id, String origin, String destiny) {
        this.id = id;
        this.origin = origin;
        this.destiny = destiny;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the idRoute to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * @return the destiny
     */
    public String getDestiny() {
        return destiny;
    }

    /**
     * @param destiny the destiny to set
     */
    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }
}
