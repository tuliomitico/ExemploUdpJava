package br.ufs.dcomp.ExemploUdpJava;

import java.net.*;
import static java.lang.System.*;
import java.util.Scanner;
public class AppUDP1 {

    public static void main(String[] args) throws SocketException {
        try{
            System.out.print("[ Alocando porta UDP      ..................  ");
    	    DatagramSocket socket = new DatagramSocket(10000);
            System.out.println("[OK] ]");
            while (true){
            Scanner sc = new Scanner(System.in);
            String msg = sc.nextLine();
            
            byte[] msg_buf = msg.getBytes();
            int msg_size = msg_buf.length;
            InetAddress destination_address = InetAddress.getLocalHost();
            int destination_port = 20000; 

            System.out.print("[ Montando datagrama UDP  ..................  ");
            DatagramPacket pack = new DatagramPacket(msg_buf, msg_size, destination_address, destination_port);
            System.out.println("[OK] ]");
            
            System.out.print("[ Enviando datagrama UDP  ..................  ");
            socket.send(pack);
            System.out.println("[OK] ]");
            byte[] buffer = new byte[128]
            DatagramPacket pacote = new DatagramPacket(buffer,buffer.length)
            socket.receive(pacote);
            
            InetAddress origem_end = pack.getAddress();
            int porta_origem = pack.getPort();
            byte[] dado_recebido = pack.getData();
            String msg_recebida = new String(dado_recebido);
            
            System.out.println("Mensagem:"+"\t" +msg_recebida);
            System.out.println("Endereço de origem: "+"\t" +origem_end);
            System.out.println("Porta de Origem: " + "\t" +porta_origem);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
    }
}