package engine.item;

/**
 * Klasae bazowa, dla wszystkich przedmiotów, które można umieścić w ekwipunku.
 * 
 * @author evil, bambucha
 */
public abstract class Item implements Carryable, Wearable
{
    private String           name;     // Na razie bez niczego
    private Double           weight;   // Waga przedmiotu
    private EquipmentManager menager;
    private Inventory        inventory; // Umiejscownie przedmiotu w ekwipunku
    private Value            value;    // wartość przedmiotu

    /**
     * Konstruktor dla klas potomnych. buduje przedmiot z klas potomnych.
     * 
     * @param name
     *            Nazwa przedmiotu
     * @param weight
     *            Waga przedmiotu
     * @param value
     *            Wartość rynkowa przedmiotu
     */
    public Item(String name, Double weight, Value value)
    {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    /**
     * Zwraca referencję do ekwipunku w którym jest trzymany przdmiot, lub null
     * przeciwnym przypadku.
     * 
     * @return [ekwiputnek|null]
     */
    public Inventory getInventory()
    {
        return inventory;
    }

    /**
     * Ustawia ekwipunek, nadrzędny konter przedmiotów.
     * 
     * @param inventory
     */
    public void setInventory(Inventory inventory)
    {
        this.inventory = inventory;
    }

    /**
     * Zwraca nazwę przedmiotu
     * 
     * @return Nazwa przedmiotu
     */
    public String getName()
    {
        return name;
    }

    /**
     * Zwraca menagera ekwipunku postaci posiadającej przedmiot.
     * 
     * @return Menadżer ekwipunku
     */
    public EquipmentManager getMenager()
    {
        if (menager == null && inventory != null)
            menager = inventory.getMenager();
        return menager;
    }

    /**
     * Ustawia menadżera ekwipunku.
     * 
     * @param menager
     *            Menadżer ekwipunku.
     */
    public void setMenager(EquipmentManager menager)
    {
        this.menager = menager;
    }

    /**
     * Zwraca wagę przedmiotu
     * 
     * @return Waga przedmiotu
     */
    public Double getWeight()
    {
        return weight;
    }

    /**
     * Ustawia wagę przedmiotu
     * 
     * @param weight
     *            Nowa waga przedmiotu
     * @exception IllegalArgumentException
     *                weight &lt 0
     */
    public void setWeight(Double weight)
    {
        if (weight < 0)
            throw new IllegalArgumentException("Ujemna waga(weight < 0)");
        this.weight = weight;
    }

    /**
     * Zwraca warotść przedmiotu
     * 
     * @return Wartość przedmiotu
     */
    public Value getValue()
    {
        return value;
    }

    /**
     * Ustawia warotść przedmiotu
     * 
     * @param value
     */
    public void setValue(Value value)
    {
        if (value == null)
            throw new NullPointerException("Nie może być null");
        this.value = value;
    }

    /**
     * Zwraca nazwę przedmiotu.<br/>
     * Bez znaku nowej lini na końcu
     * 
     * @return Nazwa przedmiotu
     */
    @Override
    public String toString()
    {
        return name + ' ' + weight + ' ' + value;
    }

    @Override
    public void leaveBehind()
    {
        menager = null;
        inventory = null;
    }
    
    @Override
    public void pickUp(EquipmentManager picker)
    {
        menager = picker;
    }

}
