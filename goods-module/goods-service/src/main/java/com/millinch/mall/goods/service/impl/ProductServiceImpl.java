package com.millinch.mall.goods.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.millinch.mall.goods.entity.Product;
import com.millinch.mall.goods.mapper.ProductMapper;
import com.millinch.mall.goods.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author John Zhang
 * @since 2017-02-22
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
	
}
