package fr.afcepf.atod.wine.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@DiscriminatorColumn(name = "typeProduct")
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1084257720250486898L;
	@Transient
	private static final int MAX_SIZE = 50;

	@Transient
	private static final int MAX_SIZE_PIC = 1024;
	/**
	 * id
	 */
	protected Integer id;

	/**
	 * name
	 */
	@Column(name = "name", length = MAX_SIZE * 2, nullable = false)
	protected String name;

	/**
	 * price
	 */
	@Column(name = "price", nullable = false)
	protected Double price;

	/**
	 * description
	 */
	@Column(name = "description", length = MAX_SIZE * 4, nullable = true)
	protected String description;

	/**
	 * imagesUrl
	 */
	@Column(name = "Images", length = MAX_SIZE_PIC, nullable = true)
	private String images;

	/**
	 * created at
	 **/
	private Date createdAt;
	/**
	 * product_type
	 */
	@Column(insertable = false, updatable = false, name = "typeProduct", length = MAX_SIZE, nullable = false)
	protected String typeProduct;

	protected SpecialEvent speEvent;

	/**
	 * link order <=> product
	 */

	protected Set<OrderDetail> orderDetails;

	/**
	 * suppliers
	 */
	private Set<ProductSupplier> productSuppliers = new HashSet<ProductSupplier>(0);
	
	 /**
     * product features
     */
    private Set<ProductFeature> features = new HashSet<ProductFeature>(0);;

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
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	/**
	 * constructeur surcharge.
	 * @param id
	 * @param name
	 * @param price
	 * @param description
	 * @param createdAt
	 * @param orderDetails
	 * @param productSuppliers
	 */
	public Product(Integer id, String name, Double price, String description, Date createdAt,
			Set<OrderDetail> orderDetails, Set<ProductSupplier> productSuppliers) {
		super();
		this.id= id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.createdAt = createdAt;
		this.orderDetails = orderDetails;
		this.productSuppliers = productSuppliers;
	}

	/**
	 * constructeur surcharge.
	 * 
	 * @param idProduct
	 * @param name
	 * @param price
	 * @param description
	 * @param createdAt
	 * @param speEvent
	 * @param orderDetails
	 * @param productSuppliers
	 */
	public Product(Integer idProduct, String name, Double price, String description, Date createdAt,
			SpecialEvent speEvent, Set<OrderDetail> orderDetails, Set<ProductSupplier> productSuppliers) {
		super();
		this.id = idProduct;
		this.name = name;
		this.price = price;
		this.description = description;
		this.createdAt = createdAt;
		this.speEvent = speEvent;
		this.orderDetails = orderDetails;
		this.productSuppliers = productSuppliers;
	}

	// ------- Getters && Setters ---------//



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getIdProduct() {
		return id;
	}



	public void setIdProduct(Integer id) {
		this.id = id;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idSpecialEvent", nullable = true)
	public SpecialEvent getSpeEvent() {
		return speEvent;
	}

	public void setSpeEvent(SpecialEvent speEvent) {
		this.speEvent = speEvent;
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

	@OneToMany(mappedBy = "product_ordered", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.product", cascade = CascadeType.ALL)
	public Set<ProductSupplier> getProductSuppliers() {
		return productSuppliers;
	}

	public void setProductSuppliers(Set<ProductSupplier> productSuppliers) {
		this.productSuppliers = productSuppliers;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String imagesUrl) {
		this.images = imagesUrl;
	}
	
	/**
     * @return the features
     */
    //@ElementCollection(targetClass=ProductFeature.class)
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "products_features", 
             joinColumns = { @JoinColumn(name = "product_id") }, 
             inverseJoinColumns = { @JoinColumn(name = "productFeature_id") })
    public Set<ProductFeature> getFeatures() {
        return features;
    }

    /**
     * @param paramFeatures the features to set
     */
    public void setFeatures(Set<ProductFeature> paramFeatures) {
        features = paramFeatures;
    }

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
				+ "]";
	}

}