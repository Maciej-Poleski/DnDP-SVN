package engine.card.skils;

import java.util.Set;

public interface SkilManager
{

    /**
     * Wykonuje test umijętności, wyszukując ją wg nazwy.
     * 
     * @param name
     * @return
     */
    public abstract Integer testSkil(String name);
    
    /**
     * Zwraca umiejętność postaci.
     * @return referencję do umiejętności postaci, w przeciwmum wypadku @code null @endcode
     */
    public abstract CharacterSkil getSkil(String name);

    /**
     * Zwraca set z nazwami umiejętności.
     * 
     * @see java.util.Map
     * @return
     */
    public abstract Set<String> getSkilNameSet();

}
