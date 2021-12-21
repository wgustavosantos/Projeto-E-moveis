package emoveisDAO;

import conexaoJDBC.ConnectionDB;
import emoveisMODEL.Imovel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wenderson
 */
public class ImovelDAO implements InterfaceDao {

    private static Connection connection =  null;
    private static final ImovelDAO INSTANCE = new ImovelDAO();

    private ImovelDAO() {
       
    }

    @Override
    public void create(Imovel imovel) {
        
        connection = ConnectionDB.getConnection();
        
        String sql = "INSERT INTO imoveis ( tipo_imovel, area_imovel, cor_imovel,"
                + " qtd_comodos_imovel, endereco_imovel, valor_imovel, status_imovel ) ";
        sql += "VALUES (?, ?, ?, ?, ?, ?, ?);";
        
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, imovel.getTipo_imovel());
            statement.setInt(2, imovel.getArea_imovel());
            statement.setString(3, imovel.getCor_imovel());
            statement.setInt(4, imovel.getQtd_comodos_imovel());
            statement.setString(5, imovel.getEndereco_imovel());
            statement.setDouble(6, imovel.getValor_imovel());
            statement.setBoolean(7, imovel.isStatus_imovel());

            if ( statement.executeUpdate() >= 1) {//retorna o número de linhas afetadas, caso consiga inserir, retornará o numero de linhas criadas com mínimo de 1 linha afetada no banco
                System.out.println("Imovel foi cadastrado com sucesso!");
                connection.commit();//Consolidação da transação
                statement.close();           
                connection.close();
            }        
        } catch (SQLException e) {
            System.out.println("Erro ao inserir novo cadastro: " + e);
            try {connection.rollback();} catch (SQLException logOrIgnore) {}
                //inserção desfeita          
        }
    }

    @Override
    public List<Imovel> read() {
        
        connection = ConnectionDB.getConnection();
        
        List<Imovel> imoveis = new ArrayList<>();
        String sql = "SELECT * FROM imoveis ORDER BY id_imovel";
        
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(sql);
            ResultSet set;
            set = statement.executeQuery();

            while (set.next()) {
                Imovel imovel = new Imovel.ImovelBuilder().
                        tipo_imovel(set.getString("tipo_imovel"))
                        .area_imovel(set.getInt("area_imovel"))
                        .cor_imovel(set.getString("cor_imovel"))
                        .qtd_comodos_imovel(set.getInt("qtd_comodos_imovel"))
                        .endereco_imovel(set.getString("endereco_imovel"))
                        .valor_imovel(set.getDouble("valor_imovel"))
                        .status_imovel(set.getBoolean("status_imovel"))
                        .id_imovel(set.getInt("id_imovel"))
                        .build();

                imoveis.add(imovel);
            }
           statement.close();
           set.close();
           connection.close();
           return imoveis;
        } catch (SQLException e) {
            System.out.println("Erro ao listar imovoveis do banco de dados: " + e);          
        }     
        return null;
    }

    @Override
    public void update(Imovel imovel) {
        
        connection = ConnectionDB.getConnection();

        String sql = "UPDATE imoveis "
                + "SET tipo_imovel = ?, area_imovel = ?, cor_imovel = ?, qtd_comodos_imovel = ?, endereco_imovel = ?,"
                + "valor_imovel = ?, status_imovel = ? "
                + "WHERE id_imovel = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, imovel.getTipo_imovel());
            statement.setInt(2, imovel.getArea_imovel());
            statement.setString(3, imovel.getCor_imovel());
            statement.setInt(4, imovel.getQtd_comodos_imovel());
            statement.setString(5, imovel.getEndereco_imovel());
            statement.setDouble(6, imovel.getValor_imovel());
            statement.setBoolean(7, imovel.isStatus_imovel());
            statement.setInt(8, imovel.getId_imovel());

            if (statement.executeUpdate() >= 1) {//retorna o número de linhas afetadas, caso consiga atualizar, retornará o numero de linhas atualizadas com mínimo de 1 linha afetada no banco
                connection.commit();//consolidação do update no banco
                statement.close();
                connection.close();
                System.out.println("Registro atualizado");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar no banco de dados: " + e);
            try {connection.rollback();} catch (SQLException logOrIgnore) {}//update desfeito          
        }
    }

    @Override
    public void delete(int id) {
        
        connection = ConnectionDB.getConnection();

        String sql = "DELETE FROM imoveis where id_imovel = ?";
        
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            
            if (statement.executeUpdate() >= 1) {//retorna o número de linhas afetadas, caso consiga deletar, retornará o numero de linhas atualizadas com mínimo de 1 linha afetada no banco
                connection.commit();//consolidação do delete no banco
                statement.close();
                connection.close();
                System.out.println("Registro deletado");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar no banco de dados: " + e);
            try {connection.rollback();} catch (SQLException logOrIgnore) {}//delete desfeito 

        }
    }
    
    @Override
    public boolean check(int id) {
        
        connection = ConnectionDB.getConnection();

        String sql = "SELECT id_imovel FROM imoveis WHERE id_imovel = ?";
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
           
            if (resultSet.next())//retorna verdadeiro caso a próxima linha de resultSet tenha um registro
                return true;
                                 
        } catch (SQLException e) {
            System.out.println("Erro ao ler no banco de dados: " + e);

        }
    return false; // retorna falso se não passar pela condição acima, constatando que não tem registro no resultSet
    }

    @Override
    public Imovel readSingle(int id_imovel) {
        
        connection = ConnectionDB.getConnection();
        
        String sql = "SELECT * FROM imoveis WHERE id_imovel = ?";
        
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id_imovel);
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                Imovel imovel = new Imovel.ImovelBuilder().
                        tipo_imovel(set.getString("tipo_imovel"))
                        .area_imovel(set.getInt("area_imovel"))
                        .cor_imovel(set.getString("cor_imovel"))
                        .qtd_comodos_imovel(set.getInt("qtd_comodos_imovel"))
                        .endereco_imovel(set.getString("endereco_imovel"))
                        .valor_imovel(set.getDouble("valor_imovel"))
                        .status_imovel(set.getBoolean("status_imovel"))
                        .id_imovel(set.getInt("id_imovel"))
                        .build();

                return imovel;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao ler registro no banco de dados: " + e);
        }
        return null; // retorna nulo caso não encontre nada, mas nunca é executado caso não encontre
        //id por conta da validação check(id) antes da chamada do método readSingle()
    }
    
    public static ImovelDAO getINSTANCE() {
        return INSTANCE; // Singleton 
    }
}
