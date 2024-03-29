package Mail;

import java.util.ArrayList;

/**
 * Creates an account and handles the emails
 * on this account.
 *
 * @author Melina Zikou
 *
 */
public class Account {
    private String username, password;
    private boolean isLogin = false;
    private ArrayList<Email> mailbox;
    private int emailId = 0;

    public Account (String username, String password){
        this.mailbox = new ArrayList<>();
        this.username = username;
        this.password = password;
    }

    public boolean getLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Email> getMailbox() {
        return mailbox;
    }

    /**
     * adds email to the mailbox
     * @param e email to be added to the mailbox
     */
    public void addEmail(Email e){
        String id = Integer.toString(++emailId);
        e.setId(id);
        mailbox.add(e);
    }

    /**
     * finds an email from the mailbox
     * @param id of the email
     * @return the email
     */
    public Email findEmail(String id){
        for (Email e : mailbox){
            if(e.getId().equals(id)){
                return e;
            }
        }
        return null;
    }

    /**
     * delete an email from the mailbox
     * @param id of the email
     */
    public void deleteEmail(String id){
        for (int i = 0; i < mailbox.size(); i++){
            if(mailbox.get(i).getId().equals(id)){
                mailbox.remove(i);
                break;
            }
        }
    }
}
