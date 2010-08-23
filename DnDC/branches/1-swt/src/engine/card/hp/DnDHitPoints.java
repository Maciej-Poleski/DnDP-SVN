package engine.card.hp;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Klasa obsługująca punkty życia i inne zdażenia.
 * 
 * @author bambucha
 */
public class DnDHitPoints implements HitPoints
{
    private Integer        maxHP;
    private Integer        HP;
    private ChangeListener view;

    public DnDHitPoints(ChangeListener view)
    {
        this.view = view;
    }

    @Override
    public Integer getHP()
    {
        return HP;
    }

    @Override
    public void setHP(Integer HP)
    {
        this.HP = HP;
        view.stateChanged(new ChangeEvent(this));
    }

    @Override
    public Integer getMaxHP()
    {
        return maxHP;
    }

    @Override
    public void setMaxHP(Integer maxHP)
    {
        if (maxHP < 0)
            throw new IllegalArgumentException("Max HP < 0");
        this.maxHP = maxHP;
        view.stateChanged(new ChangeEvent(this));
    }
}
