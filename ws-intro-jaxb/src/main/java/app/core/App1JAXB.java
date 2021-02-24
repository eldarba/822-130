package app.core;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import app.core.person.Person;

public class App1JAXB {

	public static void main(String[] args) {

		try {
			JAXBContext ctx = JAXBContext.newInstance(Person.class);
			// will convert Object to XML format
			Marshaller marshaller = ctx.createMarshaller();
			// create a person object
			Person p = new Person();
			// set fields values
			p.setId(102);
			p.setName("Dana");
			p.setAge(27);
			// marshal the person object into person.xml file
			marshaller.marshal(p, new File("person.xml"));
			System.out.println("done");

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
