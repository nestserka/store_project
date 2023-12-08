package org.miniproject.domain.StoreManagement;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(schema = "movie", name ="country")
public class Country {

    @Id
    @Column(name = "country_id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Short id;

    private String country;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}
