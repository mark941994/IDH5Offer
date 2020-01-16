package offer.datastorage;

import offer.domain.Recruiter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecruiterDOA {
    public RecruiterDOA() {
        // Nothing to be initialized. This is a stateless class. Constructor
        // has been added to explicitely make this clear.
    }

    public List<Recruiter> findRecruiters() {
        List<Recruiter> Recruiters = new ArrayList<>();


        // First open a database connnection
        DatabaseConnection connection = new DatabaseConnection();
        if (connection.openConnection()) {
            // If a connection was successfully setup, execute the SELECT statement.

            ResultSet resultset = connection.executeSQLSelectStatement(
                    "SELECT * FROM recruiter");

            if (resultset != null) {
                try {
                    while (resultset.next()) {
                        // The value for the CopyID in the row is ignored
                        // for this POC: no Copy objects are loaded. Having the
                        // Loan objects without the Copy objects will do fine
                        // to determine whether the owning Member can be removed.
                        int Id = resultset.getInt("Id");
                        String name = resultset.getString("name");
                        String email = resultset.getString("email");
                        String phone = resultset.getString("phone");

                        Recruiter newRecruiter = new Recruiter(Id, name, email, phone);
                        Recruiters.add(newRecruiter);

                    }
                } catch (SQLException e) {
                    System.out.println(e);
                    Recruiters.clear();
                }
            }
            // else an error occurred leave array list empty.

            // We had a database connection opened. Since we're finished,
            // we need to close it.
            connection.closeConnection();

        }

        return Recruiters;
    }
    public static void createRecruiter(Recruiter recruiter) {
        DatabaseConnection connection = new DatabaseConnection();
        if (connection.openConnection()) {
            // If a connection was successfully setup, execute the SELECT statement.

            connection.executeSqlInsertStatement(
                    "INSERT INTO recruiter (name, email, phone) VALUES ('"+ recruiter.getName() +"', '" + recruiter.getEmail() +"', '" + recruiter.getPhone() +"');");
            connection.closeConnection();
        }
    }
}
