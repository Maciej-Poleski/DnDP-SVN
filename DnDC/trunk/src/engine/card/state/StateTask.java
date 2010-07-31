package engine.card.state;

/**
 * 
 * @author bambucha
 */
public class StateTask implements Comparable<StateTask>
{
    private Integer      time;
    private State        status;

    public StateTask(Integer time, State status, StateReactor x)
    {
        this.time = time;
        this.status = status;
    }

    public State getStatus()
    {
        return status;
    }

    public Integer getTime()
    {
        return time;
    }

    public void setTime(Integer time)
    {
        this.time = time;
    }

    @Override
    public int compareTo(StateTask o)
    {
        return this.time - o.getTime();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof State)
            return this.status.equals(obj);
        return super.equals(obj);
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 29 * hash + (this.status != null ? this.status.hashCode() : 0);
        return hash;
    }

}
