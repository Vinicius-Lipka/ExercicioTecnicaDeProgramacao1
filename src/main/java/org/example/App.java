package org.example;

import org.example.dominio.Agendamento;
import org.example.dominio.Cliente;
import org.example.excecoes.AcabouASenhaExcecao;
import org.example.servico.Agendar;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agendar agendar = new Agendar();
        System.out.println("Bem vindoao sistema de agendamento!");
        Integer opcao = 0;
        do {
            System.out.println(" selecione a opção desejada!");
            System.out.println();
            System.out.println("1 - Realizar agendamento \n 2 - Listar Agendamentos do dia");

            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:

                    Cliente cliente = new Cliente();
                    System.out.println("Digite o seu cpf");
                    cliente.setCpf(scanner.next());
                    System.out.println("Informe o seu nome");
                    cliente.setNome(scanner.next());

                    // TODO cadastrar agendamento

                    try {
                        Agendamento agendamento = agendar.realizarAgendamento(cliente);
                        System.out.printf("Agendamento realizado com sucesso! %n Agendamento %s em: %s ",
                                agendamento.getIdentificador(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
                                        .format(agendamento.getHorario()));
                    } catch (AcabouASenhaExcecao e) {
                        System.err.println(e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    // TODO listar agendamentos
                    System.out.println(agendar.imprimirAgenda());
                    break;
                default:
                    System.out.println("Informação inválida");
                    opcao = 0;

            }
        } while (opcao != 0);
    }
}
