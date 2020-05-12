package com.project.webapp.dao;

import com.project.webapp.model.ProductInfo;

public interface ProductDao {
	
	boolean insert(ProductInfo product);
	void update(ProductInfo product);
	void delete(ProductInfo product);
}
