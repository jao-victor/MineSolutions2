package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dao.DaoOperador;
import entidades.Operador;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;


public class ControllerPrincipal implements Initializable{

	@FXML
	private Pane telaInicial;
	
	@FXML
	private TextField Fieldnome;
	
	@FXML
	private TextField FieldCpf;
	
	@FXML
	private TextField FieldSalario;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void cadastrar() {
		String nome = Fieldnome.getText().trim();
		String cpf = FieldCpf.getText().trim();
		float salario =  Float.parseFloat(FieldSalario.getText().trim());
		
		Operador operador = new Operador(cpf, nome, salario);
		DaoOperador daoOperador = new DaoOperador();
		
		try {			
			daoOperador.cadastrar(operador);

			
		}catch(Exception e) {	
			Alert a = new Alert(AlertType.ERROR);
			a.setHeaderText("Atenção!");
			a.setContentText("Houve um erro ao cadastrar o usuário: " + e.getMessage());
			
			a.show();
		}
		
	}
	
	public void lista() throws IOException {
		Stage stage = (Stage) this.telaInicial.getScene().getWindow();
		
		Pane bp = new FXMLLoader(getClass().getResource("/views/TelaLista.fxml")).load();
		
		Scene cena = new Scene(bp); 
		
		stage.setScene(cena);
		stage.show();
	}

}
