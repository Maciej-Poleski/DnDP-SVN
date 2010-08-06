package engine.card.fleats;

import engine.Character;
import engine.benefit.Benefit;
import engine.card.Checkable;

/**
 * Klasa opisująca atut w bazie danych.
 * 
 * @author evil, bambucha
 */
public class Fleat
{

    private final Checkable[] dependency;
    private final Benefit[]   benefits;
    private String            name;

    /**
     * 
     * @param name
     *            Nazwa
     */
    public Fleat(String name,Checkable[] dependens, Benefit[] benefits)
    {
        this.name = name;
        this.dependency = dependens;
        this.benefits = benefits;
    }

    /**
     * Zastosuj atut.
     */
    public void apply(Character character)
    {
        for (Benefit b : benefits)
            b.apply(character);
    }

    /**
     * Rezygnuj z atutu.
     */
    public void abandon(Character character)
    {
        for (Benefit b : benefits)
            b.abandon(character);
    }

    /**
     * Zwraca listę zależności.
     * 
     * @return Lista zeleżności.
     */
    public Checkable[] getDependency()
    {
        return dependency;
    }
    
    public Benefit[] getBenefits()
    {
        return benefits;
    }

    public String getName()
    {
        return name;
    }

}
