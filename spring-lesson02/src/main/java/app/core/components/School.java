package app.core.components;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("school1")
@Lazy
public class School {

	public String id = "school-1";

	{
		System.out.println("school created: ");
	}

}
