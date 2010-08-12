/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

package engine.card.fleats;

import java.util.Collection;

/**
 * Interfejs zapewniający operacje na atutach postaci.
 * Zapewnia wyszukiwanie oraz wylistowanie atutów.
 * @author evil, bambucha
 */
public interface CharacterFleatManager
{

    /**
     * Pobiera listę atutów.
     * 
     * @return
     */
    Collection<CharacterFleat> getAllCharacterFleats();

    /**
     * Zwraca CharacterFleat dla danego Fleat
     * 
     * @param key
     * @return
     */
    CharacterFleat getCharacterFleat(Fleat key);

}
