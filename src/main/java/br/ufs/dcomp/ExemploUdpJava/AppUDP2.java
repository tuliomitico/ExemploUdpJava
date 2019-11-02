package br.ufs.dcomp.ExemploUdpJava; 

import java.net.*;
import java.util.Scanner;

public class AppUDP2 {

    public static void main(String[] args) throws SocketException {
        try{

            System.out.print("[ Alocando porta UDP                  ..................  ");
    	    DatagramSocket socket = new DatagramSocket(20000);
            System.out.println("[OK] ]");
            while (true){
            byte[] buf = new byte[128];
            DatagramPacket pack = new DatagramPacket(buf, buf.length);

            System.out.print("[ Aguardando recebimento de mensagem  ..................  ");
            socket.receive(pack);
            System.out.println("[OK] ]");
            
            byte[] received_data = pack.getData();
            String received_msg = new String(received_data); 
            InetAddress origin_address = pack.getAddress();
            int origin_port = pack.getPort();
            
            System.out.println("  Mensagem:             "+received_msg);
            System.out.println("  Endereço de origem:   "+origin_address.getHostAddress());
            System.out.println("  Porta de origem:      "+origin_port);
            
            Scanner input = new Scanner(System.in);
            String retweet = input.nextLine();
            
            byte[] retweet_buf = retweet.getBytes();
            int retweet_size = retweet_buf.length;
            
            InetAddress destino_end = origin_address;
            
            DatagramPacket pacote = new DatagramPacket(retweet_buf,retweet_size,origin_address,origin_port);
            System.out.println("Vai!");
            socket.send(pacote);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }    
        
        
        
        

    }
}