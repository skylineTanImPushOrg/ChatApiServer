package model;

/**
 * Created by timeloveboy on 17-3-1.
 */
public class User {
    public Integer getUid() {
        return Uid;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    Integer Uid;
    String NickName;

    public User(Integer uid) {
        Uid = uid;
    }

    public static boolean CanRegiste(Integer uid) {
        return true;
    }

    public static void Registe(User u, String pwd) {

    }

    public boolean Login(String password) {
        return true;
    }
}
