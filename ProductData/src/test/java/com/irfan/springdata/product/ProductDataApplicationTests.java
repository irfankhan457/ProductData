package com.irfan.springdata.product;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.irfan.springdata.product.entities.Product;
import com.irfan.springdata.product.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDataApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	//@Ignore
	public void testCreate() {
		Product product = new Product();
		product.setId(1);
		product.setName("iphone");
		product.setPrice(70000d);
		product.setDesc("Iphone X");

		productRepository.save(product);

	}

	@Test
	public void testRead() {
		Product product = productRepository.findById(1).orElse(new Product());
		assertNotNull(product);
		assertEquals("iphone", product.getName());
	}
	
	@Test
	public void testUpdate() {
		Product product = productRepository.findById(1).orElse(new Product());
		product.setPrice(90000d);
		productRepository.save(product);
		
	}
	
	@Test
	public void testDelete() {
		//Product product = productRepository.findById(1).orElse(new Product());
		if(productRepository.existsById(1))
		productRepository.deleteById(1);
		
	}
	
	@Test
	public void testCount() {
		//Product product = productRepository.findById(1).orElse(new Product());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>"+productRepository.count());
		
	}

}
