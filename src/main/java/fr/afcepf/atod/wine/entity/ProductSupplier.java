package fr.afcepf.atod.wine.entity;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "product_supplier")
@Entity
@AssociationOverrides({
	@AssociationOverride(name = "pk.product", joinColumns = @JoinColumn(name = "id_product")),
	@AssociationOverride(name = "pk.supplier", joinColumns = @JoinColumn(name = "id_supplier")) 
	})
public class ProductSupplier  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8907562170034527300L;
	
	private ProductSupplierId pk = new ProductSupplierId();
	private Integer quantity;
	
	
	@EmbeddedId
	public ProductSupplierId getPk() {
		return pk;
	}

	public void setPk(ProductSupplierId pk) {
		this.pk = pk;
	}

	@Transient
	public Product getProduct() {
		return getPk().getProduct();
	}

	public void setProduct(Product product) {
		getPk().setProduct(product);
	}

	@Transient
	public Supplier getSupplier() {
		return getPk().getSupplier();
	}

	public void setSupplier(Supplier supplier) {
		getPk().setSupplier(supplier);
	}
	
	@Column(name = "quantity")
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
