package offer.businesslogic;
import offer.domain.Offer;
import offer.datastorage.OfferDAO;

import java.util.List;

public class OfferManager {
    public List<Offer> ListOffers() {
        List<Offer> offers = new OfferDAO().findOffers();

        return offers;
    }
    public static void createOffer(Offer offer) {
        OfferDAO.createOffer(offer);

    }
    public static void updateOffer(Offer offer) {
        OfferDAO.updateOffer(offer);
    }
    public static Offer calculateTotal(Offer offer){
        int total = offer.getMonthly() * 12;
        if (offer.getExtraMonth() == true) {
            total = total + offer.getMonthly();
        }
        if (offer.getLeaseBudget() > 0) {
            total = total + (offer.getLeaseBudget() * 12);
        }
        offer.setTotal(total);
        return offer;
    }
}
