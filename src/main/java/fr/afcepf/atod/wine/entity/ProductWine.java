package fr.afcepf.atod.wine.entity;
import java.io.Serializable;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * by roro
 */
@Entity
public class ProductWine extends Product implements Serializable {
    /**
     * size columns
     */
    @Transient
    private static final int MAX_SIZE = 50;
  
    /**
     * appellation
     */
    @Column(name     = "appellation",
            length   = MAX_SIZE,
            nullable = true)
    private String appellation;

    /**
     * product type
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProductType", nullable = true)
    private ProductType productType;
    
    /**
     * product vintage
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProductVintage", nullable = true)
    private ProductVintage productVintage;

    /**
     * varietal
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProductVarietal", nullable = true)
    private ProductVarietal productVarietal;
    
    
    // --------- Constructors ---------- //
    
    /**
     * Default constructor
     */
    public ProductWine() {
    }
    
    /**
     * 
     * @param id
     * @param name
     * @param price
     * @param description
     * @param appellation
     * @param vintage
     * @param productType
     * @param productVarietal
     * @param region 
     */
    public ProductWine(Integer id, String name, Double price,
                       String description, String appellation,
                       ProductType productType, ProductVarietal productVarietal, ProductVintage productVintage) {
        super(id, name, price, description);
        this.appellation = appellation;
        this.productType = productType;
        this.productVarietal = productVarietal;
    }
        
    // ------- Getters && Setters --------//

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public ProductVarietal getProductVarietal() {
        return productVarietal;
    }

    public void setProductVarietal(ProductVarietal productVarietal) {
        this.productVarietal = productVarietal;
    }
    
	public ProductVintage getProductVintage() {
		return productVintage;
	}

	public void setProductVintage(ProductVintage productVintage) {
		this.productVintage = productVintage;
	}

	@Override
	public String toString() {
		return "ProductWine [appellation=" + appellation + ", productType=" + productType
				+ ", productVarietal=" + productVarietal + ", id=" + id + ", name=" + name
				+ ", price=" + price + ", description=" + description + "]";
	}    
    
    
    
}