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

    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        while (true) {
            Pessoa p = cadastrarPessoa();
            if (p == null) {
                break;
            }
            //Cálculo e exibição dos resultados
            float valorAReceber = p.getValorHora() * p.getHorasTrabalhadas();
            float bonus = p.calcularBonus();
            String cpf = String.valueOf(p.getCpf());
            cpf = cpf.substring(0,3) + "." + cpf.substring(3,6) + "." + cpf.substring(6,9) + "-" + cpf.substring(9,11);
            String mensagem = "CPF: " + cpf;
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
        for (Pessoa p : pessoas) {
            m += "\n" + p.getNome();
        }
        JOptionPane.showMessageDialog(null, m);
    }

    public static Pessoa cadastrarPessoa() {
        //Instanciando o teclado
        String input;
        //Instanciando pessoa
        Pessoa p = new Pessoa();
        //Pedindo CPF   
        while (true) {
            try {
                input = JOptionPane.showInputDialog("Informe o CPF ou digite -1 para SAIR: ");
                if (input.equals("-1")) {
                    return null;
                }
                if (input.length() != 11) {
                    throw new Exception("CPF precisa ter 11 dígitos!");
                }
                p.setCpf(Long.parseLong(input));
                break;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "CPF Inválido");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        //Pedindo o Nome
        while (true) {
            try {
                input = JOptionPane.showInputDialog("Informe o Nome: ");
                if (input.trim().isEmpty()) {
                    throw new Exception("Nome é obrigatório");
                }
                p.setNome(input);
                break;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        //Pedindo a Data de Nascimento
        while (true) {
            try {
                sdf.setLenient(false);
                String dt = JOptionPane.showInputDialog("Informe a Data de Nascimento: ");
                Date data = sdf.parse(dt);
                Calendar dataNasc = Calendar.getInstance();
                dataNasc.setTime(data);
                Calendar hoje = Calendar.getInstance();
                hoje.getTime();
                if (hoje.before(dataNasc)) {
                    throw new Exception("Data Nascimento não pode ser posterior a data de hoje!");
                }
                p.setDataNascimento(data);
                break;
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Data Inválida!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        //Pedindo a Qtde de Filhos
        while (true) {
            try {
                input = JOptionPane.showInputDialog("Informe a qtde de filhos: ");
                p.setQtdeFilhos(Integer.parseInt(input));
                break;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Qtde Inválida");
            }
        }
        //Pedindo a Qtde de Horas
        while (true) {
            try {
                float hora = Float.parseFloat(JOptionPane.showInputDialog("Informe a qtde de horas: "));
                p.setHorasTrabalhadas(hora);
                break;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Formato de horas inválido");
            }
        }
        //Pedindo o valor hora
        while (true) {
            try {
                input = JOptionPane.showInputDialog("Informe o valor hora: ");
                p.setValorHora(Float.parseFloat(input));
                break;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Formato de valor hora inválido");
            }
        }
        return p;
    }


}
