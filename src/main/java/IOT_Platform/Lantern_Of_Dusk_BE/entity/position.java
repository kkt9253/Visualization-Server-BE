package IOT_Platform.Lantern_Of_Dusk_BE.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class position {

    @Id
    private int id;
    private double x;
    private double y;
    private double z;
    @CreationTimestamp
    private LocalDateTime timeStamp;
}
