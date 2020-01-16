package offer.domain;

public class Offer {
    private int offerId;
    private String recruiter;
    private String company;
    private int monthly;
    private boolean extraMonth;
    private int leaseBudget;
    private int total;



    public Offer(int offerId, String recruiter, String company, int monthly, boolean extraMonth, int leaseBudget, int total) {
        this.offerId = offerId;
        this.recruiter = recruiter;
        this.company = company;
        this.monthly = monthly;
        this.extraMonth = extraMonth;
        this.leaseBudget = leaseBudget;
        this.total = total;
    }


    public int getOfferId() {
        return offerId;
    }

    public String getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(String Recruiter) {
        this.recruiter = Recruiter;
    }

    public String getCompany() {
        return company;
    }
    public void setCompany(String Company) {
        this.company = Company;
    }
    public int getMonthly() {
        return monthly;
    }
    public void setMonhtly(int Monthly) {
        this.monthly = Monthly;
    }

    public boolean getExtraMonth() {
        return extraMonth;
    }
    public void setExtraMonth(boolean etxraMonth) {
        this.extraMonth = etxraMonth;
    }

    public int getLeaseBudget() {
        return leaseBudget;
    }
    public void setLeaseBudget(int LeaseBudget) {
        this.leaseBudget = LeaseBudget;
    }

    public int getTotal() {
        return total;
    }
    public void setTotal(int Total) {
        this.total = Total;
    }

}
