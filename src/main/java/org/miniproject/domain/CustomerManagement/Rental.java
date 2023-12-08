package org.miniproject.domain.CustomerManagement;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.miniproject.domain.StoreManagement.Inventory;
import org.miniproject.domain.StoreManagement.Staff;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(schema = "movie", name ="rental")
public class Rental {

    @Id
    @Column(name = "rental_id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(name="rental_date")
    private LocalDateTime rentalDate;

    @ManyToOne
    @JoinColumn(name="inventory_id")
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @Column(name="return_date")
    private LocalDateTime returnDate;

    @ManyToOne
    @JoinColumn(name="staff_id")
    private Staff staff;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}
