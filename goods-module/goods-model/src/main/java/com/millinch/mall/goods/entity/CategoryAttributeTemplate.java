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
@TableName("milli_category_attribute_template")
public class CategoryAttributeTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Long id;

	private String name;

	@TableField(value="category_id")
	private Long categoryId;

	@TableField(value="attribute_type")
	private Integer attributeType;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(Integer attributeType) {
		this.attributeType = attributeType;
	}

}
