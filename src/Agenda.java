
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Agenda extends TreeMap<String, Contato>{

    { // Exemplos embutidos
        cadastrar("Contaxt", "78151384862", "87942318486", "umUsuario@servidorExemplo.com", 20, 05, 1990);
        cadastrar("Strauto", "85152345238", "87921681245", "maria@servidor.com", 16, 11, 1982);
        cadastrar("Celex", "78921525456", "32168468798", "josenildeta@outroservidor.com", 19, 11, 1850);
        cadastrar("Jacinta Bela de Deus (só pode mesmo)", "88445898751", "87512313861", "jacinta@maisumservidor.com", 01, 8, 2000);
        cadastrar("Exemplo De Um Contato Qualquer", "78151384862", "87942318486", "umUsuario@servidorExemplo.com", 20, 05, 1990);
        cadastrar("Contato Com Nome Tão Feio Que Foi Sensurado", "85152345238", "87921681245", "maria@servidor.com", 16, 11, 1982);
        cadastrar("Josenildete Neta de Jacintatete", "78921525456", "32168468798", "josenildeta@outroservidor.com", 19, 11, 1850);
        cadastrar("Jacinta Bela de Deus (só pode mesmo)", "88445898751", "87512313861", "jacinta@maisumservidor.com", 01, 8, 2000);
    }

    public void cadastrar(String nome, String telefone_1, String telefone_2, String email, int dia, int mes, int ano){
        Contato aux = new Contato();
        aux.setNome(nome);
        aux.setTelefone_1(telefone_1);
        aux.setTelefone_2(telefone_2);
        aux.setEmail(email);
        aux.setAniversario(new Data(dia, mes, ano));
        put(nome, aux);
    }

    public void exclui(String nome){
        remove(nome);
    }

    public void altera(String nome, String telefone_1, String telefone_2, String email, int dia, int mes, int ano){
        cadastrar(nome, telefone_1, telefone_2, email, dia, mes, ano);
    }

    /**
     *
     * @param nome
     * @return Um contato ou null se nada for encontrado.
     */
    public Contato busca(String nome){
        return get(nome);
    }

    public ArrayList<String> contatos(){
        ArrayList<String> nomes = new ArrayList<>();
        entrySet().forEach(entrada -> nomes.add(entrada.getKey()));
        return nomes;
    }

    public ArrayList<Entry<String, Contato>> aniversariantesDoMes(int mes){
        ArrayList<Entry<String, Contato>> entradas = new ArrayList<>();
        entrySet().stream().filter(entrada -> entrada.getValue().getAniversario().mes() == mes).forEach(entrada -> entradas.add(entrada));
        return entradas;
    }

    public ArrayList<Entry<String, Contato>> aniversariantesDaSemana(int dia, int mes, int ano){
        ArrayList<Entry<String, Contato>> entradas = new ArrayList<>();
        entrySet().stream().filter(entrada -> entrada.getValue().getAniversario().semana() == new Data(dia, mes, ano).semana()).forEach(entrada -> entradas.add(entrada));
        return entradas;
    }

    public ArrayList<Entry<String, Contato>> aniversariantesDoDia(int dia, int mes){
        ArrayList<Entry<String, Contato>> entradas = new ArrayList<>();
        entrySet().stream().filter(entrada -> entrada.getValue().getAniversario().mes() == mes && entrada.getValue().getAniversario().dia() == dia).forEach(entrada -> entradas.add(entrada));
        return entradas;
    }
}
