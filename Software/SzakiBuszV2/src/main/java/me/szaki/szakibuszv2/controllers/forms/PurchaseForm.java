package me.szaki.szakibuszv2.controllers.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.szaki.szakibuszv2.models.PurchaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseForm {
    private Integer ticketId;
    private Integer userId;
    private Integer amount;

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public PurchaseEntity toPurchaseEntity() {
        PurchaseEntity purchaseEntity = new PurchaseEntity();
        purchaseEntity.setTicketId(ticketId);
        purchaseEntity.setUserId(userId);
        purchaseEntity.setAmount(amount);

        return purchaseEntity;
    }
}
