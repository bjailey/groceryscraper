package uk.co.project.scraper;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import uk.co.project.scraper.controllers.GroceryController;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class);
		GroceryController groceryController = context.getBean(GroceryController.class);
		try {
			System.out.println(new JSONObject(groceryController.getGroceryResult()).toString(4));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}