package engine.item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import engine.benefit.Benefit;

/**
 * Ekwipunek. Dla pełnego hardcoru implementuje Iterable dla foreach<br/>
 * Oddelegowanie metod <code>listOfItems</code> w celu wytworzenia kontenerowego API.
 * 
 * @author evil, bambucha
 */
public class Inventory extends Item implements Iterable<Item>
{
    private Collection<Item> listOfItems = new ArrayList<Item>();

    /**
     * @see engine.item.Item
     */
    public Inventory(String name, Double weight, Value value, Benefit[] benefits)
    {
        super(name, weight, value, benefits);
    }

    /**
     * @see java.util.List
     */
    public Object[] toArray()
    {
        return listOfItems.toArray();
    }

    /**
     * @see java.util.List
     */
    public int size()
    {
        return listOfItems.size();
    }

    /**
     * @see java.util.List
     */
    public boolean remove(Item o)
    {
        if (listOfItems.remove(o))
        {
            setWeight(getWeight() - o.getWeight());
            setValue(Value.subtract(getValue(), o.getValue()));
            return true;
        }
        else
            return false;
    }

    /**
     * @see java.lang.Iterable
     */
    @Override
    public Iterator<Item> iterator()
    {
        return listOfItems.iterator();
    }

    /**
     * @see java.util.List
     */
    public boolean isEmpty()
    {
        return listOfItems.isEmpty();
    }

    /**
     * @see java.util.List
     */
    public boolean contains(Item o)
    {
        return listOfItems.contains(o);
    }

    /**
     * @see java.util.List
     */
    public boolean add(Item e)
    {
        if (listOfItems.add(e))
        {
            setWeight(getWeight() + e.getWeight());
            setValue(Value.add(e.getValue(), getValue()));
            return true;
        }
        else
            return false;
    }

    @Override
    public void putOn()
    {

    }

    @Override
    public void takeOff()
    {

    }

}
