package org.example.servico;

import org.example.dominio.Agendamento;
import org.example.dominio.Cliente;
import org.example.excecoes.AcabouASenhaExcecao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Agendar {
    private List<Agendamento> agendamentos;

    public Agendar() {
        agendamentos = new ArrayList<>();
    }

    public Agendamento realizarAgendamento(Cliente cliente) throws AcabouASenhaExcecao {
        LocalDateTime horarioAtendimento = pegarProximoHorarioAtendimento();

        Agendamento novoAgendamento = new Agendamento(cliente,
                DateTimeFormatter.ofPattern("yyyyMMddHHmm").format(horarioAtendimento),horarioAtendimento);

        agendamentos.add(novoAgendamento);
        return novoAgendamento;

    }

    public String imprimirAgenda() {
        Iterator<Agendamento> iterator = agendamentos.iterator();
        StringBuilder builder = new StringBuilder();

        String saida = "";
        if (iterator.hasNext()) {
            builder.append("Dia do atendimento" + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDate.now()));
            builder.append("\n Identidicador do agendamento \t Nome do Cliente \t Horário do atendimento ");

            while (iterator.hasNext()) {
                Agendamento proximoAgendamento = iterator.next();
                builder.append("\n");
                builder.append(saida + proximoAgendamento.getIdentificador() + "\t"
                        + proximoAgendamento.getCliente().getNome() + DateTimeFormatter.ofPattern("HH:mm").format(proximoAgendamento.getHorario()));
            }

        }

        //TODO impreimir a Lista
        return builder.toString();
    }

        private LocalDateTime pegarProximoHorarioAtendimento() throws AcabouASenhaExcecao {
            LocalDateTime localDateTime = null;
            // só permite 32 senhas por dia
            if (agendamentos.size() == 32) {
                throw new AcabouASenhaExcecao();
            }
            // está vazia
            if (agendamentos.isEmpty()) {
                LocalDateTime LocalDateTime = LocalDate.now().atTime(8, 0);

            } else {
                Agendamento ultimoAgendamento = agendamentos.get(agendamentos.size() - 1);
                localDateTime = ultimoAgendamento.getHorario().plusMinutes(15);
            }
            return localDateTime;

        }
        private void imprimirUltimoAgendamento() {
            agendamentos.size();
        }
    }
