//package com.almondcoffee.test;
//
//import com.almondcoffee.AngryBirds;
//import com.almondcoffee.screens.MainMenuScreen;
//import com.almondcoffee.screens.SplashScreen;
//import org.junit.Test;
//import java.io.IOException;
//import static org.junit.Assert.fail;
//
//public class setScreens {
//
//    @Test
//    public void test1() throws IOException {
//        AngryBirds game = new AngryBirds();
//        try{
//            game.setScreen(new SplashScreen(game));
//        }
//        catch (Exception e) {
//            fail(e.getMessage());
//        }
//    }
//
//    @Test
//    public void test2() throws IOException {
//        AngryBirds game = new AngryBirds();
//        try{
//            game.setScreen(new MainMenuScreen(game));
//        }
//        catch (Exception e) {
//            fail(e.getMessage());
//        }
//    }
//}
