package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.stage.Stage;
import dao.DaoOperador;
import entidades.Operador;
import javafx.scene.layout.Pane;

public class ControllerLista implements Initializable{
	
	@FXML
	private Pane telaLista;
	
	@FXML
	private TableView<Operador> tabela;
	
	@FXML
	private TableColumn<Operador, Integer> colunaID;
	
	@FXML
	private TableColumn<Operador, String> colunaNome;
	
	@FXML
	private TableColumn<Operador, String> colunaCpf;
	
	@FXML
	private TableColumn<Operador, Float> colunaSalario;




	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		colunaID.setCellValueFactory( new PropertyValueFactory<>("id") );
		colunaNome.setCellValueFactory( new PropertyValueFactory<>("nome") );
		colunaCpf.setCellValueFactory( new PropertyValueFactory<>("cpf") );
		colunaSalario.setCellValueFactory( new PropertyValueFactory<>("salario") );
		
		
		DaoOperador daoOperador = new DaoOperador();
		
		try {
			List<Operador> users = daoOperador.listar();
			
			
			
			tabela.setItems( FXCollections.observableArrayList( users ) );
		
		} catch (SQLException e) {
			
			Alert a = new Alert(AlertType.ERROR);
			a.setHeaderText("Atenção!");
			a.setContentText("Erro ao carregar usuários: " + e.getMessage());
			
			a.show();
			
		}
	}
	
	public void voltarTelaInicial() throws IOException {
		Stage stage = (Stage) this.telaLista.getScene().getWindow();
		
		Pane bp = new FXMLLoader(getClass().getResource("/views/TelaPrincipal.fxml")).load();
		
		Scene cena = new Scene(bp); 
		
		stage.setScene(cena);
		stage.show();
	}

}
