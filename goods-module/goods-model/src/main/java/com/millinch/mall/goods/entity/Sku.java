package com.millinch.mall.goods.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author John Zhang
 * @since 2017-02-16
 */
@TableName("milli_sku")
public class Sku implements Serializable {

	private static final long serialVersionUID = -3646332771711806628L;

	@TableId(type = IdType.AUTO)
	private Long id;

	@TableField(value="product_id")
	private Long productId;

	private String sku;

	private BigDecimal price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("productId", productId).append("sku", sku).append("price", price).toString();
    }
}
