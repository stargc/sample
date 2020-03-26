package com.ehualu.data.business.product.service;

import com.ehualu.data.business.product.dao.ProductMapper;
import com.ehualu.data.business.product.model.Product;
import com.ehualu.data.business.product.model.ProductExample;
import com.ehualu.data.common.filter.RequestHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author created by guanchen on 2020/3/19 9:53
 */
@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public List<Product> searchAll(){
        ProductExample example = new ProductExample();
        example.setOrderByClause("name");
        return productMapper.selectByExample(example);
    }

    public Product searchById(int id){
        ProductExample example = new ProductExample();
        example.createCriteria().andIdEqualTo(id);
        List<Product> productList = productMapper.selectByExample(example);
        if (productList.isEmpty()) return new Product();
        return productList.get(0);

    }

    public boolean add(Product product){
        product.setCreateTime(new Date());
        product.setCreateUserId(RequestHolder.getUserId());
        return productMapper.insert(product) > 0;
    }

    public boolean update(Product product){
        product.setUpdateTime(new Date());
        product.setUpdateUserId(RequestHolder.getUserId());
        ProductExample example = new ProductExample();
        example.createCriteria().andIdEqualTo(product.getId());
        return productMapper.updateByExampleSelective(product,example) > 0;
    }

    public boolean delete(String id){
        ProductExample example = new ProductExample();
        example.createCriteria().andIdEqualTo(Integer.valueOf(id));
        return productMapper.deleteByExample(example) > 0;
    }
}
