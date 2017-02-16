package com.millinch.mall.goods.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 品牌
 * </p>
 *
 * @author John Zhang
 * @since 2017-02-16
 */
@TableName("milli_brand")
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Long id;

	private String name;

	@TableField(value="category_id")
	private Long categoryId;

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
}
