package app.utils;

import app.entity.Icone;
import app.entity.User;
import app.repository.IconeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserHelper {
    private static UserHelper INSTANCE = null;

    @Autowired
    private IconeRepository iconeRepository;

    private UserHelper(){}

    public static UserHelper getInstance() {
        if(INSTANCE == null)
            INSTANCE = new UserHelper();
        return INSTANCE;
    }

    public User generateUser(String p_login) {
        User user = new User();
        user.setLogin(p_login);
        user.setPass("fake_user");
        user.setEloranking(1500);

        // Au choix : les 2 marchent, le 2eme plus propre mais plus lent
        user.setIcone(new Icone());
        //user.setIcone(iconeRepository.findByCodeIcone("NONE"));

        user.setIsABot(0);
        user.setLoses(0);
        user.setWins(0);
        return user;
    }

    public String getConcatenatedFieldsForInsertion(User p_user) {
        return p_user.getId() + ", '" + p_user.getLogin() + "', '" + p_user.getPass() + "', " +
                p_user.getEloranking() + ", " + p_user.getWins() + ", " + p_user.getLoses() + ", " +
                p_user.getIsABot() + ", " + p_user.getIcone().getIdicone() + ", null";
    }
}
