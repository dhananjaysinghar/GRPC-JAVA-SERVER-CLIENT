package com.example.grpc.service;

import com.google.protobuf.Empty;
import com.grpc.ex.IdGeneratorServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class IdGeneratorServiceClient {

  private IdGeneratorServiceGrpc.IdGeneratorServiceBlockingStub serviceBlockingClient;

  public IdGeneratorServiceClient(){
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8000)
            .usePlaintext()
            .build();
    serviceBlockingClient = IdGeneratorServiceGrpc.newBlockingStub(channel);
  }

  public String getId() {
    return serviceBlockingClient.generate(Empty.newBuilder().build()).getId();
  }
}
