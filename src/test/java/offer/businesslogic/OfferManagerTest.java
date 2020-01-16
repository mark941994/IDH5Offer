package offer.businesslogic;


import offer.domain.Offer;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


public class OfferManagerTest {


    @Test
    public void calculateTotal() {
        //arrange
        Offer offer1 = new Offer(0, "string", "string", 5000, true, 0,0);
        Offer offer2 = new Offer(0, "string", "string", 5000, false, 0,0);
        Offer offer3 = new Offer(0, "string", "string", 5000, true, 700,0);
        Offer offer4 = new Offer(0, "string", "string", 5000, false, 700,0);
        //act
        Offer updatedOffer1 = OfferManager.calculateTotal(offer1);
        Offer updatedOffer2 = OfferManager.calculateTotal(offer2);
        Offer updatedOffer3 = OfferManager.calculateTotal(offer3);
        Offer updatedOffer4 = OfferManager.calculateTotal(offer4);
        //assert
        assertEquals(65000, updatedOffer1.getTotal());
        assertEquals(60000, updatedOffer2.getTotal());
        assertEquals(73400, updatedOffer3.getTotal());
        assertEquals(68400, updatedOffer4.getTotal());
    }
}
