package model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor //constructeur avec tous les champs obligatoires
@NoArgsConstructor //constructeur vide ou par défaut
@AllArgsConstructor //constructeur avec tous les champs même non obligatoires
@Builder
@Entity(name="User")
@Table(name="users")
public class User {
    @Id
    @Column(name="id", nullable=false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name="first_name", nullable=false)
    private String firstName;
    @Column(name="last_name", nullable=false)
    private String lastName;
    @Column(name="email", nullable=false)
    private String email;
    @Column(name="password", nullable=false)
    private String password;
    @Column(name="phone_number", nullable=false)
    private String phoneNumber;
    @Column(name="address", nullable=false)
    private String address;
    @Column(name="postal_code", nullable=false)
    private String postalCode;
    @Column(name="city", nullable=false)
    private String city;
    @Column(name="role", nullable=false)
    private String role;


    // IDE proposition pour remplacer @Data de JPA
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    // IDE proposition pour remplacer @Data de JPA
    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
