package app.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "User")
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "pass", nullable = true)
    private String pass;

    @Column(name = "eloranking", nullable = false)
    private Integer eloranking;

    @Column(name = "wins", nullable = false)
    private Integer wins;

    @Column(name = "loses", nullable = false)
    private Integer loses;

    @Column(name = "isABot", nullable = false)
    private Integer isABot;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "idicone", // users.idicone
            referencedColumnName="idicone", // reficone.idicone
            foreignKey=@ForeignKey(name = "Fk_user_icone"), // FK créée dans users
            nullable=false,
            columnDefinition = "integer default 1")
    private Icone icone;

    @Column(name = "horodatage", nullable = true)
    private Date horodatage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getEloranking() {
        return eloranking;
    }

    public void setEloranking(Integer eloranking) {
        this.eloranking = eloranking;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLoses() {
        return loses;
    }

    public void setLoses(Integer loses) {
        this.loses = loses;
    }

    public Integer getIsABot() {
        return isABot;
    }

    public void setIsABot(Integer isABot) {
        this.isABot = isABot;
    }

    public Icone getIcone() {
        return icone;
    }

    public void setIcone(Icone icone) {
        this.icone = icone;
    }

    public Date getHorodatage() {
        return horodatage;
    }

    public void setHorodatage(Date horodatage) {
        this.horodatage = horodatage;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", login=" + login +
                ", wins=" + wins + ", loses=" + loses +
                ", eloranking=" + eloranking + ", icone=" + icone.getCodeIcone() + "]";
    }
}
