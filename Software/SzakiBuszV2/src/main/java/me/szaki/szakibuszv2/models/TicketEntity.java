package me.szaki.szakibuszv2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import me.szaki.szakibuszv2.models.enums.TicketType;

import java.sql.Timestamp;
import java.util.Date;

@Entity(name = "ticket")
@NoArgsConstructor
@AllArgsConstructor
public class TicketEntity {
    //<editor-fold default-state="collapsed" desc="Private fields">
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, insertable = false)
    private Integer id;

    @Column(name = "type", nullable = false, columnDefinition = "ENUM('SINGLE_USE', 'MONTHLY', 'YEARLY')")
    @Enumerated(EnumType.STRING)
    private TicketType type;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "createdDate", insertable = false, updatable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Date created;

    @Column(name = "expirationDate", nullable = false)
    private Timestamp expirationDate;

    //</editor-fold>

    //<editor-fold default-state="collapsed" desc="Getters and Setters">
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Timestamp getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Timestamp expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    //</editor-fold>
}
