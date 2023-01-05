package me.szaki.szakibuszv2.controllers;

import me.szaki.szakibuszv2.controllers.forms.PurchaseForm;
import me.szaki.szakibuszv2.services.PurchaseService;
import me.szaki.szakibuszv2.utilities.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/api/purchase", produces = "application/json")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/place")
    public void placePurchase(@RequestBody PurchaseForm purchaseForm) {
        purchaseService.placePurchase(purchaseForm.toPurchaseEntity());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception e) {
        return new ErrorResponse(e.getMessage());
    }
}
