package app.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CompanyDao {

	private Map<Integer, Company> compMap = new HashMap<>();

	public void addCompany(Company company) {
		System.out.println("addCompany");
		compMap.put(company.getId(), company);
	}

	public Company getCompany(int compId) {
		System.out.println("getCompany");
		return compMap.get(compId);
	}

	public Collection<Company> getAllCompanies() {
		System.out.println("getAllCompanies");
		return compMap.values();
	}

	public boolean deleteCompany(int compId) {
		System.out.println("deleteCompany");
		return compMap.remove(compId) != null ? true : false;
	}

}
