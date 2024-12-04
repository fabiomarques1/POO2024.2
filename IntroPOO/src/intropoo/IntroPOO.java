package intropoo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
/* 

Programa criado para solicitar os dados das pessoas (objeto da classe Pessoa)
e exibir os cálculos 

*/
public class IntroPOO {

    public static void main(String[] args) {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        
        loopPrincipal:
        while (true) {
            //Instanciando o teclado
            String input;
            //Instanciando pessoa
            Pessoa p = new Pessoa();
            //Pedindo CPF e Nome
            boolean erro = true;
            do {
                try {
                    input = JOptionPane.showInputDialog("Informe o CPF ou digite -1 para SAIR: ");
                    if (input.equals("-1")) {
                        break loopPrincipal;
                    }
                    if (input.length() != 11) {
                        throw new Exception("CPF precisa ter 11 dígitos!");
                    }
                    p.setCpf(Long.parseLong(input));
                    erro = false;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "CPF Inválido");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            } while (erro);

            erro = true;
            do {
                try {
                    input = JOptionPane.showInputDialog("Informe o Nome: ");
                    if (input.trim().isEmpty()) {
                        throw new Exception("Nome é obrigatório");
                    }
                    p.setNome(input);
                    erro = false;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            } while (erro);
            //Pedindo a Data de Nascimento
            erro = true;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            do {
                String dt = JOptionPane.showInputDialog("Informe a Data de Nascimento: ");
                try {
                    Date data = sdf.parse(dt);
                    Calendar dataNasc = Calendar.getInstance();
                    dataNasc.setTime(data);
                    Calendar hoje = Calendar.getInstance();
                    hoje.getTime();
                    if (hoje.before(dataNasc)) {
                        throw new Exception("Data Nascimento não pode ser posterior a data de hoje!");
                    }
                    p.setDataNascimento(data);
                    erro = false;
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Data Inválida!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            } while (erro);
            //Pedindo a Qtde de Filhos
            erro = true;
            do {
                try {
                    input = JOptionPane.showInputDialog("Informe a qtde de filhos: ");
                    p.setQtdeFilhos(Integer.parseInt(input));
                    erro = false;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Qtde Inválida");
                }
            } while (erro);
            //Pedindo a Qtde de Horas
            erro = true;
            do {
                try {
                    float hora = Float.parseFloat(JOptionPane.showInputDialog("Informe a qtde de horas: "));
                    p.setHorasTrabalhadas(hora);
                    erro = false;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Formato de horas inválido");
                }
            } while (erro);
            //Pedindo o valor hora
            erro = true;
            do {
                try {
                    input = JOptionPane.showInputDialog("Informe o valor hora: ");
                    p.setValorHora(Float.parseFloat(input));
                    erro = false;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Formato de valor hora inválido");
                }
            } while (erro);

            //Cálculo e exibição dos resultados
            float valorAReceber = p.getValorHora() * p.getHorasTrabalhadas();
            float bonus = p.calcularBonus();
            String mensagem = "CPF: " + p.getCpf();
            mensagem += "\nNome: " + p.getNome();
            mensagem += "\nData de Nascimento: " + sdf.format(p.getDataNascimento());
            mensagem += "\nIdade: " + p.calcularIdade();
            mensagem += "\nQtde de Filhos: " + p.getQtdeFilhos();
            mensagem += "\nValor a Receber: R$ " + String.format("%,.2f", valorAReceber);
            mensagem += "\nBônus: R$ " + String.format("%,.2f", bonus);
            mensagem += "\nValor Total: R$ " + String.format("%,.2f", (valorAReceber + bonus));
            JOptionPane.showMessageDialog(null, mensagem);
            pessoas.add(p);
        }
        
        String m = "Pessas cadastradas:";
        for (Pessoa p: pessoas) {
            m += "\n" + p.getNome();
        }
        JOptionPane.showMessageDialog(null, m);
    }

}
