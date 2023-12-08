package org.miniproject.domain.StoreManagement;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.miniproject.domain.FilmManagement.Film;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(schema = "movie", name ="inventory")
public class Inventory {

    @Id
    @Column(name = "inventory_id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name="store_id")
    private Store store;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

}
