package fr.afcepf.atod.wine.entity;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import de.malkusch.localized.Localized;

/**
 * by roro
 */
@Entity
@DiscriminatorValue(value = "WINE")
public class ProductWine extends Product implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6564936265772956143L;

	/**
     * size columns
     */
    @Transient
    private static final int MAX_SIZE = 50;
    
    @Transient
	private static final int MAX_SIZE_PIC = 1024;
    
    
  
    /**
     * appellation
     */
    @Column(name     = "appellation",
            length   = MAX_SIZE,
            nullable = true)
    @Localized
    private String appellation;
    
    /**
     * apiId
     */
    @Column(name     = "apiId",
            nullable = true)
    private Integer apiId;
    /**
     * imagesUrl
     */
    @Column(name     = "imagesUrl",
            length   = MAX_SIZE_PIC,
            nullable = true)
    private String imagesUrl;
    /**
     * product type
     */
    private ProductType productType;
    
    /**
     * product vintage
     */
    private ProductVintage productVintage;
    
    /**
     * varietal
     */
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
                       ProductType productType, ProductVarietal productVarietal, 
                       ProductVintage productVintage, Integer apiId) {
        super(id, name, price, description);
        this.appellation = appellation;
        this.productType = productType;
        this.productVarietal = productVarietal;
        this.apiId = apiId;
    }
        
    // ------- Getters && Setters --------//

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProductType", nullable = true)
    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProductVarietal", nullable = true)
    public ProductVarietal getProductVarietal() {
        return productVarietal;
    }

    public void setProductVarietal(ProductVarietal productVarietal) {
        this.productVarietal = productVarietal;
    }
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProductVintage", nullable = true)
	public ProductVintage getProductVintage() {
		return productVintage;
	}

	public void setProductVintage(ProductVintage productVintage) {
		this.productVintage = productVintage;
	}
	  
    public Integer getApiId() {
		return apiId;
	}

	public void setApiId(Integer apiId) {
		this.apiId = apiId;
	}
	
	public String getImagesUrl() {
		return imagesUrl;
	}

	public void setImagesUrl(String imagesUrl) {
		this.imagesUrl = imagesUrl;
	}

	@Override
	public String toString() {
		return "ProductWine [appellation=" + appellation + ", productType=" + productType
				+ ", productVarietal=" + productVarietal + ", id=" + id + ", name=" + name
				+ ", price=" + price + ", description=" + description + ", Urls=" + imagesUrl + "]";
	}   
    
}