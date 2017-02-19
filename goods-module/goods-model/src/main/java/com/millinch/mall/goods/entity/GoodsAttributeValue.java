package com.millinch.mall.goods.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author John Zhang
 * @since 2017-02-16
 */
@TableName("milli_goods_attribute_value")
public class GoodsAttributeValue implements Serializable {

	private static final long serialVersionUID = -276494346973325593L;
	@TableId(type = IdType.AUTO)
	private Long id;

	@TableField(value="goods_id")
	private Long goodsId;

	@TableField(value="attribute_id")
	private Long attributeId;

    /**
     * a unique code that represents one goods' attribute value
     */
	private Integer code;

	private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
