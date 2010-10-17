package dndp.engine.card.skills;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.db4o.ObjectSet;

import dndp.client.FrontToDB;
import dndp.engine.Dice;
import dndp.engine.card.UnavailableTestException;
import dndp.engine.card.bonus.BonusManager;
import dndp.engine.item.BasicEquipmentManager;


/**
 * Klasa opiekująca się umiejetnoscieami bohaterów
 * 
 * @author bambucha
 */
public class DnDSkilManager implements SkillManager
{
    private BasicEquipmentManager      baseEquipmentManager;
    private Map<String, CharacterSkill> skilSet;

    // Przyśpieszenie zapytania po nazwie umiejętności. Dodanie klucza powinno
    // wyglądać put(CharacterSkil.getSkil.getName,CharacterSkill)

    public DnDSkilManager(BasicEquipmentManager main, BonusManager bonusManager)
    {
        this.baseEquipmentManager = main;
        this.skilSet = new HashMap<String, CharacterSkill>();
        ObjectSet<Skill> query = FrontToDB.getInstance().getDB().query(Skill.class);
        for(Skill skil : query)
            skilSet.put(skil.getName(), new CharacterSkill(skil, bonusManager));
    }

    /**
     * Wykonuje test danej umiejętności.
     * 
     * @param skilToTest
     *            Umiejętnośc do testowania
     * @return Wynikt testu
     * @throws UnavailableTestException Gdy test jest niemożliwy do wykonania.
     */
    private Integer testSkil(CharacterSkill skilToTest) throws UnavailableTestException
    {
        if(skilToTest.getSkil().isTrain() && skilToTest.getRank() == 0)
            throw new UnavailableTestException();
        if(skilToTest.getSkil().isArmorInterrupt())
            return Dice.D20.throwTheDice() + skilToTest.getRank() + skilToTest.getBonus() - baseEquipmentManager.getCurrentArmorPently();
        return Dice.D20.throwTheDice() + skilToTest.getRank() + skilToTest.getBonus();
    }

    /* (non-Javadoc)
     * @see engine.card.skils.SkilManager#testSkil(java.lang.String)
     */
    @Override
    public Integer testSkil(String name) throws UnavailableTestException
    {
        CharacterSkill t = skilSet.get(name);
        if(t != null)
            return testSkil(t);
        else
            throw new UnavailableTestException();
    }

    /* (non-Javadoc)
     * @see engine.card.skils.SkilManager#getSkilNameSet()
     */
    @Override
    public Set<String> getSkilNameSet()
    {
        return skilSet.keySet();
    }

    @Override
    public CharacterSkill getSkil(String name)
    {
        return skilSet.get(name);
    }

}
