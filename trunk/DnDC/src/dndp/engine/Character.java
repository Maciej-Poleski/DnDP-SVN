package dndp.engine;

import java.util.Collection;
import java.util.Set;

import dndp.engine.card.UnavailableTestException;
import dndp.engine.card.abilities.Abiliti;
import dndp.engine.card.abilities.Abilities;
import dndp.engine.card.abilities.DnDAbilities;
import dndp.engine.card.armor.Armor;
import dndp.engine.card.armor.DnDArmor;
import dndp.engine.card.attack.Attack;
import dndp.engine.card.attack.BaseAttack;
import dndp.engine.card.attack.BaseBonusToAttack;
import dndp.engine.card.attack.DnDAttack;
import dndp.engine.card.bonus.BaseBonusHandler;
import dndp.engine.card.bonus.BonusManager;
import dndp.engine.card.bonus.Bonusable;
import dndp.engine.card.bonus.DnDBonusManager;
import dndp.engine.card.classes.BaseClass;
import dndp.engine.card.classes.CharacterClassManager;
import dndp.engine.card.classes.DnDCharacterClassManager;
import dndp.engine.card.description.Description;
import dndp.engine.card.description.DnDDescription;
import dndp.engine.card.description.God;
import dndp.engine.card.description.Race;
import dndp.engine.card.description.Sex;
import dndp.engine.card.description.Size;
import dndp.engine.card.fleats.CharacterFleat;
import dndp.engine.card.fleats.CharacterFleatManager;
import dndp.engine.card.fleats.DnDCharacterFleatManager;
import dndp.engine.card.fleats.Fleat;
import dndp.engine.card.hp.DnDHitPoints;
import dndp.engine.card.hp.HitPoints;
import dndp.engine.card.skills.CharacterSkill;
import dndp.engine.card.skills.DnDSkilManager;
import dndp.engine.card.skills.SkillManager;
import dndp.engine.card.st.DnDSavingThrows;
import dndp.engine.card.st.SavingThrow;
import dndp.engine.card.st.SavingThrows;
import dndp.engine.card.state.DnDStateManager;
import dndp.engine.card.state.State;
import dndp.engine.card.state.StateManager;
import dndp.engine.check.CheckFailException;
import dndp.engine.item.BasicEquipmentManager;
import dndp.engine.item.DnDEquipmentManager;
import dndp.engine.item.Item;


/**
 * Reprezentacja jednej postaci Wzorzec projektowy mediator + fasada
 * 
 * @author evil , bambucha
 */
