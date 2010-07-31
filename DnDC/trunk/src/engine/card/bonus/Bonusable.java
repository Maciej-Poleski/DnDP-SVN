package engine.card.bonus;

import engine.card.abilities.AbilityType;

/**
 * Interfejs modelujący premię i kary. Wymusza implemetację funkcji ustawiającą
 * bonus.<br/>
 * 
 * @note By interfejs działał poprawnie, atrybut, umiejętność czy rzut obronny
 *       musi być zarejestrowan w BonusManager.<br/>
 *       Najlepiej zrobić to w kontruktorze
 * 
 *       Interfejs ten powinien byś implementowany przez wsyztkie klasy
 *       zajmujące się liczeniem rzutów.
 * @author bambucha
 */
public interface Bonusable
{
    /**
     * Ustawia nową wartość bonusu.
     * 
     * @param bonus
     */
    public void setBonus(Integer bonus);

    /**
     * Zwraca typ atrybutu.
     * 
     * @return Typ atrybutu.
     */
    public AbilityType getAbilityName();
}
