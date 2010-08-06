package engine.item;

import engine.Character;
import engine.item.armor.Plate;
import engine.item.armor.Shield;

/**
 * Klasa dająca miejsce zaczepienia wszystkim przedmiotom noszącym przez postać.<br/>
 * Ogranicza również lość ich.
 * 
 * @par TODO Sposób dawania geterów i seterów. Getery-Setery z zmianą stanu.
 *      Sprawdzenie pisowni.
 * @author bambucha
 */
public class DnDEquipmentManager implements EquipmentManager
{
    private Item   helmet;    // głowa - obręcz , czapka , hełm lub relikwiarz
    private Item   glasses;   // oczy - soczewka lub okulary
    private Item   necklace;  // szyja - amulet , brosza , medalion, naszjnik, wisiorek lub skarabeusz
    private Item   shirt;     // tułw - kamizelaka, ornat lub koszulka
    private Plate  armor;     // tułw - zbroja, pancerz lub szata noszona na koszuli(itp.)
    private Item   belt;      // talia - pas noszony na zbroji(itp.)
    private Item   coat;      // ramiona- płaszcz , peleryna lub koszula noszona na zbroji(itp.)
    private Item   bracer;    // [ramiona|nadgarstki] - para branzolet lub karwaszy na szacie(itp.)
    private Item   gloves;    // dlonie- rękawiczka, para rękawiczek, rękawic
    private Item   ring;      // dłonie- po jednym pierścieniu na dłoń, lub dwa na jednej
    private Item   secondRing; // ^^
    private Item   shoes;     // stopy - para butów lub pantofli

    private Shield shield; // Tarcza dzierżona przez postać.
    
    private Inventory inventory; //Miejsce gdzie będzie się wsadzać plecaki i inne.

    /**
     * Standardowy konstuktor tworzący pustą postać, bez założonych itemów
     * 
     * @param owner
     *            Dowiązanie przedmiotów do postaci
     */
    public DnDEquipmentManager(Character owner)
    {
        this.helmet = null;
        this.glasses = null;
        this.necklace = null;
        this.shirt = null;
        this.armor = null;
        this.belt = null;
        this.coat = null;
        this.bracer = null;
        this.gloves = null;
        this.ring = null;
        this.secondRing = null;
        this.shoes = null;
    }
    
    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#putOn(engine.item.Item)
     */
    @Override
    public void putOn(Item what)
    {
        throw new UnsupportedOperationException("Brak implementacji");
    }
    
    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#getCurrentArmorPently()
     */
    @Override
    public Integer getCurrentArmorPently()
    {
        int temp = 0;
        if(armor != null)
            temp += armor.getArmorPenalty();
        if(shield != null)
            temp += shield.getArmorPenalty();
        return temp;
    }
    
    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#getCurrentArmorPently()
     */
    @Override
    public Integer getMaximumDexterityACBonus()
    {
        return armor.getMaxDexBonus();
    }
    
    @Override
    public void store(Item what)
    {
        inventory.add(what);
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#getArmor()
     */
    @Override
    public Plate getArmor()
    {
        return armor;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#setArmor(engine.item.armor.Plate)
     */
    @Override
    public void setArmor(Plate newArmor)
    {
        this.armor = newArmor;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#getHelmet()
     */
    @Override
    public Item getHelmet()
    {
        return helmet;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#setHelmet(engine.item.Item)
     */
    @Override
    public void setHelmet(Item helmet)
    {
        this.helmet = helmet;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#getGlasses()
     */
    @Override
    public Item getGlasses()
    {
        return glasses;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#setGlasses(engine.item.Item)
     */
    @Override
    public void setGlasses(Item glasses)
    {
        this.glasses = glasses;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#getNecklace()
     */
    @Override
    public Item getNecklace()
    {
        return necklace;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#setNecklace(engine.item.Item)
     */
    @Override
    public void setNecklace(Item necklace)
    {
        this.necklace = necklace;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#getShirt()
     */
    @Override
    public Item getShirt()
    {
        return shirt;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#setShirt(engine.item.Item)
     */
    @Override
    public void setShirt(Item shirt)
    {
        this.shirt = shirt;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#getBelt()
     */
    @Override
    public Item getBelt()
    {
        return belt;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#setBelt(engine.item.Item)
     */
    @Override
    public void setBelt(Item belt)
    {
        this.belt = belt;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#getCoat()
     */
    @Override
    public Item getCoat()
    {
        return coat;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#setCoat(engine.item.Item)
     */
    @Override
    public void setCoat(Item coat)
    {
        this.coat = coat;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#getBracer()
     */
    @Override
    public Item getBracer()
    {
        return bracer;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#setBracer(engine.item.Item)
     */
    @Override
    public void setBracer(Item bracer)
    {
        this.bracer = bracer;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#getGloves()
     */
    @Override
    public Item getGloves()
    {
        return gloves;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#setGloves(engine.item.Item)
     */
    @Override
    public void setGloves(Item gloves)
    {
        this.gloves = gloves;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#getRing()
     */
    @Override
    public Item getFirstRing()
    {
        return ring;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#setRing(engine.item.Item)
     */
    @Override
    public void setFirstRing(Item ring)
    {
        this.ring = ring;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#getSecondRing()
     */
    @Override
    public Item getSecondRing()
    {
        return secondRing;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#setSecondRing(engine.item.Item)
     */
    @Override
    public void setSecondRing(Item secondRing)
    {
        this.secondRing = secondRing;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#getShoes()
     */
    @Override
    public Item getShoes()
    {
        return shoes;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#setShoes(engine.item.Item)
     */
    @Override
    public void setShoes(Item shoes)
    {
        this.shoes = shoes;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#getShield()
     */
    @Override
    public Shield getShield()
    {
        return shield;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#setShield(engine.item.armor.Shield)
     */
    @Override
    public void setShield(Shield shield)
    {
        this.shield = shield;
    }

    /* (non-Javadoc)
     * @see engine.item.EquipmentManager#getMain()
     */
    @Override
    public Inventory getInventory()
    {
        return inventory;
    }
}
