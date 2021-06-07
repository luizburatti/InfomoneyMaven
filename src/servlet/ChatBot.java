package servlet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

import dao.CotationDao;
import entity.Moeda;

@ServerEndpoint(value = "/chat")
public class ChatBot {
		
	private CotationDao cotationDao;
	
	public ChatBot() {
		this.cotationDao = new CotationDao();
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
	public void recebeMensagem(String mensagem, Session userSession) {
		 System.out.println("Mensagem Recebida: " + mensagem);
		ArrayList<Moeda> msg = this.enviaMensagem(mensagem);
		for(Moeda msgs : msg){
			userSession.getAsyncRemote().sendObject(msgs);
			System.out.println(msgs);
        }
	}
	
	
	public ArrayList<Moeda> enviaMensagem(String mensagem) {
		//USD 2021-04-20 2021-05-12
		String[] separaMessagem = mensagem.split(" ");
		String code = separaMessagem[0];
		String start = separaMessagem[1];
		String end = separaMessagem[2];
		ArrayList<Moeda> umaMoeda = cotationDao.selectCodeAndDate(code, start, end);
		return umaMoeda;
	}
}
