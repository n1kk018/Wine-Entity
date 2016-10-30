package fr.afcepf.atod.wine.entity;

import java.io.Serializable;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * by roro
 */
@Entity
@Table(name = "Adress")
public class Adress implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -172263256055543724L;

	/**
	 * size max columns
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
	 * street
	 */
	@Column(name = "street", length = MAX_SIZE * 2, nullable = true)
	private String street;

	/**
	 * number
	 */
	@Column(name = "number", length = MAX_SIZE, nullable = true)
	private String number;
	
	/**
     * zipcode
     */
    @Column(name     = "zipcode",
            length   = MAX_SIZE,
            nullable = false)
    private String zipcode;

    /**
     * city
     */
    @Column(name     = "city",
            length   = MAX_SIZE,
            nullable = false)
    private String city;
    
    /**
     * country
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCountry", nullable = true)
    private Country country;

	/**
	 * billing
	 */
	@Column(name = "billing", columnDefinition = "tinyInt(1) default'0'", nullable = true)
	private boolean billing;

	/**
     * user
     */
    @ManyToOne
    private User user;
	

	// ---------- constructors ----------- //

	/**
	 * Default constructor
	 */
	public Adress() {
	}

	/**
	 * constructeur surcharge.
	 * @param id
	 * @param street
	 * @param number
	 * @param billing
	 * @param city
	 */
	public Adress(Integer id, String street, String number, String zipcode, String city, Country country, boolean billing) {
		this.id = id;
		this.street = street;
		this.number = number;
		this.zipcode = zipcode;
		this.city = city;
		this.country = country;
		this.billing = billing;
	}

	// ------------ getters && setters -------- //

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isBilling() {
		return billing;
	}

	public void setBilling(boolean billing) {
		this.billing = billing;
	}

	public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User paramUser) {
        user = paramUser;
    }
}