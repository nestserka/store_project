package org.miniproject.domain.StoreManagement;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(schema = "movie", name ="city")
public class City {

    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Short id;

    private String city;

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;


    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}
