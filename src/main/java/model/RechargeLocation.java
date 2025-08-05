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
@Entity(name="RechargeLocation")
@Table(name="recharge_locations")
public class RechargeLocation {

    @Id
    @Column(name="id", nullable=false)
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;

    @Column(name="address", nullable=false)
    private String address;
    @Column(name="city", nullable=false)
    private String city;
    @Column(name="latitude", nullable=false)
    private Double latitude;
    @Column(name="longitude", nullable=false)
    private Double longitude;
    @Column(name="instructions")
    private String instructions;

    // IDE proposition pour remplacer @Data de JPA
    /**
     * Vérifie l’égalité entre deux entités en se basant uniquement sur leur identifiant (id).
     * Gère aussi le cas où Hibernate utilise des proxies pour le lazy loading.
     *
     * @param o l'objet à comparer
     * @return true si les objets sont égaux (même id non nul et même classe effective), false sinon
     */
    @Override
    public final boolean equals(Object o) {
        // Vérifie si c’est le même objet en mémoire
        if (this == o) return true;
        // Si l’objet est null
        if (o == null) return false;
        // Récupère la vraie classe de l’objet comparé,
        // même s’il s’agit d’un proxy Hibernate
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();

        // Récupère la vraie classe du this, même si proxy Hibernate
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();

        // Si les classes ne correspondent pas, objets différents
        if (thisEffectiveClass != oEffectiveClass) return false;

        // Cast en User après vérification de classe
        User user = (User) o;

        // Deux entités sont égales si leur id est non nul et identique
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    // IDE proposition pour remplacer @Data de JPA
    /**
     * Calcule le hashCode en se basant sur la classe effective.
     * Permet une cohérence avec equals, surtout avec les proxies Hibernate.
     *
     * @return un hashcode stable basé sur la classe réelle
     */
    @Override
    public final int hashCode() {
        // Prend en compte la classe réelle, même si proxy
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
