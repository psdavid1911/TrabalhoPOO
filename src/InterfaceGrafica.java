
import com.sun.javafx.scene.control.skin.LabeledText;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class InterfaceGrafica extends Application{

    public static void main(String[] args){
        launch(args);
    }
    Agenda agenda = new Agenda();
    TextField ano = new TextField("1998");
    Button cadastrar = new Button("Cadastrar"),
            limpar = new Button("Limpar"),
            pesquisar = new Button("Pesquisar"),
            salvarAgenda = new Button("Salvar"),
            abrirAgenda = new Button("Abrir"),
            apagarAgenda = new Button("Apagar"),
            apagarSelecao = new Button("Apagar"),
            dadosSelecao = new Button("Informações"),
            niverDoMes = new Button("Mes"),
            niverDaSemana = new Button("Semana"),
            niverDoDia = new Button("Dia"),
            mostrarAgenda = new Button("Mostrar"),
            alterarSelecao = new Button("Alterar");
    TextField dia = new TextField("25");
    FileChooser dialogoDeArquivo = new FileChooser();
    TextField email = new TextField("contatoEx@servidorEx.com");
    Label labelEmail = new Label("E-mail:"),
            labelNascimento = new Label("Data de nascimento:"),labelNome = new Label("Nome:"),
            labelTelefone_1 = new Label("Telefone 1:"),
            labelTelefone_2 = new Label("Telefone 2:"),
            mensagem1 = new Label("Depois de preecher os campos acima clique em cadastrar"),
            mensagem2 = new Label("Acima você vê a agenda atual."),
            labelDataReferencia = new Label("Data de referência"),
            labelBotoesPesquisa = new Label("Aniversariantes do(a)"),
            labelBotoesContato = new Label("Seleção"),
            labelBotoesAgenda = new Label("Agenda");
    TextField mes = new TextField("07");
    TextField nome = new TextField("Contato Exemplo Para Clicar em Cadastrar e Depois Pesquisar");
    TextField pesquisa = new TextField("Contato Exemplo Para Clicar em Cadastrar e Depois Pesquisar");
    GridPane quadro = new GridPane();
    TextField resultadoPesquisa = new TextField();
    TextField telefone_1 = new TextField("85131987521");
    TextField telefone_2 = new TextField("98546841315");
    ListView<String> listaDeContatos = new ListView<>();
    ObservableList<String> contatos;
    TextField buscaDia = new TextField("19");
    TextField buscaMes = new TextField("11");
    TextField buscaAno = new TextField("1991");
    Separator separador1 = new Separator(), separador2 = new Separator();
    FlowPane painelNascimento = new FlowPane(dia, mes, ano),
            painelPesquisa = new FlowPane(pesquisa, pesquisar),
            painelBotoes = new FlowPane(cadastrar, limpar),
            painelBuscaAniversario = new FlowPane(buscaDia, buscaMes, buscaAno),
            painelBotoesBusca = new FlowPane( niverDoMes, niverDaSemana, niverDoDia),
            painelContatos = new FlowPane(apagarSelecao, dadosSelecao, alterarSelecao),
            painelAgenda = new FlowPane(mostrarAgenda, salvarAgenda, abrirAgenda, apagarAgenda);

    @Override
    public void start(Stage palco){
        // Configurações
        mensagem1.setStyle("-fx-text-fill: orange;");
        mensagem2.setStyle("-fx-text-fill: blue;");
        dialogoDeArquivo.setTitle("Localização a salvar...");
        dialogoDeArquivo.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Arquivo xml", "*.xml"),
                new FileChooser.ExtensionFilter("Arquivo Bean", "*.beam")
        );
        quadro.setVgap(5);
        quadro.setHgap(5);
        quadro.setPadding(new Insets(10, 10, 10, 10));
        painelBotoes.setMinWidth(500);
        painelPesquisa.setMinWidth(500);
        painelBotoes.setHgap(5);
        painelPesquisa.setHgap(5);
        painelNascimento.setHgap(5);
        painelAgenda.setHgap(5);
        painelContatos.setHgap(5);
        painelBuscaAniversario.setHgap(5);
        painelBotoesBusca.setHgap(5);
        nome.setPrefWidth(350);
        dia.setMaxWidth(30);
        mes.setMaxWidth(30);
        ano.setMaxWidth(60);
        buscaDia.setMaxWidth(30);
        buscaMes.setMaxWidth(30);
        buscaAno.setMaxWidth(60);
        telefone_1.setMaxWidth(100);
        telefone_2.setMaxWidth(100);
        email.setMaxWidth(200);
        pesquisa.setPrefWidth(350);
        mensagem1.setPadding(new Insets(20, 20, 20, 20));
        mensagem2.setPadding(new Insets(20, 20, 20, 20));
        separador1.setPadding(new Insets(20, 20, 20, 20));
        separador2.setPadding(new Insets(20, 20, 20, 20));
        listaDeContatos.setPrefHeight(100);

        // Inclusões na janela
        quadro.add(labelNome, 0, 0);
        quadro.add(nome, 1, 0);
        quadro.add(labelTelefone_1, 0, 1);
        quadro.add(telefone_1, 1, 1);
        quadro.add(labelTelefone_2, 0, 2);
        quadro.add(telefone_2, 1, 2);
        quadro.add(labelEmail, 0, 3);
        quadro.add(email, 1, 3);
        quadro.add(labelNascimento, 0, 4);
        quadro.add(painelNascimento, 1, 4);
        quadro.add(mensagem1, 1, 5);
        quadro.add(painelBotoes, 1, 6);
        quadro.add(separador1, 0, 8, 2, 1);
        quadro.add(painelPesquisa, 1, 9);
        quadro.add(labelDataReferencia, 0, 10);
        quadro.add(painelBuscaAniversario, 1, 10);
        quadro.add(labelBotoesPesquisa, 0, 11);
        quadro.add(labelBotoesContato, 0,13);
        quadro.add(painelBotoesBusca, 1, 11);
        quadro.add(separador2, 0, 12, 2, 1);
        quadro.add(painelContatos, 1, 13);
        quadro.add(listaDeContatos, 1, 14);
        quadro.add(labelBotoesAgenda, 0, 15);
        quadro.add(painelAgenda, 1, 15);
        quadro.add(mensagem2, 1, 16);
        listaDeContatos.setItems(FXCollections.observableArrayList(agenda.contatos()));
        palco.setScene(new Scene(quadro));
        palco.setTitle("Agenda");
        palco.setResizable(false);
        palco.show();

        // Configuração de botões
        cadastrar.setOnAction(e -> {
            nome.setEditable(true);
            try{
                String auxNome = nome.getText();
                String auxTelefone_1 = telefone_1.getText();
                String auxTelefone_2 = telefone_2.getText();
                String auxEmail = email.getText();
                int auxDia = Integer.parseInt(dia.getText());
                int auxMes = Integer.parseInt(mes.getText());
                int auxAno = Integer.parseInt(ano.getText());
                agenda.cadastrar(auxNome, auxTelefone_1, auxTelefone_2, auxEmail, auxDia, auxMes, auxAno);
                mensagem1.setStyle("-fx-text-fill: blue;");
                mensagem1.setText("Contato cadastrado com sucesso.");
                listaDeContatos.setItems(FXCollections.observableArrayList(agenda.contatos()));
            } catch (NumberFormatException nfe){
                mensagem1.setStyle("-fx-text-fill: red;");
                mensagem1.setText("Data de nascimento possui valores inválidos.");
            }
        });

        salvarAgenda.setOnAction(e -> {
            try{
                File enderecoDoArquivo = dialogoDeArquivo.showSaveDialog(palco);
                if (enderecoDoArquivo.getPath().contains(".javabeans")){
                    FluxoBeans<Agenda> manipuladorDeAgenda = new FluxoBeans<>(enderecoDoArquivo.getPath());
                    manipuladorDeAgenda.escreve(agenda);
                } else if (enderecoDoArquivo.getPath().contains(".xml")){
                    FluxoBeansXml<Agenda> manipuladorDeAgenda = new FluxoBeansXml<>(enderecoDoArquivo.getPath());
                    manipuladorDeAgenda.escreve(agenda);
                }
                mensagem1.setStyle("-fx-text-fill: blue;");
                mensagem1.setText("Arquivo salvo com sucesso.");
                listaDeContatos.setItems(FXCollections.observableArrayList(agenda.contatos()));
            } catch (NullPointerException npe){
                mensagem1.setStyle("-fx-text-fill: red;");
                mensagem1.setText("O arquivo não foi salvo.");
            }
        });

        abrirAgenda.setOnAction(e -> {
            try{
                File enderecoDoArquivo = dialogoDeArquivo.showOpenDialog(palco);
                if (enderecoDoArquivo.getPath().contains(".javabeans")){
                    FluxoBeans<Agenda> manipuladorDeAgenda = new FluxoBeans<>(enderecoDoArquivo.getPath());
                    agenda = manipuladorDeAgenda.le();
                } else if (enderecoDoArquivo.getPath().contains(".xml")){
                    FluxoBeansXml<Agenda> manipuladorDeAgenda = new FluxoBeansXml<>(enderecoDoArquivo.getPath());
                    agenda = manipuladorDeAgenda.le();
                }
                mensagem1.setStyle("-fx-text-fill: blue;");
                mensagem1.setText("Arquivo aberto com sucesso.");
                listaDeContatos.setItems(FXCollections.observableArrayList(agenda.contatos()));
            } catch (NullPointerException npe){
                mensagem1.setStyle("-fx-text-fill: red;");
                mensagem1.setText("O arquivo não foi aberto.");
            }
        });

        limpar.setOnAction(e -> {
            nome.setText("");
            telefone_1.setText("");
            telefone_2.setText("");
            email.setText("");
            dia.setText("");
            mes.setText("");
            ano.setText("");
            buscaDia.setText("");
            buscaMes.setText("");
            buscaAno.setText("");
            pesquisa.setText("");
        });

        pesquisar.setOnAction(e -> {
            Contato contatoAux = agenda.busca(pesquisa.getText());
            if (contatoAux == null){
                mensagem1.setStyle("-fx-text-fill: red;");
                mensagem1.setText("Não há um contato com esse nome");
            } else {
                Alert alerta = new Alert(AlertType.INFORMATION);
                alerta.setTitle("Busca");
                alerta.setHeaderText("Resultado da busca");
                alerta.setContentText("Nome: " + contatoAux.getNome()
                        + "\nTelefone 1: " + contatoAux.getTelefone_1()
                        + "\nTelefone 2: " + contatoAux.getTelefone_2()
                        + "\nE-mail: " + contatoAux.getEmail()
                        + "\nData de nascimento: " + contatoAux.getAniversario()
                );
                alerta.show();
            }
        });

        apagarAgenda.setOnAction(e -> {
            agenda.clear();
            listaDeContatos.setItems(FXCollections.observableArrayList(new ArrayList<>()));
            mensagem1.setStyle("-fx-text-fill: blue;");
            mensagem1.setText("Agenda apagada com sucesso!");
        });

        listaDeContatos.setOnMouseClicked(evento -> {
            if (evento.getButton() == MouseButton.PRIMARY && evento.getClickCount() == 2 && (evento.getTarget() instanceof LabeledText || listaDeContatos.getSelectionModel().getSelectedItem().length() > 0)){
                Contato contatoAux = agenda.busca(listaDeContatos.getSelectionModel().getSelectedItem());
                if (contatoAux == null){
                    mensagem1.setStyle("-fx-text-fill: red;");
                    mensagem1.setText("Não há um contato com esse nome");
                } else {
                    Alert alerta = new Alert(AlertType.INFORMATION);
                    alerta.setTitle("Busca");
                    alerta.setHeaderText("Resultado da busca");
                    alerta.setContentText("Nome: " + contatoAux.getNome()
                            + "\nTelefone 1: " + contatoAux.getTelefone_1()
                            + "\nTelefone 2: " + contatoAux.getTelefone_2()
                            + "\nE-mail: " + contatoAux.getEmail()
                            + "\nData de nascimento: " + contatoAux.getAniversario()
                    );
                    alerta.show();
                }
            }
        });

        apagarSelecao.setOnAction(e -> {
            String aux = listaDeContatos.getSelectionModel().getSelectedItem();
            if (aux != null){
                agenda.exclui(aux);
                mensagem2.setStyle("-fx-text-fill: blue;");
                mensagem2.setText("Contato apagado com sucesso!");
                listaDeContatos.setItems(FXCollections.observableArrayList(agenda.contatos()));
            }else{
                mensagem2.setStyle("-fx-text-fill: red;");
                mensagem2.setText("O contato não foi apagado.");
            }
        });
        
        dadosSelecao.setOnAction( evento -> {
            Contato contatoAux = agenda.busca(listaDeContatos.getSelectionModel().getSelectedItem());
                if (contatoAux == null){
                    mensagem1.setStyle("-fx-text-fill: red;");
                    mensagem1.setText("Não há um contato com esse nome");
                } else {
                    Alert alerta = new Alert(AlertType.INFORMATION);
                    alerta.setTitle("Busca");
                    alerta.setHeaderText("Resultado da busca");
                    alerta.setContentText("Nome: " + contatoAux.getNome()
                            + "\nTelefone 1: " + contatoAux.getTelefone_1()
                            + "\nTelefone 2: " + contatoAux.getTelefone_2()
                            + "\nE-mail: " + contatoAux.getEmail()
                            + "\nData de nascimento: " + contatoAux.getAniversario()
                    );
                    alerta.show();
                }
        });
        
        niverDoMes.setOnAction( e -> {
            Integer auxMes = Integer.parseInt(buscaMes.getText());
            ArrayList<Map.Entry<String, Contato>> filtrado = agenda.aniversariantesDoMes(auxMes);
            ArrayList<String> nomes = new ArrayList<>();
            filtrado.forEach( entrada -> nomes.add(entrada.getKey()));
            listaDeContatos.setItems(FXCollections.observableArrayList(nomes));
            mensagem2.setStyle("-fx-text-fill: orange;");
            mensagem2.setText("Agora você só vê uma parte dos dados. Para ver todos clique em 'Agenda'");
        });
        niverDaSemana.setOnAction( e -> {
            Integer auxDia = Integer.parseInt(buscaDia.getText());
            Integer auxMes = Integer.parseInt(buscaMes.getText());
            Integer auxAno = Integer.parseInt(buscaAno.getText());
            ArrayList<Map.Entry<String, Contato>> filtrado = agenda.aniversariantesDaSemana(auxDia, auxMes, auxAno);
            ArrayList<String> nomes = new ArrayList<>();
            filtrado.forEach( entrada -> nomes.add(entrada.getKey()));
            listaDeContatos.setItems(FXCollections.observableArrayList(nomes));
            mensagem2.setStyle("-fx-text-fill: orange;");
            mensagem2.setText("Agora você só vê uma parte dos dados. Para ver todos clique em 'Agenda'");
        });
        niverDoDia.setOnAction( e -> {
            Integer auxDia = Integer.parseInt(buscaDia.getText());
            Integer auxMes = Integer.parseInt(buscaMes.getText());
            ArrayList<Map.Entry<String, Contato>> filtrado = agenda.aniversariantesDoDia(auxDia , auxMes);
            ArrayList<String> nomes = new ArrayList<>();
            filtrado.forEach( entrada -> nomes.add(entrada.getKey()));
            listaDeContatos.setItems(FXCollections.observableArrayList(nomes));
            mensagem2.setStyle("-fx-text-fill: orange;");
            mensagem2.setText("Agora você só vê uma parte dos dados. Para ver todos clique em 'Agenda'");
        });
        
        mostrarAgenda.setOnAction( evento -> {
            listaDeContatos.setItems(FXCollections.observableArrayList(agenda.contatos()));
            mensagem2.setStyle("-fx-text-fill: blue;");
            mensagem2.setText("Todos os contatos estão sendo exibidos.");
        });
        
        alterarSelecao.setOnAction( e -> {
           Contato contatoAux = agenda.busca(listaDeContatos.getSelectionModel().getSelectedItem());
           nome.setText(contatoAux.getNome());
           telefone_1.setText(contatoAux.getTelefone_1());
           telefone_2.setText(contatoAux.getTelefone_2());
           email.setText(contatoAux.getEmail());
           dia.setText(""+contatoAux.getDia());
           mes.setText(""+contatoAux.getMes());
           ano.setText(""+contatoAux.getAno());
           nome.setEditable(false);
           mensagem1.setStyle("-fx-text-fill: blue;");
           mensagem1.setText("Altere o contato e o cadastre. Editar o nome é impossível enquanto isso");
           mensagem2.setStyle("-fx-text-fill: blue;");
           mensagem2.setText("Altere o contato e o cadastre. Editar o nome é impossível enquanto isso");
        });
        
    }
}
