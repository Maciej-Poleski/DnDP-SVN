package engine.card.classes;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.SortedSet;
import java.util.TreeSet;

import engine.Character;
import engine.benefit.Benefit;
import engine.card.Checkable;
import engine.card.skils.Skil;

/**
 * Klasa menadżere klas postaci pojedynaczej postaci.
 * 
 * @author bambucha
 */
public class CharacterClassManager extends Observable
{
    private Character            character;
    private List<CharacterClass> classList;
    private Integer              level;
    private Integer              experiancePoint;
    private boolean              promoted;

    /**
     * @param character
     */
    public CharacterClassManager(Character character)
    {
        super();
        this.character = character;
        classList = new LinkedList<CharacterClass>();
    }

    public Integer getLevel()
    {
        return level;
    }

    private int getXPForLevel(int level)
    {
        return (level * (level + 1)) / 2;
    }

    public boolean isMultiClassCharacter()
    {
        SortedSet<Integer> set = new TreeSet<Integer>();
        for (CharacterClass characterClass : classList)
            if(characterClass.getClasses().isUseInMulticlass())
                set.add(characterClass.getLevel());
        if(set.last() - set.first() > 3)
            return true;
        return false;
    }

    public Integer getExperiancePoint()
    {
        return experiancePoint;
    }

    public void setExperiancePoint(Integer experiancePoint)
    {
        if(experiancePoint < 0)
            throw new IllegalArgumentException("Nie może być ujemne ( XP < 0) ");
        this.experiancePoint = experiancePoint;
        if(experiancePoint >= getXPForLevel(level + 1))
            this.promoted = true;
        setChanged();
        notifyObservers(); //FIXME Trzeba się zastanowić co obserwator ma dostać oprucz obserwowanego.
    }

    public boolean isPromoted()
    {
        return promoted;
    }

    public void promote(BaseClass classes) throws Exception
    {
        CharacterClass toPromote = null;
        for (CharacterClass characterClass : classList)
            if(characterClass.getClass().equals(classes)) // FIXIT Może nie działać.
                toPromote = characterClass;
        if(toPromote == null)
        {
            for (Checkable checkable : classes.getConditions())
                if(!checkable.check(character))
                    throw new Exception(); // Nie spełniający warunków ... FIXME Dodać wyjątek z engine.check 
            toPromote = new CharacterClass(classes, 0);
            for (Skil skil : toPromote.getClasses().getClassFleats())
                character.getSkil(skil.getName()).setClasses(true);
            classList.add(toPromote);
        }
        toPromote.setLevel(toPromote.getLevel() + 1);
        setChanged();
        notifyObservers(); // Uaktualnienie atutów, i inne rzeczy związanie z typem.
        for (Benefit benefit : toPromote.getClasses().getLevelBenefitsList()[toPromote.getLevel()])
            benefit.apply(character);
    }
}
