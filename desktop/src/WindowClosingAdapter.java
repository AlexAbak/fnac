import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Window;

public class WindowClosingAdapter extends WindowAdapter {
	
	public void windowClosing(WindowEvent e) {
		((Window)e.getSource()).dispose();
	}

}
