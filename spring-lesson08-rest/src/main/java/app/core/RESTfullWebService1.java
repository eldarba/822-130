package app.core;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:8080
@RestController
@RequestMapping("/api")
public class RESTfullWebService1 {

	// http://localhost:8080/api/greet
	@GetMapping("/greet")
	public String greet() {
		if (Math.random() < 0.5) {
			throw new RuntimeException("internal server error");
		}
		return "Hello user";
	}

	// define that this method is operated using HTTP GET method and "sum" as route
	@GetMapping("/sum")
	public Integer sum(@RequestParam int a, @RequestParam int b) {
		return a + b;
	}

}
