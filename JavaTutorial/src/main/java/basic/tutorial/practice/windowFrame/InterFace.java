package basic.tutorial.practice.windowFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterFace extends JFrame implements ActionListener {

	// public JFrame f;
	public JButton but1;
	public JTextArea text;
	public JScrollPane jsp;
	int count;

	public InterFace(String title) {

		but1 = new JButton("点击");
		text = new JTextArea();
		jsp = new JScrollPane(text);

		// jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		text.setLineWrap(true);
		add(but1, BorderLayout.SOUTH);
		add(jsp, BorderLayout.CENTER);

		but1.addActionListener(this);
		
		// ButtonListener blist = new ButtonListener();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		String content = text.getText();
		text.setText(content + "点击了" + count + "次,");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InterFace inter = new InterFace("测试界面");
		inter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inter.setSize(500, 500);
		inter.setVisible(true);

	}

}
