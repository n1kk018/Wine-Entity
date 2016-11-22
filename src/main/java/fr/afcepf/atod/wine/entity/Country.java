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
     * code
     */
    @Column(name     = "code",
            length   = MAX_SIZE, 
            nullable = false)
    private String code;

    /**
     * name
     */
    @Column(name     = "name",
            length   = MAX_SIZE, 
            nullable = false)
    private String name;
    
    /**
     * currency code
     */
    @Column(name     = "currency",
            length   = MAX_SIZE, 
            nullable = false)
    private String currency;
    
    /**
     * currency code
     */
    @Column(name     = "currency_lbl",
            length   = MAX_SIZE, 
            nullable = false)
    private String currencyLbl;
    
    /**
     * currency css class
     */
    @Column(name     = "currency_class",
            length   = MAX_SIZE, 
            nullable = false)
    private String currencyClass;
    
    /**
     * set Adresses
     */
    @OneToMany(mappedBy = "country")
    private Set<Adress> adresses;
    
    // ------- Constructors -------//
    
    /**
     * Default constructor
     */
    public Country() {
    }

    public Country(Integer id, String code, String name, String currency, String currencyLbl, String currencyClass) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.currency = currency;
        this.currencyLbl = currencyLbl;
        this.currencyClass = currencyClass;
    }
    
    // ------ Getters && Setters --------- //
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String paramCode) {
        code = paramCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Adress> getAdresses() {
        return adresses;
    }

    public void setAdresses(Set<Adress> adresses) {
        this.adresses = adresses;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String paramCurrency) {
        currency = paramCurrency;
    }
    

    public String getCurrencyLbl() {
        return currencyLbl;
    }

    public void setCurrencyLbl(String paramCurrencyLbl) {
        currencyLbl = paramCurrencyLbl;
    }

    public String getCurrencyClass() {
        return currencyClass;
    }

    public void setCurrencyClass(String paramCurrencyClass) {
        currencyClass = paramCurrencyClass;
    }
}