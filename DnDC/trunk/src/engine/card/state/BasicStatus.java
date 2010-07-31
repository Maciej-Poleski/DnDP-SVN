/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

package engine.card.state;

/**
 * 
 * @author bambucha
 */
public class BasicStatus implements Comparable<BasicStatus>
{
    Boolean   state;
    Character whom;
    State     name;

    public BasicStatus(Character whom, State name)
    {
        this.whom = whom;
    }

    public Boolean getState()
    {
        return state;
    }

    public void setState(Boolean state)
    {
        this.state = state;
    }

    public State getName()
    {
        return name;
    }

    @Override
    public int compareTo(BasicStatus t)
    {
        return this.name.compareTo(t.getName());
    }

}
