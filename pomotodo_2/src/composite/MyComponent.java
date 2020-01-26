package composite;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class MyComponent extends JPanel {
//	void execute();
	protected JFrame frame;
	protected MyComponent parent;
	protected int level;
	
	protected JTextField yourTextField;
	
	protected JButton btnAdd = new JButton("Add");
	protected JButton btnStart = new JButton("Start");
	protected JButton btnDone = new JButton("Done");
	protected JButton btnRemove = new JButton("Remove");
	
	protected Component blankSpace;
	
	public MyComponent(JFrame _frame, int _level, MyComponent _parent) {
		// TODO Auto-generated constructor stub
		frame = _frame;
		level = _level;
		parent = _parent;
		
		setPreferredSize(new Dimension(750, 35));
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		yourTextField = new JTextField();
		yourTextField.setPreferredSize(new Dimension(300, 30));
		add(yourTextField);
		
		blankSpace = setBlankSpace();
		add(blankSpace);
		add(btnAdd);
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnAddClick();
			}
		});
		
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnStartClick();
			}
		});
		
		btnDone.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnDoneClick();
			}
		});
		
		btnRemove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnRemoveClick();
			}
		});
	}
	
//	protected abstract void execute();
	protected abstract void btnAddClick();
	protected abstract void btnStartClick();
	protected abstract void btnDoneClick();
	protected abstract void btnRemoveClick();
	protected abstract void removeAllChildren();
	
	protected Component setBlankSpace() {
		Component[] components = getComponents();
		
		int drawLevel = level;
		
		for(Component c: components) {
			if(c == btnStart) {
				return Box.createHorizontalStrut(150+46 - (30 * (level-1)));
			}
		}
		return Box.createHorizontalStrut(354 - (30 * (level-1)));
	}
}
