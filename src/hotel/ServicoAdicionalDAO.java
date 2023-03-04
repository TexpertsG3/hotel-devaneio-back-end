package hotel;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicoAdicionalDAO {
	
	  public void insere(String nomeServico, BigDecimal valor) throws SQLException {
		    Connection conn = ConnectionFactory.criaConexao(); 
		    
		    ServicoAdicional servicoAdicional = new ServicoAdicional(nomeServico, valor);
		    
		    String sql = "insert into servico_adicional (nome, preco) values(?,?)";
		    
		    try (PreparedStatement st = conn.prepareStatement(sql)) {
				st.setString(1, servicoAdicional.getNomeServico());
				st.setBigDecimal(2, servicoAdicional.getValorServico());
				st.execute();
				System.out.println("Serviço " + servicoAdicional.getNomeServico() + " adicionado com sucesso");
				st.close();
		    } catch (SQLException e) {	
			} finally {
				
				conn.close();
			}
		  }
		  
		  
		  public List<ServicoAdicional> listagem() throws SQLException{
		    Connection conn = ConnectionFactory.criaConexao();
		    
		    
		    String sql = "select nome, preco from servico_adicional";
		    PreparedStatement st = conn.prepareStatement(sql);
		    ResultSet rs = st.executeQuery(); //Ele retorna um objeto genérico, é um conjunto de resultados
		    
		    List<ServicoAdicional> lista = new ArrayList<>();
		    
		    while(rs.next()) {
		      
		      ServicoAdicional servico = new ServicoAdicional(
		          rs.getString(1),
		          rs.getBigDecimal(2)
		          );
		      lista.add(servico);
		      
		    }
		    rs.close();
		    st.close();
		    conn.close();
		    
		    return lista;
		  }
//		  
//		  public static void update(Carro carro) throws SQLException {
//		Connection conn = FabricaDeConexoes.criaConexao();
//		    
//		    String sql = "update carros set modelo = ?, set marca = ?, set cor_id, set ano = ? where id = ?";
//		    PreparedStatement st = conn.prepareStatement(sql);
//		    st.setString(1, carro.getModelo());
//		    st.setString(2, carro.getMarca());
//		    st.setInt(3, carro.getCorId());
//		    st.setInt(4, carro.getAno());
//		    st.setInt(5, carro.getId());
//		    st.execute();
//		    
//		    System.out.println("Carro alterado com sucesso");
//		    
//		    
//		    st.close();
//		    conn.close();
//		  }
//
//		  
//		  public void delete (int id) throws SQLException{
//		    
//		Connection conn = FabricaDeConexoes.criaConexao();
//		    
//		    String sql = "delete from carros where id =? ";
//		    PreparedStatement st = conn.prepareStatement(sql);
//		    st.setInt(1,id);
//		    st.execute();
//		    
//		    System.out.println("Carro de id: " + id +  " deletado com sucesso");
//		    
//		    st.close();
//		    conn.close();
//		    
//		    
//		  }

}
