package fr.afcepf.atod.wine.entity;
import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * by roro
 */
@Entity
@Table(name = "Supplier")
public class Supplier implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8712013523204860481L;

	/**
     * size columns
     */
    @Transient
    private static final int MAX_SIZE  = 50;
   
    /**
     * id
     */
    private Integer idSupplier;
    
    /**
     * name
     */
    @Column(name     = "companyName",
            length   = MAX_SIZE * 2,
            nullable =  false)
    private String companyName;

    /**
     * phone
     */
    @Column(name     = "phoneNumber",
            length   = MAX_SIZE,
            nullable = false)
    private String phoneNumber;

    /**
     * mail
     */
    @Column(name     = "mail",
            length   = MAX_SIZE,
            nullable = false)
    private String mail;

    /**
     * created @t
     */
    @Column(name     = "createdAt",
            nullable = false)
    private Date createdAt;

    /**
     * products
     */
    private Set<ProductSupplier> productSuppliers = new HashSet<ProductSupplier>(0);
    
    // ---------- Constructors ----------//
    
     /**
     * Default constructor
     */
    public Supplier() {
    }
    /**
     * 
     * @param id
     * @param companyName
     * @param phoneNumber
     * @param mail
     * @param createdAt 
     */
    public Supplier(Integer id, String companyName, String phoneNumber,
            String mail, Date createdAt) {
        this.idSupplier = id;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.createdAt = createdAt;
    }
    /**
     * constructeur surcharge.
     * @param id
     * @param companyName
     * @param phoneNumber
     * @param mail
     * @param createdAt
     * @param productSuppliers
     */
    public Supplier(Integer id, String companyName, String phoneNumber, String mail, Date createdAt,
			Set<ProductSupplier> productSuppliers) {
		super();
		this.idSupplier = id;
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.mail = mail;
		this.createdAt = createdAt;
		this.productSuppliers = productSuppliers;
	}
    
    // -------- Getters && Setters ------//

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_supplier",unique = true, nullable = false)
	public Integer getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(Integer id) {
        this.idSupplier = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.supplier",cascade = CascadeType.ALL)
	public Set<ProductSupplier> getProductSuppliers() {
		return productSuppliers;
	}
    
	public void setProductSuppliers(Set<ProductSupplier> productSuppliers) {
		this.productSuppliers = productSuppliers;
	}

    
    
    
}