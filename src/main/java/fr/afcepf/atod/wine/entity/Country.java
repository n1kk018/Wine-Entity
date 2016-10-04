package fr.afcepf.atod.wine.entity;
import java.io.Serializable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * by roro
 */
@Table(name = "Country")
@Entity
public class Country implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -473519643276156347L;
	/**
     * size columns
     */
    @Transient
    private static final int MAX_SIZE = 50;
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * name
     */
    @Column(name     = "name",
            length   = MAX_SIZE, 
            nullable = false)
    private String name;
    
    /**
     * set Regions
     */
    @OneToMany(mappedBy = "country")
    private Set<Region> regions;
    
    // ------- Constructors -------//
    
    /**
     * Default constructor
     */
    public Country() {
    }

    public Country(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    // ------ Getters && Setters --------- //
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Region> getRegions() {
        return regions;
    }

    public void setRegions(Set<Region> regions) {
        this.regions = regions;
    }

    

}