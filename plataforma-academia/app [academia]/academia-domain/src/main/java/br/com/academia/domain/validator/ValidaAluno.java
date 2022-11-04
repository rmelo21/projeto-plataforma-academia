//package br.com.academia.domain.validator;
//
//import br.com.academia.domain.model.Aluno;
//import br.com.academia.domain.ports.in.ProcessarEventoPort;
//import br.com.academia.domain.service.ServiceAluno;
//import org.springframework.util.StringUtils;
//
//
//public class ValidaAluno implements ProcessarEventoPort {
//
////    private MapeiaAluno mapeiaAluno;
//
//    private ServiceAluno serviceAluno;
//
//    public void validarAluno (final Aluno aluno) {
//
//        if(aluno != null) {
//
//            //TODO IMPLEMNTAR CHECK PARA TODOS OS CAMPOS
////            checkNotEmpty(aluno.getNomeResponsavel(), "codigoAluno");
//
////            mapeiaAluno.mapearAluno(aluno);
//            //TODO ENVIAR PARA BD
//
//
//            serviceAluno.cadastrarAluno(aluno);
//
//        }
//    }
//
//    private boolean checkNotEmpty (final String field, final String parameter) {
//        if (!StringUtils.hasText(field)) {
//         //TODO CRIAR CLASS OU LISTA EXCEPTION
//
//        }
//        return true;
//    }
//
//
//}
