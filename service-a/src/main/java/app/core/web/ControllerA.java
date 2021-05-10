package app.core.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ControllerA {

	@Autowired
	private RestTemplate template;
//	@Autowired
//	private DiscoveryClient discoveryClient;
//	@Autowired
//	private LoadBalancerClient lb;

	@GetMapping("/service/a")
	@HystrixCommand(fallbackMethod = "handleAFallback")
	public String handleA() {
		String url = "http://service-b/service/b";
		return "Service A calling B: " + template.getForObject(url, String.class);
	}

	public String handleAFallback(Throwable t) {
		return "Service A Fallback message: Can't call service B. cause:" + t;
	}

//	@GetMapping("/service/a")
//	public String handleA() {
//		try {
//			// get the base URI of a service B instance
//			String serviceId = "service-b";
//			URI baseUri = getServiceInstanceBaseUriLB(serviceId);
//			String url = baseUri + "/service/b";
//			System.out.println(url);
//			// make the request
//			return "Service A calling B: " + template.getForObject(url, String.class);
//		} catch (Exception e) {
//			e.printStackTrace(System.out);
//			return "Error";
//		}
//	}
//
//	private URI getServiceInstanceBaseUriLB(String serviceId) {
//		return lb.choose(serviceId).getUri();
//	}
//
//	private URI getServiceInstanceBaseUri(String serviceId) {
//		// print the service id
//		System.out.println("service id: " + serviceId);
//		// print all of the available instances of the service
//		System.out.println("service instance:");
//		List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceId);
//		for (ServiceInstance serviceInstance : serviceInstances) {
//			System.out.println(serviceInstance);
//		}
//		// return the URI of the first instance (NO LB)
//		return serviceInstances.get(0).getUri();
//	}
}
