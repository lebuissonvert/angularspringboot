package app.DTO;

import app.entity.User;

import java.io.Serializable;
import java.util.Date;

public class UserDTO implements Serializable {

    private Integer id;
    private String login;
    private String pass;
    private Integer eloranking;
    private Integer wins;
    private Integer loses;
    private Integer isABot;
    private IconeDTO icone;
    private Date horodatage;

    private UserDTO(){}

    public UserDTO(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.pass = user.getPass();
        this.eloranking = user.getEloranking();
        this.wins = user.getWins();
        this.loses = user.getLoses();
        this.isABot = user.getIsABot();
        this.icone = new IconeDTO(user.getIcone());
        this.horodatage = user.getHorodatage();
    }

    public User toUser() {
        User resultat = new User();
        resultat.setId(id);
        resultat.setLogin(login);
        resultat.setPass(pass);
        resultat.setEloranking(eloranking);
        resultat.setWins(wins);
        resultat.setLoses(loses);
        resultat.setIsABot(isABot);
        resultat.setIcone(icone.toIcone());
        resultat.setHorodatage(horodatage);
        return resultat;
    }

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

    public IconeDTO getIcone() {
        return icone;
    }

    public void setIcone(IconeDTO icone) {
        this.icone = icone;
    }

    public Date getHorodatage() {
        return horodatage;
    }

    public void setHorodatage(Date horodatage) {
        this.horodatage = horodatage;
    }
}
