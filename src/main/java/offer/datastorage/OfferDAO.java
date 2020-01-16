package offer.datastorage;

import offer.domain.Offer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OfferDAO {
    public OfferDAO() {
        // Nothing to be initialized. This is a stateless class. Constructor
        // has been added to explicitely make this clear.
    }

    public List<Offer> findOffers() {
        List<Offer> Offers = new ArrayList<>();


            // First open a database connnection
            DatabaseConnection connection = new DatabaseConnection();
            if (connection.openConnection()) {
                // If a connection was successfully setup, execute the SELECT statement.

                ResultSet resultset = connection.executeSQLSelectStatement(
                        "SELECT * FROM offer");

                if (resultset != null) {
                    try {
                        while (resultset.next()) {
                            // The value for the CopyID in the row is ignored
                            // for this POC: no Copy objects are loaded. Having the
                            // Loan objects without the Copy objects will do fine
                            // to determine whether the owning Member can be removed.
                            int Id = resultset.getInt("Id");
                            String recruiter = resultset.getString("recruiter");
                            String company = resultset.getString("company");
                            int amount = resultset.getInt("amount");
                            Boolean extraMonth = resultset.getBoolean("extraMonth");
                            int leaseBudget = resultset.getInt("leaseBudget");
                            int total = resultset.getInt("total");

                            Offer newOffer = new Offer(Id, recruiter, company, amount, extraMonth, leaseBudget, total);
                            Offers.add(newOffer);

                        }
                    } catch (SQLException e) {
                        System.out.println(e);
                        Offers.clear();
                    }
                }
                // else an error occurred leave array list empty.

                // We had a database connection opened. Since we're finished,
                // we need to close it.
                connection.closeConnection();

        }

        return Offers;
    }
    public static void createOffer(Offer offer) {
        DatabaseConnection connection = new DatabaseConnection();
        if (connection.openConnection()) {
            // If a connection was successfully setup, execute the SELECT statement.

            connection.executeSqlInsertStatement(
                    "INSERT INTO offer (recruiter, amount, company, extraMonth, leaseBudget, total) VALUES ('" + offer.getRecruiter() +"',"+ offer.getMonthly() +", '" + offer.getCompany() +"'," + offer.getExtraMonth() +", "+ offer.getLeaseBudget()+","+offer.getTotal()+");");
            connection.closeConnection();
        }
    }
}
