package aula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModamorDAO {
     private Connection con;

    public ModamorDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    } 

    public void setCon(Connection con) {
        this.con = con;
    }
     
    public String inserir (ModamorBean entrada_produto) throws SQLException{
        String sql = "insert into entrada_produto(cod_etiqueta, tipo_roupa, cor, tamanho, quantidade, valor_compra, Fornecedor)values(?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,entrada_produto.getNuEtiqueta());
            ps.setString(2,entrada_produto.getNome());
            ps.setString(3,entrada_produto.getCor());
            ps.setString(4,entrada_produto.getTamanho());
            ps.setString(5,entrada_produto.getQuantidade());
            ps.setString(6,entrada_produto.getValorCompra());
            ps.setString(7,entrada_produto.getFornecedor());

            
            if(ps.executeUpdate()>0){
                return "Inserido com sucesso";
            }
            else{
                return "Erro ao inserir";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    }
    public String alterar (ModamorBean entrada_produto) throws SQLException{
        String sql = "update entrada_produto set tipo_roupa = ?, cor = ?, tamanho = ?, quantidade = ?, valor_compra = ?, Fornecedor = ?";
        sql += "where cod_etiqueta=?";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(7,entrada_produto.getNuEtiqueta());
            ps.setString(1,entrada_produto.getNome());
            ps.setString(2,entrada_produto.getCor());
            ps.setString(3,entrada_produto.getTamanho());
            ps.setString(4,entrada_produto.getQuantidade());
            ps.setString(5,entrada_produto.getValorCompra());
            ps.setString(6,entrada_produto.getFornecedor());

            
            if(ps.executeUpdate()>0){
                return "Alterado com sucesso";
            }
            else{
                return "Erro ao alterar";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    }
      public String excluir (ModamorBean entrada_produto) throws SQLException{
        String sql = "DELETE FROM entrada_produto WHERE cod_etiqueta = ?";
   
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,entrada_produto.getNuEtiqueta());
           
            
            if(ps.executeUpdate()>0){
                return "Excluido com sucesso";
            }
            else{
                return "Erro ao excluir";
            }
        }catch(SQLException e){
            return e.getMessage();
        }
    }
      
      public List<ModamorBean> listarTodos() throws SQLException{
          
          String sql = "select * from entrada_produto";
          List<ModamorBean> listaMa = new ArrayList<ModamorBean>();
          try{
              PreparedStatement ps = getCon().prepareStatement(sql);
              ResultSet rs = ps.executeQuery();
              
              if(rs != null){
                  while(rs.next()){
                      ModamorBean mb = new ModamorBean();
                      mb.setNuEtiqueta((rs.getString(1)));
                      mb.setNome(rs.getString(2));
                      mb.setCor(rs.getString(3));
                      mb.setTamanho((rs.getString(4)));
                      mb.setQuantidade((rs.getString(5)));
                      mb.setValorCompra(rs.getString(6));
                      mb.setFornecedor(rs.getString(7));
                      listaMa.add(mb);
                  }
                  return listaMa;
              }
              else{
                  return null;
              }
          } 
          catch(SQLException e){
              return null;
          }
      }
}
