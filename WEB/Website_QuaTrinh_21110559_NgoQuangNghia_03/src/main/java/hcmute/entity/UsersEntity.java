package hcmute.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
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
@Table(name = "users")
@NamedQuery(name = "users.findAll", query = "SELECT c FROM UsersEntity c")
public class UsersEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email", columnDefinition = "varchar(50)")
    private String email;

    @Column(name = "fullname", columnDefinition = "nvarchar(50)")
    private String fullname;

    @Column(name = "phone", columnDefinition = "int")
    private int phone;

    @Column(name = "passwd", columnDefinition = "varchar(32)")
    private String passwd;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "signup_date")
    private Date signup_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_login")
    private Date last_login;

    @Column(name = "is_admin")
    private boolean is_admin;
}
