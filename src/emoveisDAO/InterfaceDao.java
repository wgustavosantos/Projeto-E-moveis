/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emoveisDAO;

import emoveisMODEL.Imovel;
import java.util.List;

/**
 *
 * @author Wenderson
 */
public interface InterfaceDao {

    public void create(Imovel imovel);

    public List<Imovel> read();

    public void update(Imovel imovel);

    public void delete(int id);
    
    public Imovel readSingle(int id_imovel);
    
    public boolean check(int id);

}
