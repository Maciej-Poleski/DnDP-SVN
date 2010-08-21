package engine.check;

import engine.Character;
import engine.card.classes.BaseClass;

/**
 *
 * 
 * @author bambucha
 */
public class ClassCheck implements Checkable
{
    private final BaseClass baseClass;
    private final Integer level;
    
    /**
     * @param baseClass
     * @param level
     */
    public ClassCheck(BaseClass baseClass, Integer level)
    {
        super();
        this.baseClass = baseClass;
        this.level = level;
    }



    /* (non-Javadoc)
     * @see engine.check.Checkable#check(engine.Character)
     */
    @Override
    public boolean check(Character character)
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Brak implementacji");
    }

}
