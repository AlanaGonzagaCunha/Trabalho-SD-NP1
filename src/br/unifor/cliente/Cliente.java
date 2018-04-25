package br.unifor.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import br.unifor.controle.Controle;
import sun.misc.FpUtils;

public class Cliente {

	private static Socket socket;
	private static int porta;
	private static String ip;
	private static Controle controle;

	public Cliente(Controle controle) {
		this.controle= controle;
	}

	public static Controle getControle() {
		return controle;
	}

	public static void setControle(Controle controle) {
		Cliente.controle = controle;
	}

	public void enviaMessagem(String mgs) {

			System.out.println("O cliente conectou ao servidor, envia messagem: " +mgs);

			for(Socket socket: controle.getConexoes()) {
				System.out.println("Enviando mensagem para: "+socket.getInetAddress().getHostAddress());
				try {
					PrintStream ps = new PrintStream(socket.getOutputStream());
					ps.println(mgs);

				} catch (IOException e) {
					e.printStackTrace();
				}

			}
	}

	public static int getPorta() {
		return porta;
	}

	public static void setPorta(int porta) {
		Cliente.porta = porta;
	}

	public static String getIp() {
		return ip;
	}

	public static void setIp(String ip) {
		Cliente.ip = ip;
	}

	public Cliente(Socket c) {
		this.socket = c;
	}

}
