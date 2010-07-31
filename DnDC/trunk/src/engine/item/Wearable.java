package engine.item;

/**
 * Interfejs implementowany przez przedmioty, które można nosić. Odpowiednie
 * metody są wywoływane podczas wydarzeń na przedmiocie.
 * 
 * @author bambucha
 */
public interface Wearable
{
    /**
     * Określa zmianny postaci oraz wydarzenia generowane podczas ubierania
     * przedmiotu Np zwiększenie siły podczas ubrania pasu siły olbrzyma.
     * 
     * @return Czy się udało
     */
    public Boolean putOn();

    /**
     * Aalogicznie do <code>putOn</code> tylko podczas ściągania zbroi,
     * cudownych przedmiotów.
     * 
     * @return Czy się udało.
     */
    public Boolean takeOff();
}
