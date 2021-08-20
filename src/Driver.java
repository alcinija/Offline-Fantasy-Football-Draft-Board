import javax.swing.WindowConstants;

/**
 * Name: Joe Alcini
 * File: Driver.java
 * Date: 8/05/2021
 * Current Version: 1.0.0 Original Release
 * Description: Starts running the application on execution
 */
public class Driver {
	// Main method
	public static void main(String[] args) {
		// Loads the setup page		
		DraftSetupPage dsp =  new DraftSetupPage();
		dsp.setSize(500, 300);
		dsp.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		dsp.setVisible(true);
	}

}
