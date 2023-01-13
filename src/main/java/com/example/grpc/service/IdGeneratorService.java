package com.example.grpc.service;

import com.google.protobuf.Empty;
import com.grpc.ex.IDGeneratorResponse;
import com.grpc.ex.IdGeneratorServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

public class IdGeneratorService extends IdGeneratorServiceGrpc.IdGeneratorServiceImplBase {
  @Override
  public void generate(Empty request, StreamObserver<IDGeneratorResponse> responseObserver) {
    System.out.println("Received request to generate bookingId");
    IDGeneratorResponse response =
        IDGeneratorResponse.newBuilder().setId(UUID.randomUUID().toString()).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
