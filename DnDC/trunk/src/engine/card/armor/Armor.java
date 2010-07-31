package engine.card.armor;

/**
 * Interfejs obsługi pancerza
 * 
 * @author bambucha
 */
public interface Armor
{
    public Integer getArmorACBonus();

    public Integer getShieldACBonus();

    public Integer getDextirityACBonus();

    public Integer getSizeACBonus();

    public Integer getFlatFootetAC();

    public Integer getTouchAttaksAC();

    public Integer getDeflectionACBonus();

    public Integer getProficiencyACBonus();

    public Integer getDodgeACBonus();

    public Integer getAC();

    public void setArmorACBonus(Integer newValue);

    public void setShieldACBonus(Integer newValue);

    public void setDeflectionACBonus(Integer newValue);

    public void setProficiencyACBonus(Integer newValue);

    public void setDodgeACBonus(Integer newValue);
}
