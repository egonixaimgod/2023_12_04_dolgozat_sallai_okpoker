/*
* File: MainController.java
* Author: Bodnár Bence
* Copyright: 2023, Bodnár Bence 
* Date: 2023-12-04
* Licenc: MIT
*
*/

import controllers.MainController;import views.MainWindow;
public class App { public static void main(String[] args)
throws Exception { MainWindow mainWindow = new MainWindow();
new MainController(mainWindow); mainWindow.setVisible(true);
}}
