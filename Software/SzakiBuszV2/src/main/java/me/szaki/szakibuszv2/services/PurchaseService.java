package me.szaki.szakibuszv2.services;

import me.szaki.szakibuszv2.interfaces.IPurchaseService;
import me.szaki.szakibuszv2.models.PurchaseEntity;
import me.szaki.szakibuszv2.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PurchaseService implements IPurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public PurchaseEntity placePurchase(PurchaseEntity purchaseEntity) {
        return purchaseRepository.save(purchaseEntity);
    }
}
