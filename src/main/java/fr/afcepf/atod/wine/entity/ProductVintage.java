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
@Table(name = "ProductVintage")
@Entity
public class ProductVintage implements Serializable {
    /**
     * columns size
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
     * year
     */
    @Column(name = "year",
            nullable = true)
    private Integer year;
    
    /**
     * products wine
     */
    @OneToMany(mappedBy = "productVintage")
    private Set<ProductWine> productsWine;
    
    
    
    // ---------- Constructors -----------//
      /**
     * Default constructor
     */
    public ProductVintage() {
    }
    /**
     * 
     * @param id
     * @param type 
     */
    public ProductVintage(Integer id, Integer year) {
        this.id = id;
        this.year = year;
    }
        

    // ----------- Getters && Setters ----------//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

    public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Set<ProductWine> getProductsWine() {
        return productsWine;
    }

    public void setProductsWine(Set<ProductWine> productsWine) {
        this.productsWine = productsWine;
    }
	@Override
	public String toString() {
		return "ProductVintage[id=" + id + ", year=" + year + "]";
	}
    
}