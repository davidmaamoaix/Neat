package cn.davidma.neat.network.proxy.remote;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.Socket;

import cn.davidma.neat.network.Side;
import cn.davidma.neat.network.packet.Packet;

public class RemoteClientProxy implements IRemoteProxy {
	
	private Socket connection;
	private BufferedReader reader;
	
	public RemoteClientProxy(Socket connection) {
		this.connection = connection;
	}
	
	@Override
	public Side getSide() {
		return Side.CLIENT;
	}

	@Override
	public void terminate() {
		//connection.close();
	}

	@Override
	public void send(Packet packet) {
		
	}
}
