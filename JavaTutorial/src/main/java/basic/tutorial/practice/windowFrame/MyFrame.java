package basic.tutorial.practice.windowFrame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {
	Button myButton;
	TextArea myTextArea;
	int count;

	public MyFrame(String title) {
		super(title);
		myButton = new Button("click me");
		myTextArea = new TextArea();
		add(myButton, BorderLayout.CENTER);
		add(myTextArea, BorderLayout.NORTH);
		ButtonListener bList = new ButtonListener();
		myButton.addActionListener(bList);
	}

	class ButtonListener implements ActionListener { // 这里定义了一个内部类
		public void actionPerformed(ActionEvent e) {
			count++;
			myTextArea.setText("button clicked " + count + " times");
		}
	} // end of innerclass ButtonListener

	public void closeWindow(MyFrame f) {
		f.addWindowListener(new WindowAdapter() // 为了关闭窗口
		{
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	public static void main(String args[]) {
		MyFrame f = new MyFrame("Inner Class Frame");
		// f.closeWindow(f);
		f.setSize(300, 300);
		f.setVisible(true);
		f.closeWindow(f);

	}
}
