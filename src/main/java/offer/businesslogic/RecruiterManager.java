package offer.businesslogic;

import offer.datastorage.RecruiterDOA;
import offer.domain.Recruiter;

import java.util.List;

public class RecruiterManager {
    public List<Recruiter> ListRecruiters() {
        List<Recruiter> recruiters = new RecruiterDOA().findRecruiters();

        return recruiters;
    }
    public static void createRecruiter(Recruiter recruiter) {
        RecruiterDOA.createRecruiter(recruiter);

    }
}
