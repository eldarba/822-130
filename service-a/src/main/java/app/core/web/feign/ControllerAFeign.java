package app.core.web.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ControllerAFeign {

	@Autowired // we get an implementation of the interface
	private ServiceBFeighnClient feignClient;

	@GetMapping("/feign")
	@HystrixCommand(fallbackMethod = "handleAFallback")
	public String handleA() {
		return "Service A calling B: " + feignClient.callServiceB();
	}

	public String handleAFallback(Throwable t) {
		return "Service A Fallback message: Can't call service B. cause:" + t;
	}
}
