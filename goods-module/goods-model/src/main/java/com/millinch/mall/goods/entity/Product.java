package com.millinch.mall.goods.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * <p>
 * 产品
 * </p>
 *
 * @author John Zhang
 * @since 2017-02-16
 */
@TableName("milli_product")
public class Product implements Serializable {

	private static final long serialVersionUID = -7187597534900270067L;

	@TableId(type = IdType.AUTO)
	private Long id;

	private String name;

	@TableField(value="brand_id")
	private Long brandId;

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

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("brandId", brandId).toString();
    }
}
