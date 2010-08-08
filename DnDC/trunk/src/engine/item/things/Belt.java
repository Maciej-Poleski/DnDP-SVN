package engine.item.things;

import engine.benefit.Benefit;
import engine.item.Item;
import engine.item.Value;

/**
 * Klasa opisująca wszelkiej maści pasy i inne przepaski na zbroje.
 * 
 * @author bambucha
 */
public class Belt extends Item
{

    public Belt(String name, Double weight, Value value, Benefit[] benefits)
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
        if(getManager().getBelt() != null)
            getManager().getBelt().takeOff();
        getManager().applyItemBenefits(this);
        getManager().setBelt(this);
    }

    /*
     * (non-Javadoc)
     * @see engine.item.Wearable#takeOff()
     */
    @Override
    public void takeOff()
    {
        if(getManager().getBelt() != this)
            return;
        getManager().abbandoItemBenefits(this);
        getManager().setBelt(null);
    }

}
