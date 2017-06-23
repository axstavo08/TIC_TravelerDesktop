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
public class Airport {
    private Integer id;
    private String name;
    private String location;
    private Integer capacity;
    private Integer tracks;

    public Airport() {
    }

    public Airport(String name, String location, Integer capacity, Integer tracks) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.tracks = tracks;
    }

    public Airport(Integer id, String name, String location, Integer capacity, Integer tracks) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.tracks = tracks;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the capacity
     */
    public Integer getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the tracks
     */
    public Integer getTracks() {
        return tracks;
    }

    /**
     * @param tracks the tracks to set
     */
    public void setTracks(Integer tracks) {
        this.tracks = tracks;
    }
}
