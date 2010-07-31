package engine.card.fleats;

import engine.card.Benefit;
import engine.card.Checkable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author evil, bambucha
 */
public class Fleat
{

    private List<Checkable> dependency;
    private List<Benefit> benefits;
    private String name;

    /**
     *
     * @param name Nazwa
     */
    public Fleat(String name)
    {
        this.name = name;
        dependency = new ArrayList<Checkable>();
        benefits = new ArrayList<Benefit>();
    }

    /**
     * @param e Zależność
     * @return this
     * @note TODO Wyjątek w razie niepowodzenie add() */
    public Fleat addDependency(Checkable e)
    {
        dependency.add(e);
        return this;
    }

    /**
     * Dodaje korzyść wynikającą z tego atutu.
     * @param b Korzyść.
     * @return Ten atut.
     */
    public Fleat addBenefit(Benefit b)
    {
        benefits.add(b);
        return this;
    }

    /**
     * Zastosuj atut.
     */
    public void apply()
    {
        for (Benefit b : benefits)
            b.apply();
    }

    /**
     * Rezygnuj z atutu.
     */
    public void abandon()
    {
        for (Benefit b : benefits)
            b.abandon();
    }

    /**
     * Zwraca listę zależności.
     * @return Lista zeleżności.
     */
    public List<Checkable> getDependency()
    {
        return dependency;
    }

}
