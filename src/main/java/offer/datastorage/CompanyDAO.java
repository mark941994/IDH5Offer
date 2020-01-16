package offer.datastorage;

import offer.domain.Company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO {
    public CompanyDAO() {
        // Nothing to be initialized. This is a stateless class. Constructor
        // has been added to explicitely make this clear.
    }

    public List<Company> findCompanies() {
        List<Company> Companies = new ArrayList<>();


        // First open a database connnection
        DatabaseConnection connection = new DatabaseConnection();
        if (connection.openConnection()) {
            // If a connection was successfully setup, execute the SELECT statement.

            ResultSet resultset = connection.executeSQLSelectStatement(
                    "SELECT * FROM company");

            if (resultset != null) {
                try {
                    while (resultset.next()) {
                        // The value for the CopyID in the row is ignored
                        // for this POC: no Copy objects are loaded. Having the
                        // Loan objects without the Copy objects will do fine
                        // to determine whether the owning Member can be removed.
                        int Id = resultset.getInt("Id");
                        String name = resultset.getString("Name");


                        Company newCompagny = new Company(Id, name);
                        Companies.add(newCompagny);

                    }
                } catch (SQLException e) {
                    System.out.println(e);
                    Companies.clear();
                }
            }

            connection.closeConnection();

        }

        return Companies;
    }
    public static void createCompany(Company company) {
        DatabaseConnection connection = new DatabaseConnection();
        if (connection.openConnection()) {
            // If a connection was successfully setup, execute the SELECT statement.

            connection.executeSqlInsertStatement(
                    "INSERT INTO company (name) VALUES ('"+ company.getName() +"');");
            connection.closeConnection();
        }
    }
}
