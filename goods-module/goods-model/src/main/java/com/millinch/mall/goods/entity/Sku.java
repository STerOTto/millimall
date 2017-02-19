package com.millinch.mall.goods.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *  SKU (Stock Keeping Unit)
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

	@TableField(value = "store_id")
	private Long storeaId;

	@TableField(value="goods_id")
	private Long goodsId;

	private String name;

	/**
	 * each SKU composed of attributes and values
	 */
	@TableField(value = "attribute_codes")
	private String attributeCodes;

	private String sku;

	private BigDecimal price;

	private Integer stock;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStoreaId() {
		return storeaId;
	}

	public void setStoreaId(Long storeaId) {
		this.storeaId = storeaId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAttributeCodes() {
		return attributeCodes;
	}

	public void setAttributeCodes(String attributeCodes) {
		this.attributeCodes = attributeCodes;
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

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("storeaId", storeaId).append("goodsId", goodsId).append("name", name).append("attributeCodes", attributeCodes).append("sku", sku).append("price", price).append("stock", stock).toString();
	}
}
