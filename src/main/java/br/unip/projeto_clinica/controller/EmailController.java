package br.unip.projeto_clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unip.projeto_clinica.service.EmailService;
	 @RestController
	    @RequestMapping("/email")
	    public class EmailController {

	        @Autowired
	        private EmailService emailService;

	        @PostMapping("/enviar")
	        public String enviarEmail(@RequestBody EmailRequest emailRequest) {
	            return emailService.enviarEmailTexto(
	                emailRequest.getDestinatario(),
	                emailRequest.getAssunto(),
	                emailRequest.getMensagem()
	            );
	        }

	        // Classe interna
	        public static class EmailRequest {
	            private String destinatario;
	            private String assunto;
	            private String mensagem;

	            // Getters e Setters
	            public String getDestinatario() { return destinatario; }
	            public void setDestinatario(String destinatario) { this.destinatario = destinatario; }

	            public String getAssunto() { return assunto; }
	            public void setAssunto(String assunto) { this.assunto = assunto; }

	            public String getMensagem() { return mensagem; }
	            public void setMensagem(String mensagem) { this.mensagem = mensagem; }
	        }
	    }

