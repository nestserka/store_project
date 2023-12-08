package org.miniproject.domain.StoreManagement;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.miniproject.domain.StoreManagement.Address;
import org.miniproject.domain.StoreManagement.Staff;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(schema = "movie", name ="store")
public class Store {

    @Id
    @Column(name = "store_id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Byte id;

    @OneToOne
    @JoinColumn(name="manager_staff_id")
    private Staff staff;

    @OneToOne
    @JoinColumn(name="address_id")
    private Address address;


    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;


}
