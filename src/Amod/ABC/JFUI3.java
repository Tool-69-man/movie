package Amod.ABC;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.utils.Platform;
import org.jb2011.swing9patch.popup.CoolPopupFactory;

import javax.swing.*;

public class JFUI3 {

        public static void initUserInterface() {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty(
                    "com.apple.mrj.application.apple.menu.about.name",
                    "Draw 9-patch");

            try {
                if(Platform.isWindows())
                {
                    UIManager.put("RootPane.setupButtonVisible", false);
                    BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
                    BeautyEyeLNFHelper.launchBeautyEyeLNF();

                    // impl a demo PopupFactory
                    PopupFactory.setSharedInstance(new CoolPopupFactory());
                }
                else
                    UIManager.setLookAndFeel(UIManager
                            .getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void main(final String... args) {
            new JFUI3();
        }

        public JFUI3(){
            initUserInterface();



//
//            MyFrameABC frame = new MyFrameABC();
//            frame.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
//            frame.setLocationRelativeTo(null);
//            frame.setVisible(true);
//
////				FixtipPane fp = new FixtipPane();
////				fp.show(frame, frame.getJMenuBar(),0,10);
//

                }




    }//类

//皮肤
//tbs.add(new org.jb2011.swing9patch.popup.Demo(), "Cool tooltip");
//        tbs.add(new org.jb2011.swing9patch.fixtip.Demo(), "Cool fix tip");
//        tbs.add(new org.jb2011.swing9patch.photoframe.Demo(), "Photo frame");
//        tbs.add(new org.jb2011.swing9patch.toast.Demo(), "Toast");
//