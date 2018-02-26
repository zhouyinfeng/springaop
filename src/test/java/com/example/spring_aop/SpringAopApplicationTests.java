package com.example.spring_aop;

import com.example.security.CurrentUserHolder;
import com.example.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAopApplicationTests {

	@Autowired
	ProductService productService;

	@Test(expected = Exception.class)
	public void annoInsertTest() {
		CurrentUserHolder.set("tom");
		productService.delete(1L);
	}

	/*@Test
	public void adminInsert(){
		CurrentUserHolder.set("admin");
		productService.delete(1L);
	}*/
}
