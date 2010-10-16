package dndp.client.gui.chat;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.*;

/**
 *
 * 
 * @author bambucha
 */
public class ChatStartDialog extends Dialog
{
    private final Label nickName;
    private final Text nickField;
    private final Button OKButton;
    private ChatStartDialog self;
    
    public ChatStartDialog(Shell parent)
    {
        super(parent);
        self = this;
        
        nickName = new Label(parent, SWT.CENTER);
        nickName.setSize(new Point(70, 70));
        nickName.setText("Nick");
        
        
        nickField = new Text(parent, SWT.SINGLE);
        OKButton = new Button(parent, SWT.PUSH);
        
        
        nickField.addKeyListener(new KeyListener()
        {
            
            @Override
            public void keyReleased(KeyEvent e)
            {    }
            
            @Override
            public void keyPressed(KeyEvent e)
            {
                if(e.keyCode == SWT.LF && valindateNickName())
                
                    self.setText(nickField.getText());
            }
        });
        
        OKButton.addListener(SWT.Selection, new Listener(){

            @Override
            public void handleEvent(Event event)
            {
                self.setText(nickField.getText());
            }
            
        });
        
    }
    
    private boolean valindateNickName()
    {
        if(nickField.getText().matches("a-zA-Z"))
                return true;
        return false;
    }
    
    
}
