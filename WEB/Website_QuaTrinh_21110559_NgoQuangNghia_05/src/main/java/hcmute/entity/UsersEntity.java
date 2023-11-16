package hcmute.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class UsersEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Fullname")
    private String fullname;

    @Column(name = "Email")
    private String email;

    @Column(name = "Admin") 
    private int admin;

    @Column(name = "Active")
    private int active;

    @Column(name = "Images")
    private String images;
    @OneToMany(mappedBy = "user")
	List<FavoritesEntity> favoritesEntities;
    @OneToMany(mappedBy = "user")
	List<SharesEntity> sharesEntities;
}
