package me.szaki.szakibuszv2.interfaces;

import me.szaki.szakibuszv2.models.PurchaseEntity;

/**
 * Interface for the purchase service
 */
public interface IPurchaseService {
    /**
     * Place a new purchase
     * @param purchaseEntity the purchase to place
     * @return the placed purchase if the placement was successful or null if it wasn't
     */
    PurchaseEntity placePurchase(PurchaseEntity purchaseEntity);
}
