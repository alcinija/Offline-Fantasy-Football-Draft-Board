import javax.swing.WindowConstants;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DraftSetupPage dsp =  new DraftSetupPage();
		dsp.setSize(500, 300);
		dsp.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		dsp.setVisible(true);
	}

}
