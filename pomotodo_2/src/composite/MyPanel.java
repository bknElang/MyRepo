package composite;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPanel extends MyComponent {
	Vector<MyComponent> children;
	
	public MyPanel(JFrame _frame, int _level, MyComponent _parent) {
		// TODO Auto-generated constructor stub
		super(_frame, _level, _parent);
		children = new Vector<>();
	}
	
	public void addChild(MyComponent component) {
		children.add(component);
	}
	
	public void remove(MyComponent component) {
		children.remove(component);
	}
	
	public Vector<MyComponent> getChildren() {
		return children;
	}
	
	protected void btnAddClick() {
		remove(btnAdd);
		
		add(btnStart);
		add(btnDone);
		add(btnRemove);
		
		remove(blankSpace);
		blankSpace = setBlankSpace();
		add(blankSpace, 1);
		
		yourTextField.setEditable(false);
		
		// insert component to specified index
		Component[] components = getParent().getComponents();
		for(int i=0; i<components.length; i++) {
			Component c = components[i];
			if(c == this) {
				MyComponent panel;
				if(level == 2) { // new leaf
					panel = new MyLeaf(frame, this);
				} else { // new composite
					panel = new MyPanel(frame, level+1, this);
				}
				addChild(panel);
				frame.add(panel, i+1);
				
				MyComponent newPanel = new MyPanel(frame, level, parent);
				if(level != 1) {
					((MyPanel)parent).addChild(newPanel);
				}
				frame.add(newPanel, i+2);
				frame.revalidate();
				return;
			}
		}
	}

	@Override
	protected void btnStartClick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void btnDoneClick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void btnRemoveClick() {
		// TODO Auto-generated method stub
		if(parent != null) {
			((MyPanel)parent).children.remove(this);
		}
		
//		for(MyComponent p: children) {
////			p.btnRemoveClick();
//			if(p instanceof MyPanel) {
//				((MyPanel)p).emptyChild();
//			}
//		}
//		emptyChild();
//		children.removeAllElements();
		
		removeAllChildren();
		
		frame.revalidate();
	}

	@Override
	protected void removeAllChildren() {
		// TODO Auto-generated method stub
		for(MyComponent p: children) {
			p.removeAllChildren();
		}
		
		this.children.removeAllElements();
		frame.remove(this);
	}
}
