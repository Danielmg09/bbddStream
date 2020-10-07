package com.tecnara.empresa;

import com.tecnara.empresa.dao.DAO;
import com.tecnara.empresa.service.UserService;
import com.tecnara.empresa.view.Menu;

public class Main {
    public static void main(String[] args) {
        DAO dao = new DAO();
        UserService userService = new UserService();
        Menu menu = new Menu();
        menu.mayorSalario();

    }
}
