package engine.item.things;

import engine.benefit.Benefit;
import engine.item.Item;
import engine.item.Value;

/**
 * 
 * 
 * @author bambucha
 */
public class Gloves extends Item
{

    public Gloves(String name, Double weight, Value value, Benefit[] benefits)
    {
        super(name, weight, value, benefits);
    }

    /*
     * (non-Javadoc)
     * @see engine.item.Wearable#putOn()
     */
    @Override
    public void putOn()
    {
        if(getManager().getGloves() != null)
            getManager().getGloves().takeOff();
        getManager().applyItemBenefits(this);
        getManager().setGloves(this);

    }

    /*
     * (non-Javadoc)
     * @see engine.item.Wearable#takeOff()
     */
    @Override
    public void takeOff()
    {
        if(getManager().getGloves() != this)
            return;
        getManager().abbandoItemBenefits(this);
        getManager().setGloves(null);

    }

}
