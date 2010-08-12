package engine.card.armor;

/**
 * Interfejs obsługi pancerza
 * @par TODO Javadoc
 * @author bambucha
 */
public interface Armor
{
    /**
     * Zwraca Klasę Pancerza (KP) względem ataków dotykowych.
     * @return Klasa pancerza
     */
    public Integer getFlatFootetAC();

    /**
     * Zwraca Klasę Pancerza (KP) gdy postać jest pozbawiona premi ze zręczności.
     * @return
     */
    public Integer getTouchAttaksAC();

    /**
     * Zwraca standardową Klasę Pancerza (KP)
     * @return
     */
    public Integer getAC();

}
