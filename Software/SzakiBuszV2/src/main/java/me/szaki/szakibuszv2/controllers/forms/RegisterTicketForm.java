package me.szaki.szakibuszv2.controllers.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.szaki.szakibuszv2.models.TicketEntity;
import me.szaki.szakibuszv2.models.enums.TicketType;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterTicketForm {
    private TicketType type;
    private Integer price;
    private Timestamp expirationDate;

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Timestamp getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Timestamp expirationDate) {
        this.expirationDate = expirationDate;
    }

    public TicketEntity toTicketEntity() {
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setType(type);
        ticketEntity.setPrice(price);
        ticketEntity.setExpirationDate(expirationDate);

        return ticketEntity;
    }
}
