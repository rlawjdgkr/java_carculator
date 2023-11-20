package homework;

import javax.script.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;
public class weq extends JFrame implements TextListener, ActionListener, WindowListener{
	String nO[] = {"*", "-", "+","C","=", "/"};
	String nS[] = {"7","8","9", "4","5","6", "1", "2", "3", "0"};
	//	public void start() {
	////		{"7","8","9","*","4","5","6","-","1", "2", "3","+","C", "0", 
	////			 "=", "/"};
	//		
	//	}
	JButton nB[] = new JButton[16];
	JPanel p,pn,pc;
	JTextField tf1;
	JTextField tf2;
	JLabel op;
	JLabel eq;
	JLabel re;
	private int m = 0;
	String result1,result2;

	public weq() {
		super("사칙계산기");
		Container cPane = getContentPane();
		cPane.setLayout(new BorderLayout());

		p = new JPanel(); //  플로우 위에 연산표시
		pc = new JPanel(); // 중앙 보드
		pn = new JPanel(); // 보드 안 그리드 

		p.setLayout(new FlowLayout());
		pc.setLayout(new BorderLayout());

		tf1 = new JTextField(8);
		tf2 = new JTextField(8);
		Font bigFont = tf1.getFont().deriveFont(Font.PLAIN, 17f);
		Font bigFont1 = tf2.getFont().deriveFont(Font.PLAIN, 17f);
		tf1.setFont(bigFont);
		tf2.setFont(bigFont1);

		op = new JLabel("연산");
		eq = new JLabel("=");
		re = new JLabel("결과");

		p.add(tf1);
		tf1.addActionListener(this);
		p.add(op);
		p.add(tf2);
		tf2.addActionListener(this);
		p.add(eq);
		p.add(re);

		pn.setLayout(new GridLayout(4,4,4,4));
		nB[0] = new JButton(nS[0]);
		nB[1] = new JButton(nS[1]);
		nB[2] = new JButton(nS[2]);
		nB[3] = new JButton(nO[0]);
		nB[4] = new JButton(nS[3]);
		nB[5] = new JButton(nS[4]);
		nB[6] = new JButton(nS[5]);
		nB[7] = new JButton(nO[1]);
		nB[8] = new JButton(nS[6]);
		nB[9] = new JButton(nS[7]);
		nB[10] = new JButton(nS[8]);
		nB[11] = new JButton(nO[2]);
		nB[12] = new JButton(nO[3]);
		nB[13] = new JButton(nS[9]);
		nB[14] = new JButton(nO[4]);
		nB[15] = new JButton(nO[5]);
		for(int i=0;i<nB.length;i++) {
			nB[i].setForeground(Color.black);
			pn.add(nB[i]);
		}

		for(int i=0;i<nB.length;i++) {
			nB[i].addActionListener(this);

		}

		pc.add(pn, BorderLayout.CENTER);
		cPane.add(p, BorderLayout.NORTH);
		cPane.add(pc, BorderLayout.CENTER);

		setSize(350,400);
		setVisible(true);

		addWindowListener(this); // x 종료
	}


	public static void main(String[] args) {
		new weq();
	}

	public void actionPerformed(ActionEvent e) {

		String oper = e.getActionCommand();
		if(oper.equals("C")){
			tf1.setText("");
			op.setText("연산");
			tf2.setText("");
			re.setText("결과");
			result1 = "";
			result2 = "";
			m = 0;
			tf1.requestFocus();
		}
		else if(oper.equals("=")) {
			// 연산결과 출력
			if(op.getText().equals("+")) {
				re.setText(String.valueOf(Integer.parseInt(result1) + Integer.parseInt(result2)));
			}
			else if(op.getText().equals("-")) {
				re.setText(String.valueOf(Integer.parseInt(result1) - Integer.parseInt(result2)));
			}
			else if(op.getText().equals("*")) {
				re.setText(String.valueOf(Integer.parseInt(result1) * Integer.parseInt(result2)));
			}
			else if(op.getText().equals("/")) {
				re.setText(String.valueOf(Double.parseDouble(result1) / Double.parseDouble(result2)));
			}

		}
		else if(oper.equals("+") || oper.equals("-") || oper.equals("*") || oper.equals("/")) {
			op.setText(oper);
			tf2.requestFocus();
			m = 1;
		}
		else {
			if(m == 0) {
				tf1.setText(tf1.getText() + e.getActionCommand());
				result1 = tf1.getText();
			}
			else if(m == 1) {
				tf2.setText(tf2.getText() + e.getActionCommand());
				result2 = tf2.getText();
			}
		}
	}
	public void textValueChanged(TextEvent e) {}
	public void windowOpened(WindowEvent e) {}
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	public void windowClosed(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}



}