
package intropoo;

import java.util.Calendar;
import java.util.Date;

public class Pessoa {
    private long cpf;
    private String nome;
    private Date dataNascimento;
    private int qtdeFilhos;
    private float valorHora;
    private float horasTrabalhadas;

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getQtdeFilhos() {
        return qtdeFilhos;
    }

    public void setQtdeFilhos(int qtdeFilhos) {
        this.qtdeFilhos = qtdeFilhos;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

    public float getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(float horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
    
        public int calcularIdade() {
        Calendar dataNasc = Calendar.getInstance();
        dataNasc.setTime(dataNascimento);

        Calendar hoje = Calendar.getInstance();
        hoje.getTime();

        int idade = hoje.get(Calendar.YEAR) - dataNasc.get(Calendar.YEAR);

        dataNasc.add(Calendar.YEAR, idade);

        if (hoje.before(dataNasc)) {
            idade--;
        }
        return idade;
    }
     
    //de 1 a 2 filhos, 5%; de 3 a 4, 10%; mais que 4, 20%     
    public float calcularBonus() {
        float valorTotal = valorHora * horasTrabalhadas;
        float percentual = 0;
        if (qtdeFilhos > 0) {
            if (qtdeFilhos < 3) {
                percentual = 0.05f;
            } else if (qtdeFilhos < 5) {
                percentual = 0.10f;
            } else {
                percentual = 0.20f;
            }
        }
        return valorTotal * percentual;
    } 

    
}
