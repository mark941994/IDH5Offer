package offer.businesslogic;

import offer.datastorage.CompanyDAO;
import offer.domain.Company;

import java.util.List;

public class CompanyManager {
    public List<Company> ListCompanies() {
        List<Company> companies = new CompanyDAO().findCompanies();

        return companies;
    }
    public static void createCompany(Company company) {
        CompanyDAO.createCompany(company);

    }
}
