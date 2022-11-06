package week8_TranKhacLinh_200140121.stocktrader.repositories;

import java.util.ArrayList;

import week8_TranKhacLinh_200140121.stocktrader.entities.User;

public class UserListRepository {
    private ArrayList<User> users;

    public ArrayList<User> getUserList() {
        return users;
    }

    public boolean StoreUserList() {
        if (users.isEmpty() || users == null)
            return false;
        return true;
    }
}
