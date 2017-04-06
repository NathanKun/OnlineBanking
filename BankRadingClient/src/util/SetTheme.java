package util;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

/**
 * Set theme for form
 * 
 * @author Junyang HE
 *
 */
public class SetTheme {

	/**
	 * set theme to Metal Ocean
	 */
	public static void setMetal(){
        try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
            UIManager.setLookAndFeel(new MetalLookAndFeel()); 
            JFrame.setDefaultLookAndFeelDecorated(true);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * set theme to Nimbus
	 */
	public static void setNimbus(){
        try {
        	//recommended way to set Nimbus LaF because old versions of Java 6
            //don't have it included
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
               if ("Nimbus".equals(info.getName())) {
                   UIManager.setLookAndFeel(info.getClassName());
                   break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
	}
}
