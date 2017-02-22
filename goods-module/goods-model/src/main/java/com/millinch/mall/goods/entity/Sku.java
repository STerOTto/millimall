package com.millinch.mall.goods.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 *
 * @author John Zhang
 */
@TableName("milli_sku")
public class Sku implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 店铺ID
	 */
	@TableField(value = "store_id")
	private Long storeId;

	@TableField(value="goods_id")
	private Long goodsId;

	private String name;

	/**
	 * `each` sku composed of attributes and values
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

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
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

}
