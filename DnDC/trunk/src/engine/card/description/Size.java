package engine.card.description;

/**
 * Enum rozmiarów. Dodatkowo zawarte modyfikatory z rozmiaru.
 * Ustawione w kolejności rosnącego rozmiaru
 * FINE == Filigranowy
 * @author bambucha
 */
public enum Size
{
    FINE(8),
    DIMINUTIVE(4),
    TINY(2),
    SMALL(1),
    MEDIUM(0),
    LARGE(-1),
    HUGE(-2),
    GARANTUAN(-4),
    COLOSSAL(-8);

    public final Integer bonus;

    private Size(Integer bonus)
    {
        this.bonus = bonus;
    }
}
