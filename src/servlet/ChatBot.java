package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

import dao.CotationDao;
import dao.RequestDao;
import entity.Moeda;
import entity.Request;

@ServerEndpoint(value = "/chat")
public class ChatBot {

	private CotationDao cotationDao;
	private RequestDao requestDao;

	public ChatBot() {
		this.cotationDao = new CotationDao();
		this.requestDao = new RequestDao();
	}

	Set<Session> userSessions = Collections.synchronizedSet(new HashSet<Session>());

	@OnOpen
	public void abrir(Session userSession) {
		System.out.println("Nova solicitação recebida. Id: " + userSession.getId());
		userSessions.add(userSession);
	}

	@OnClose
	public void fechar(Session userSession) {
		System.out.println("Conexão encerrada. Id: " + userSession.getId());
		userSessions.remove(userSession);
	}

	@OnMessage
	public synchronized void recebeMensagem(String mensagem, Session userSession) {
		System.out.println("Mensagem Recebida: " + mensagem);
		ArrayList<Moeda> msg = this.enviaMensagem(mensagem);

		String respondeMsg;

		if (msg.size() > 0) {
			for (Moeda msgs : msg) {

				respondeMsg = "Compra: " + msgs.getCompra() + " Venda: " + msgs.getVenda() + " Variação: "
						+ msgs.getPorcentagem_de_variacao() + " Data: " + msgs.getData_de_criacao();

				this.responde(respondeMsg, userSession);
			}
		}

		else {
			this.responde("Não foi encontrado nenhum resultado com os seguintes parâmetros:  " + mensagem, userSession);
		}
	}

	public ArrayList<Moeda> enviaMensagem(String mensagem) {
		// USD 2021-04-20 2021-05-12
		String[] separaMessagem = mensagem.split(" ");
		String code = separaMessagem[0];
		String start = separaMessagem[1];
		String end = separaMessagem[2];
		ArrayList<Moeda> umaMoeda = cotationDao.selectCodeAndDate(code, start, end);

		this.store(code);

		return umaMoeda;
	}

	private void store(String code) {
		Request request = new Request();
		request.setCode(code.toUpperCase());
		requestDao.store(request);

	}

	public synchronized void responde(String msg, Session userSession) {

		try {
			userSession.getBasicRemote().sendText(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
