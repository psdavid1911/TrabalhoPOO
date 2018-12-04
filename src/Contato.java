
import java.io.Serializable;

public class Contato implements Serializable{

    String Nome;
    String Telefone_1;
    String Telefone_2;
    String Email;
    int dia;
    int mes;
    int ano;

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    

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
