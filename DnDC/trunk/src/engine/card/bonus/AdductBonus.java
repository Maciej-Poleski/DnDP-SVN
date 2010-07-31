package engine.card.bonus;

/**
 * Klasa zajmująca się premiami kumulującymi się.
 * @author bambucha
 */
public class AdductBonus implements Bonus
{
    private Integer currentBonus;
    private Integer currentPenalty;


    /**
     * Konstruktor tworzy premię na poziomie 0.
     */
    public AdductBonus()
    {
        this.currentBonus = 0;
        this.currentPenalty = 0;
    }

    /**
     * Dodaje wartość do premii.
     * @param bonus
     */
    @Override
    public synchronized void  addBonus(Integer bonus)
    {
        if(bonus >= 0)
            currentBonus += bonus;
        else
            currentPenalty += bonus;
    }

    /**
     * Obniża premię.
     * @param bonus
     */
    @Override
    public synchronized void removeBonus(Integer bonus)
    {
        if(bonus >= 0)
            currentBonus -= bonus;
        else
            currentPenalty -= bonus;
    }

    /**
     * Zwraca aktualną premię.
     * @return Premia.
     */
    @Override
    public Integer getBonus()
    {
        return currentBonus - currentPenalty;
    }

}
