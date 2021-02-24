package app.core;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import app.core.person.Person;

public class App2JAXBUnmarshal {

	public static void main(String[] args) {

		try {
			JAXBContext ctx = JAXBContext.newInstance(Person.class);
			// will convert XML to Object format
			Unmarshaller unmarshaller = ctx.createUnmarshaller();
			// create a person object from the xml file
			Person p = (Person) unmarshaller.unmarshal(new File("person.xml"));
			System.out.println(p.getId());
			System.out.println(p.getName());
			System.out.println(p.getAge());

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
