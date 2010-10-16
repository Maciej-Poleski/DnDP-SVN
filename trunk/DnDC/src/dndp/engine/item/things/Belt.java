package dndp.engine.item.things;

import dndp.engine.benefit.Benefit;
import dndp.engine.item.Item;
import dndp.engine.item.Value;

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
        if(getParent() != null)
            getParent().remove(this);
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
