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
public class CharacterInventory extends Item
{
    private Item   helmet;    // głowa - obręcz , czapka , hełm lub relikwiarz
    private Item   glasses;   // oczy - soczewka lub okulary
    private Item   necklace;  // szyja - amulet , brosza , medalion, naszjnik,
                               // wisiorek lub skarabeusz
    private Item   shirt;     // tułw - kamizelaka, ornat lub koszulka
    private Plate  armor;     // tułw - zbroja, pancerz lub szata noszona na
                               // koszuli(itp.)
    private Item   belt;      // talia - pas noszony na zbroji(itp.)
    private Item   coat;      // ramiona- płaszcz , peleryna lub koszula
                               // noszona na
                               // zbroji(itp.)
    private Item   bracer;    // [ramiona|nadgarstki] - para branzolet lub
                               // karwaszy
                               // na szacie(itp.)
    private Item   gloves;    // dlonie- rękawiczka, para rękawiczek, rękawic
    private Item   ring;      // dłonie- po jednym pierścieniu na dłoń, lub dwa
                               // na
                               // jednej
    private Item   secondRing; // ^^
    private Item   shoes;     // stopy - para butów lub pantofli

    private Shield shield;

    /**
     * Standardowy konstuktor tworzący pustą postać, bez założonych itemów
     * 
     * @param owner
     *            Dowiązanie przedmiotów do postaci
     */
    public CharacterInventory(Character owner)
    {
        super(owner.getName() + " inventory", 0.0, new Value(0, 0, 0, 0));
        setOwner(owner);
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

    /**
     * Zwraca aktualną zbroję postaci Możliwość zmian
     * 
     * @return Zbroja
     */
    public Plate getArmor()
    {
        return armor;
    }

    /**
     * Ustawia nową zbroję
     * 
     * @param newArmor
     */
    public void setArmor(Plate newArmor)
    {
        this.armor = newArmor;
    }

    /**
     * Zwraca obecnie założoną tarczę
     * 
     * @return Tarcza
     */
    public Shield getShield()
    {
        return shield;
    }

    /**
     * Ustawia nową tarczę
     * 
     * @param shield Nowa tarcza
     */
    public void setShield(Shield shield)
    {
        this.shield = shield;
    }

}
