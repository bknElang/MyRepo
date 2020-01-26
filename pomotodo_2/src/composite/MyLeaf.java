package composite;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyLeaf extends MyComponent {
	
	public MyLeaf(JFrame _frame, MyComponent _parent) {
		super(_frame, 3, _parent);
	}

	@Override
	protected void btnAddClick() {
		// TODO Auto-generated method stub		
		remove(btnAdd);
		
		add(btnStart);
		add(btnDone);
		add(btnRemove);
		
		remove(blankSpace);
		blankSpace = setBlankSpace();
		add(blankSpace, 1);
		
		yourTextField.setEditable(false);
		
		Component[] components = getParent().getComponents();
		for(int i=0; i<components.length; i++) {
			Component c = components[i];
			if(c == this) {
				MyComponent panel = new MyLeaf(frame, parent);
				((MyPanel)parent).addChild(panel);
				frame.add(panel, i+1);
				frame.revalidate();
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
		frame.remove(this);
		((MyPanel)parent).children.remove(this);
		frame.revalidate();
	}

	@Override
	protected void removeAllChildren() {
		// TODO Auto-generated method stub
		frame.remove(this);
	}
	
}