public class Character implements Abilities, Attack, Armor, Description, HitPoints, SavingThrows, BonusManager, CharacterFleatManager,
        SkillManager, StateManager, BasicEquipmentManager, CharacterClassManager
{
    private Abilities             abilities;
    private Armor                 armor;
    private Description           description;
    private Attack                attack;
    private BasicEquipmentManager equipment;
    private HitPoints             HP;
    private SavingThrows          savingThrows;
    private BonusManager          bonusManager;
    private SkillManager           skilManager;
    private CharacterFleatManager characterFleatManager;
    private StateManager          stateManager;
    private CharacterClassManager classManager;

    /**
     * Konstruktor postaci<br/>
     * 
     * @param view
     *            Widok karty postaci.
     * @par TODO kolejność inicjowania poszególnych rzeczy.
     */
    public Character()
    {
        bonusManager = new DnDBonusManager(this);
        abilities = new DnDAbilities(this);
        description = new DnDDescription();
        HP = new DnDHitPoints();
        savingThrows = new DnDSavingThrows(this);
        armor = new DnDArmor(this, this, this);
        attack = new DnDAttack(this);
        equipment = new DnDEquipmentManager(this);
        skilManager = new DnDSkilManager(this, this);
        characterFleatManager = new DnDCharacterFleatManager(this);
        stateManager = new DnDStateManager(this);
        classManager = new DnDCharacterClassManager(this);
    }

    @Override
    public Abiliti getStrenght()
    {
        return abilities.getStrenght();
    }

    @Override
    public Abiliti getDexterity()
    {
        return abilities.getDexterity();
    }

    @Override
    public Abiliti getConstitution()
    {
        return abilities.getConstitution();
    }

    @Override
    public Abiliti getInteligence()
    {
        return abilities.getInteligence();
    }

    @Override
    public Abiliti getWisdom()
    {
        return abilities.getWisdom();
    }

    @Override
    public Abiliti getCharisma()
    {
        return abilities.getCharisma();
    }

    // Konice atrybutów

    @Override
    public Integer getAC()
    {
        return armor.getAC();
    }

    @Override
    public Integer getFlatFootetAC()
    {
        return armor.getFlatFootetAC();
    }

    @Override
    public Integer getTouchAttaksAC()
    {
        return armor.getTouchAttaksAC();
    }

    // Konice Pancerza

    @Override
    public String getName()
    {
        return description.getName();
    }

    @Override
    public String getPlayer()
    {
        return description.getPlayer();
    }

    @Override
    public Race getRase()
    {
        return description.getRase();
    }

    @Override
    public PersonalityTypes getPersonality()
    {
        return description.getPersonality();
    }

    @Override
    public God getGod()
    {
        return description.getGod();
    }

    @Override
    public Size getSize()
    {
        return description.getSize();
    }

    @Override
    public Integer getAge()
    {
        return description.getAge();
    }

    @Override
    public Sex getSex()
    {
        return description.getSex();
    }

    @Override
    public Integer getHeight()
    {
        return description.getHeight();
    }

    @Override
    public Integer getWeight()
    {
        return description.getWeight();
    }

    @Override
    public String getEye()
    {
        return description.getEye();
    }

    @Override
    public String getHair()
    {
        return description.getHair();
    }

    @Override
    public String getSkin()
    {
        return description.getSkin();
    }

    @Override
    public void setWeight(Integer newValeu)
    {
        description.setWeight(newValeu);
    }

    @Override
    public void setSkin(String newValeu)
    {
        description.setSkin(newValeu);
    }

    @Override
    public void setSize(Size newValeu)
    {
        description.setSize(newValeu);
    }

    @Override
    public void setSex(Sex newValeu)
    {
        description.setSex(newValeu);
    }

    @Override
    public void setRase(Race raceOfPlayer)
    {
        description.setRase(raceOfPlayer);
    }

    @Override
    public void setPlayer(String newValeu)
    {
        description.setPlayer(newValeu);
    }

    @Override
    public void setPersonality(PersonalityTypes newValeu)
    {
        description.setPersonality(newValeu);
    }

    @Override
    public void setName(String newValeu)
    {
        description.setName(newValeu);
    }

    @Override
    public void setHeight(Integer newValeu)
    {
        description.setHeight(newValeu);
    }

    @Override
    public void setHair(String newValeu)
    {
        description.setHair(newValeu);
    }

    @Override
    public void setGod(God newValeu)
    {
        description.setGod(newValeu);
    }

    @Override
    public void setEye(String newValeu)
    {
        description.setEye(newValeu);
    }

    @Override
    public void setAge(Integer newValeu)
    {
        description.setAge(newValeu);
    }

    // Koniec opisu

    @Override
    public void setSpeed(Double newValue)
    {
        attack.setSpeed(newValue);
    }

    @Override
    public void setInitiativeModifier(Integer newValue)
    {
        attack.setInitiativeModifier(newValue);
    }

    @Override
    public void setBaseAttack(BaseBonusToAttack newValue)
    {
        attack.setBaseAttack(newValue);
    }

    @Override
    public Double getSpeed()
    {
        return attack.getSpeed();
    }

    @Override
    public BaseAttack getRangeAttack()
    {
        return attack.getRangeAttack();
    }

    @Override
    public BaseAttack getMeleeAttack()
    {
        return attack.getMeleeAttack();
    }

    @Override
    public Integer getInitiativeModifier()
    {
        return attack.getInitiativeModifier();
    }

    @Override
    public BaseAttack getGrappleAttack()
    {
        return attack.getGrappleAttack();
    }

    @Override
    public BaseBonusToAttack getBaseAttack()
    {
        return attack.getBaseAttack();
    }

    // Koniec ataku

    @Override
    public void setMaxHP(Integer maxHP)
    {
        HP.setMaxHP(maxHP);
    }

    @Override
    public void setHP(Integer HP)
    {
        this.HP.setHP(HP);
    }

    @Override
    public Integer getMaxHP()
    {
        return HP.getMaxHP();
    }

    @Override
    public Integer getHP()
    {
        return HP.getHP();
    }

    // Koniec punktów życia

    @Override
    public void putOn(Item what)
    {
        equipment.putOn(what);
    }

    @Override
    public Integer getCurrentArmorPently()
    {
        return equipment.getCurrentArmorPently();
    }

    @Override
    public Integer getMaximumDexterityACBonus()
    {
        return equipment.getMaximumDexterityACBonus();
    }

    // Koniec ekwipunku

    public void store(Item what)
    {
        equipment.store(what);
    }

    @Override
    public void setSpellResistance(Double newValue)
    {
        savingThrows.setSpellResistance(newValue);
    }

    @Override
    public SavingThrow getWill()
    {
        return savingThrows.getWill();
    }

    @Override
    public Double getSpellResistance()
    {
        return savingThrows.getSpellResistance();
    }

    @Override
    public SavingThrow getReflex()
    {
        return savingThrows.getReflex();
    }

    @Override
    public SavingThrow getForttiude()
    {
        return savingThrows.getForttiude();
    }

    // Konice rzutów obronnych

    @Override
    public void registerBonus(String name, Bonusable newBonus)
    {
        bonusManager.registerBonus(name, newBonus);
    }

    @Override
    public BaseBonusHandler getBonusHandler(String name)
    {
        return bonusManager.getBonusHandler(name);
    }

    // Koniec menadżera bonusów.

    @Override
    public CharacterFleat getCharacterFleat(Fleat key)
    {
        return characterFleatManager.getCharacterFleat(key);
    }

    @Override
    public Collection<CharacterFleat> getAllCharacterFleats()
    {
        return characterFleatManager.getAllCharacterFleats();
    }

    // Koniec delegacji menadżera atutów.

    @Override
    public void setState(State state)
    {
        stateManager.setState(state);
    }

    @Override
    public void removeState(State state)
    {
        stateManager.removeState(state);
    }

    // Koniec stanów postaci

    public Integer testSkil(String name) throws UnavailableTestException
    {
        return skilManager.testSkil(name);
    }

    public CharacterSkill getSkil(String name)
    {
        return skilManager.getSkil(name);
    }

    
    public Set<String> getSkilNameSet()
    {
        return skilManager.getSkilNameSet();
    }

    //Koniec umiejętności

    @Override
    public Integer getLevel()
    {
        return classManager.getLevel();
    }

    @Override
    public boolean isMultiClassCharacter()
    {
        return classManager.isMultiClassCharacter();
    }

    @Override
    public Integer getExperiancePoint()
    {
        return classManager.getExperiancePoint();
    }

    @Override
    public void setExperiancePoint(Integer experiancePoint)
    {
        classManager.setExperiancePoint(experiancePoint);
    }

    @Override
    public boolean isPromoted()
    {
        return classManager.isPromoted();
    }

    @Override
    public void promote(BaseClass classes) throws CheckFailException
    {
        classManager.promote(classes);
    }

    @Override
    public Integer getClassLevel(BaseClass classes)
    {
        return classManager.getClassLevel(classes);
    }
    
}
