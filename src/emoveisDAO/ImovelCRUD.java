package emoveisDAO;

import emoveisMODEL.Imovel;
import java.util.List;


/**
 *
 * @author Wenderson
 */
public class ImovelCRUD {

    private static final ImovelDAO dao = ImovelDAO.getINSTANCE();//Padrão Singleton 

    public static void deletar(int id_imovel) {
        dao.delete(id_imovel);
    }

    public static void create(Imovel imovel) {
        
        dao.create(imovel);
    }

    public static List<Imovel> read() {
        return dao.read();
    }

    public static void update(Imovel i) {
        dao.update(i);
    }

    public static Imovel readSIngle(int id_imovel) {
        return dao.readSingle(id_imovel);
    }

    public static boolean check(int id_imovel) {
        return dao.check(id_imovel);
    }

}
