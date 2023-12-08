package org.miniproject.domain.CustomerManagement;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.miniproject.domain.StoreManagement.Staff;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(schema = "movie", name ="payment")
public class Payment {

    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Short id;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="staff_id")
    private Staff staff;

    @OneToOne
    @JoinColumn(name="rental_id")
    private Rental rental;
    private BigDecimal amount;

    @Column(name="payment_date")
    @CreationTimestamp
    private LocalDateTime paymentDate;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

}
