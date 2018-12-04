
import java.io.Serializable;

public class Contato implements Serializable{

    String Nome;
    String Telefone_1;
    String Telefone_2;
    String Email;
    int dia;
    int mes;
    int ano;

    public String getNome() {
        return this.Nome;
    }

    public String getTelefone_1() {
        return this.Telefone_1;
    }

    public String getTelefone_2() {
        return this.Telefone_2;
    }

    public String getEmail() {
        return this.Email;
    }

    public Data getAniversario() {
        return new Data(dia, mes, ano);
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public void setTelefone_1(String telefone_1) {
        this.Telefone_1 = telefone_1;
    }

    public void setTelefone_2(String telefone_2) {
        this.Telefone_2 = telefone_2;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setAniversario(Data aniversario) {
        dia = aniversario.dia();
        mes = aniversario.mes();
        ano = aniversario.ano();
    }

}
