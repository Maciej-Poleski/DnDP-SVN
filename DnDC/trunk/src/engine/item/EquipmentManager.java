package engine.item;

import engine.item.armor.Plate;
import engine.item.armor.Shield;

/**
 * Interfejs powiększony na potrzeby ekwipunku.
 * Rozszerza {@link BasicEquipmentManager} o funkcje potrzebne itemom podczas montowania się w {@link DnDEquipmentManager}.
 *
 * 
 * @author bambucha
 */
public interface EquipmentManager extends BasicEquipmentManager
{

    /**
     * Zwraca aktualną zbroję postaci Możliwość zmian
     * 
     * @return Zbroja
     */
    public abstract Plate getArmor();

    /**
     * Ustawia nową zbroję
     * 
     * @param newArmor
     */
    public abstract void setArmor(Plate newArmor);

    /**
     * Zwraca przedmiot będący na głowie postaci.
     * @return Przedmiot na głowie.
     */
    public abstract Item getHelmet();

    /**
     * Ustawia przedmiot na głowie postaci.
     * @param helmet Nowy "hełm" postaci.
     */
    public abstract void setHelmet(Item helmet);

    /**
     * Zwraca przedmiot, który jest obecnie okularami postaci. 
     * @return Okulary
     */
    public abstract Item getGlasses();

    /**
     * Ustawia nowe okulary postaci
     * @param glasses Nowe okulary postaci.
     */
    public abstract void setGlasses(Item glasses);

    /**
     * Zwraca przedmiot będący na szyji postaci.
     * @return Przedmiot na szyji.
     */
    public abstract Item getNecklace();

    /**
     * Ustawia nowy przedmiot na szyji postaci.
     * @param necklace Nowy przedmiot na szyję.
     */
    public abstract void setNecklace(Item necklace);

    /**
     * Zwraca przedmiot będący koszulą postaci.
     * @return Koszula postaci.
     */
    public abstract Item getShirt();

    /**
     * Ustawia nową koszulę postaci.
     * @param shirt Nowa koszula.
     */
    public abstract void setShirt(Item shirt);

    /**
     * Zwraca przedmiot będący pasem postaci.
     * @return Pas postaci.
     */
    public abstract Item getBelt();

    /**
     * Ustwawia przedmiot jako nowy pas postaci.
     * @param belt
     */
    public abstract void setBelt(Item belt);

    /**
     * Zwraca przedmiot będący płaszczem postaci.
     * @return Płasz postaci.
     */
    public abstract Item getCoat();

    /**
     * Ustwia przedmiot jako nowu płaszcz postaci.
     * @param coat Nowy płasz postaci.
     */
    public abstract void setCoat(Item coat);

    /**
     * Zwraca przedmiot będący karwaszami postaci.
     * @return Karwasz postaci.
     */
    public abstract Item getBracer();

    /**
     * Ustawia przedmiot będący nowym karwaszem postaci. 
     * @param bracer Nowe karwasze postaci.
     */
    public abstract void setBracer(Item bracer);

    /**
     * Zwraca rękawiczki postaci.
     * @return Rekawiczki.
     */
    public abstract Item getGloves();

    /**
     * Ustawia nowe rękawiczki postaci.
     * @param gloves Nowe rękawiczki.
     */
    public abstract void setGloves(Item gloves);

    /**
     * Zwraca pierwszy pierścień noszony przez postać.
     * @return Pierścień.
     */
    public abstract Item getFirstRing();

    /**
     * Ustwia pierwszy pierścień noszony przez postać.
     * @param ring Postać.
     */
    public abstract void setFirstRing(Item ring);

    /**
     * Zwrtaca drugi pierścień noszony przez postać.
     * @return Pierścień.
     */
    public abstract Item getSecondRing();

    /**
     * Ustawia nowy drugi pierścień noszony przez postać.
     * @param secondRing Nowy pierścień
     */
    public abstract void setSecondRing(Item secondRing);

    /**
     * Zwraca przedmiot będący butami postaci.
     * @return Buty postaci.
     */
    public abstract Item getShoes();

    /**
     * Ustawia nowe buty dla postaci.
     * @param shoes Nowe buty.
     */
    public abstract void setShoes(Item shoes);

    /**
     * Zwraca tarczę aktualnie dzierżoną przez postać.
     * @return Tarcza
     */
    public abstract Shield getShield();

    /**
     * Ustawia tarczę postaci.
     * @param shield Nowa tarcza.
     */
    public abstract void setShield(Shield shield);

    /**
     * Zwraca ekwipunek postaci.
     * Tu zawierają się plecaki, pasy na eliksyry i inne.
     * @return Cały ekwipunke postaci.
     */
    public abstract Inventory getInventory();
}
