package fr.afcepf.atod.wine.entity;
import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import de.malkusch.localized.Localized;

/**
 * by roro
 */
@Table(name = "ProductFeature")
@Entity
public class ProductFeature implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8889060368530487153L;
    
    /**
     * columns
     */
    @Transient
    private static final int MAX_SIZE = 50;
    /**
     * id
     */
    private Integer id;

    /**
     * description
     */
    @Column(name     = "label",
            length   = MAX_SIZE * 20,
            nullable = false)
    @Localized
    private String label;
    
    /**
     * wines
     */ 
    @ElementCollection(targetClass=Product.class)
    private Set<Product> products;
    
    /**
     * 
     */
    public ProductFeature() {
        super();
    }

    /**
     * @param paramId
     * @param paramLabel
     */
    public ProductFeature(Integer paramId, String paramLabel) {
        super();
        id = paramId;
        label = paramLabel;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param paramLabel the label to set
     */
    public void setLabel(String paramLabel) {
        label = paramLabel;
    }

    

    /**
     * @return the wines
     */
    @ManyToMany(cascade=CascadeType.ALL, mappedBy="features") 
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * @param paramWines the wines to set
     */
    public void setProducts(Set<Product> paramProducts) {
        products = paramProducts;
    }

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_feature", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    /**
     * @param paramId the id to set
     */
    public void setId(Integer paramId) {
        id = paramId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ProductFeature [id=" + id + ", label=" + label+"]";
    }
    
    
}
