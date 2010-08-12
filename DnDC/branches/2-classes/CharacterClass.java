package engine.card.classes;

/**
 * Opis jednej klasy wybranje przez postać.
 *
 * 
 * @author bambucha
 */
public class CharacterClass
{
    private BasicClass care;
    private Integer level;
    
    /**
     * @param care
     * @param level
     */
    public CharacterClass(BasicClass care, Integer level)
    {
        super();
        this.care = care;
        this.level = level;
    }

    public Integer getLevel()
    {
        return level;
    }

    public void setLevel(Integer level)
    {
        this.level = level;
    }

    public BasicClass getCare()
    {
        return care;
    }
}
