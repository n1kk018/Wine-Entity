package fr.afcepf.atod.wine.entity;
import java.io.Serializable;
import java.util.*;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * by roro
 */
@Entity
@Table(name = "Product")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Product implements Serializable {
    @Transient
    private static final int MAX_SIZE = 50;
    /**
     * id
     */
    protected Integer idProduct;

    /**
     * name
     */
    @Column(name     = "name",
            length   = MAX_SIZE*2,
            nullable = false)
    protected String name;

    /**
     * price
     */
     @Column(name    = "price",
            nullable = false)
    protected Double price;

    /**
     * description
     */
      @Column(name     = "description",
            length   = MAX_SIZE*4,
            nullable = false)
    protected String description;
      
	  /**
	   * created at
	   */
      @Temporal(TemporalType.TIMESTAMP)
      @Column(name="createdAt", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
	  private Date createdAt;

    /**
     * link order <=> product
     */
   
    protected Set<OrderDetail> orderDetails;
    
    /**
     * suppliers
     */
    private Set<ProductSupplier> productSuppliers = new HashSet<ProductSupplier>(0);

    // -------- Constructors ------------ //
    
     /**
     * Default constructor
     */
    public Product() {
    }    
    /**
     * 
     * @param id
     * @param name
     * @param price
     * @param description 
     */
    public Product(Integer id, String name, Double price, String description) {
        this.idProduct = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }
    
    
    
        
    // ------- Getters && Setters ---------//

    public Product(Integer id, String name, Double price, String description, Date createdAt,
			Set<OrderDetail> orderDetails, Set<ProductSupplier> productSuppliers) {
		super();
		this.idProduct = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.createdAt = createdAt;
		this.orderDetails = orderDetails;
		this.productSuppliers = productSuppliers;
	}
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_product",unique=true,nullable=false)
	public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer id) {
        this.idProduct = id;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @OneToMany(mappedBy = "product_ordered",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }


   
        
    public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.product",cascade=CascadeType.ALL)
	public Set<ProductSupplier> getProductSuppliers() {
		return productSuppliers;
	}
	
	public void setProductSuppliers(Set<ProductSupplier> productSuppliers) {
		this.productSuppliers = productSuppliers;
	}
	@Override
	public String toString() {
		return "Product [id=" + idProduct + ", name=" + name + ", price=" + price + ", description=" + description + "]";
	}    
	
	
}