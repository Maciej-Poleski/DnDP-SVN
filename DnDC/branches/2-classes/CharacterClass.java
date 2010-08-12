package engine.card.classes;

/**
 * Opis jednej klasy wybranje przez postać.
 *
 * 
 * @author bambucha
 */
public class CharacterClass
{
    private BasicClass classes;
    private Integer level;
    
    /**
     * @param classes
     * @param level
     */
    public CharacterClass(BasicClass classes, Integer level)
    {
        super();
        this.classes = classes;
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

    public BasicClass getClasses()
    {
        return classes;
    }
}
