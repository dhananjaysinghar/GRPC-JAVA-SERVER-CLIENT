package com.example.grpc;


import com.example.grpc.service.IdGeneratorService;
import com.example.grpc.service.IdGeneratorServiceClient;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GrpcExample1Application {

	public static void main(String[] args) throws IOException, InterruptedException {
		int port = 8000;
		Server server = ServerBuilder.forPort(port)
				.addService(new IdGeneratorService())
				.build();

		server.start();
		System.out.println("----------Server started !!");
		System.out.println("----------Listening on port: " +port);

    for (int i = 0; i < 1000; i++) {
		IdGeneratorServiceClient client = new IdGeneratorServiceClient();
		TimeUnit.MILLISECONDS.sleep(100);
      System.out.println(client.getId());
	}
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("---------Received shutdown request !!");
			server.shutdown();
			System.out.println("---------Server Stopped !!");
		}));
		server.awaitTermination();
	}

}
