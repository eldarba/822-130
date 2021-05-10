package app.core.web.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-b") // define the base URI [ip:port]
public interface ServiceBFeighnClient {

	@GetMapping("/service/b") // define the route
	String callServiceB();

}
