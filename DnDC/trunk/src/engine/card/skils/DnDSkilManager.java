package engine.card.skils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.db4o.ObjectSet;

import client.FrontToDB;

import engine.Dice;
import engine.card.bonus.BonusManager;
import engine.item.BasicEquipmentManager;

/**
 * Klasa opiekująca się umiejetnoscieami bohaterów
 * 
 * @par TODO Dodanie wyjątku informującą że test jest niemożliwy. Miejsca w kodzie oznaczone FIXME.<br/>
 * 
 * @author bambucha
 */
public class DnDSkilManager implements SkilManager
{
    private BasicEquipmentManager      baseEquipmentManager;
    private Map<String, CharacterSkil> skilSet;

    // Przyśpieszenie zapytania po nazwie umiejętności. Dodanie klucza powinno
    // wyglądać put(CharacterSkil.getSkil.getName,CharacterSkill)

    public DnDSkilManager(BasicEquipmentManager main, BonusManager bonusManager)
    {
        this.baseEquipmentManager = main;
        this.skilSet = new HashMap<String, CharacterSkil>();
        ObjectSet<Skil> query = FrontToDB.getInstance().getDB().query(Skil.class);
        for(Skil skil : query)
            skilSet.put(skil.getName(), new CharacterSkil(skil, bonusManager));
    }

    /**
     * Wykonuje test danej umiejętności.
     * 
     * @param skilToTest
     *            Umiejętnośc do testowania
     * @return Wynikt testu
     */
    private Integer testSkil(CharacterSkil skilToTest)
    {
        if(skilToTest.getSkil().isTrain() && skilToTest.getRank() == 0)
            throw new UnsupportedOperationException(); // FIXME
        if(skilToTest.getSkil().isArmorInterrupt())
            return Dice.D20.throwTheDice() + skilToTest.getRank() + skilToTest.getBonus() - baseEquipmentManager.getCurrentArmorPently();
        return Dice.D20.throwTheDice() + skilToTest.getRank() + skilToTest.getBonus();
    }

    /* (non-Javadoc)
     * @see engine.card.skils.SkilManager#testSkil(java.lang.String)
     */
    @Override
    public Integer testSkil(String name)
    {
        CharacterSkil t = skilSet.get(name);
        if(t != null)
            return testSkil(t);
        else
            throw new UnsupportedOperationException(); // FIXME
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
    public CharacterSkil getSkil(String name)
    {
        return skilSet.get(name);
    }

}
