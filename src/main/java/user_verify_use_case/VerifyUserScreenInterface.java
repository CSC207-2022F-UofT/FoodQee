package user_verify_use_case;

/*
  interface of the screen
 */

import org.bson.types.ObjectId;

import javax.swing.*;

public interface VerifyUserScreenInterface {
    JFrame getFrame();
    void showUserHomepage(ObjectId userId);
    void close();
    void showMessage(String message);
}
