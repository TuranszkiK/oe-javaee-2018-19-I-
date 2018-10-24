/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.javagladiators.education.guild.dao.interfaces;

import hu.javagladiators.education.guild.dao.models.Guild;
import java.util.List;

/**
 *
 * @author krisztian
 */
public interface GuildDao {
    public List<Guild> getAll();
    public Guild getById(long pId);
    public Guild getByName(String pName);
    public Guild create(Guild pData);
    public Guild modify(long pId,Guild pData);
    public Guild delete(long pId);
}
