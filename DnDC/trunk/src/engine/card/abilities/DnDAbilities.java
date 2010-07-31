package engine.card.abilities;

import engine.card.bonus.BonusManager;
import engine.card.bonus.DnDBonusManager;
import gui.card.AbilitiPanel;
import gui.card.AbilitiesPanel;
import javax.swing.event.ChangeListener;

/**
 * Implementacja i obsługa atybutów.
 * @author bambucha
 * @see engine.card.abilities.Abilities
 */
public class DnDAbilities implements Abilities
{
    private Abiliti strenght;
    private Abiliti dexterity;
    private Abiliti construction;
    private Abiliti intelligence;
    private Abiliti wisdom;
    private Abiliti charisma;

    public DnDAbilities(AbilitiesPanel temp, BonusManager bonusManager)
    {
        this.strenght = new Abiliti(temp.getStrPanel());
        bonusManager.registerBonus("Strenght", strenght);
        this.dexterity = new Abiliti(temp.getDexPanel());
        bonusManager.registerBonus("Dexterity", dexterity);
        this.construction = new Abiliti(temp.getConPanel());
        bonusManager.registerBonus("Construction", construction);
        this.intelligence = new Abiliti(temp.getIntPanel());
        bonusManager.registerBonus("Intelligence", intelligence);
        this.wisdom = new Abiliti(temp.getWisPanel());
        bonusManager.registerBonus("Wisdom", wisdom);
        this.charisma = new Abiliti(temp.getChaPanel());
        bonusManager.registerBonus("Charisma", charisma);
    }

    @Override
    public Abiliti getStrenght()
    {
        return this.strenght;
    }

    @Override
    public Abiliti getDexterity()
    {
        return this.dexterity;
    }

    @Override
    public Abiliti getConstitution()
    {
        return this.construction;
    }

    @Override
    public Abiliti getInteligence()
    {
        return this.intelligence;
    }

    @Override
    public Abiliti getWisdom()
    {
        return this.wisdom;
    }

    @Override
    public Abiliti getCharisma()
    {
        return this.charisma;
    }
}
