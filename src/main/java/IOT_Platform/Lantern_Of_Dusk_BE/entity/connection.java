package IOT_Platform.Lantern_Of_Dusk_BE.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class connection {

    @Id
    private int id;
    private String applicationEntity;
}
