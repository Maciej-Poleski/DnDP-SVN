/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

package engine.card.fleats;

import java.util.Collection;

import engine.Character;

/**
 * 
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
     * Zwraca postać zarejestrowaną w tym menadżerze.
     * 
     * @return
     */
    Character getCharacter();

    /**
     * Zwraca CharacterFleat dla danego Fleat
     * 
     * @param key
     * @return
     */
    CharacterFleat getCharacterFleat(Object key);

}
