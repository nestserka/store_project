package org.miniproject.domain.FilmManagement;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(schema = "movie", name ="language")
public class Language {

    @Id
    @Column(name = "language_id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Byte id;
    @Column (columnDefinition = "char")
    private String name;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;


}
