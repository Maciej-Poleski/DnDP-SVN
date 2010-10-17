package dndp.client.gui.card;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

import dndp.engine.card.skills.CharacterSkill;

/**
 * Klasa będąca widokiem jednej umiejętności postaci.
 * 
 * @author bambucha
 */
public class SkillView extends Composite implements Observer
{
    private Label name;
    private Label all;
    private Label rank;
    private Label bonus;
    private Label sig;

    public SkillView(Composite parent, int style,CharacterSkill skill)
    {
        super(parent, style);
        skill.addObserver(this);
        this.setLayout(new RowLayout());

        name = new Label(this, SWT.LEFT);
        all = new Label(this, SWT.CENTER);
        sig = new Label(this, SWT.CENTER);
        rank = new Label(this, SWT.CENTER);
        bonus = new Label(this, SWT.CENTER);

        name.setText(skill.getSkil().getName());
        sig.setText(" = ");
        rank.setText(skill.getRank().toString());
        bonus.setText(skill.getRank().toString());
        all.setText(String.valueOf(skill.getRank() + skill.getBonus()));
    }

    @Override
    public void update(Observable o, Object arg)
    {
        CharacterSkill source = (CharacterSkill)o;
        rank.setText(source.getRank().toString());
        bonus.setText(source.getRank().toString());
        all.setText(String.valueOf(source.getRank() + source.getBonus()));
    }
}
