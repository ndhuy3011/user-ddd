package com.ndhuy.user.users.infrastructure.listener;

import org.springframework.transaction.annotation.Transactional;

import com.ndhuy.proto_library.user.UserProto.AuthRequest;
import com.ndhuy.proto_library.user.UserProto.AuthResponse;
import com.ndhuy.proto_library.user.UserProto.RegisterReponse;
import com.ndhuy.proto_library.user.UserProto.RegisterRequest;
import com.ndhuy.proto_library.user.UserServiceGrpc;
import com.ndhuy.user.users.application.command.CreateUserCommand;
import com.ndhuy.user.users.infrastructure.services.IUserService;

import io.grpc.stub.StreamObserver;
import jakarta.annotation.Resource;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserListenerGrpc extends UserServiceGrpc.UserServiceImplBase {
    @Resource
    IUserService authenService;

    /**
     * @ndhuy3011
     *            Authenticate function
     * @param request
     * @param responseObserver
     */
    @Override
    public void authenticate(AuthRequest request, StreamObserver<AuthResponse> responseObserver) {
        var entity = authenService.login(request.getUsername(), request.getPassword());

        var response = AuthResponse.newBuilder()
                .setUuid(entity.id().toString())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * @ndhuy3011
     *            Register function
     * @param request
     * @param responseObserver
     */
    @Transactional
    @Override
    public void register(RegisterRequest request, StreamObserver<RegisterReponse> responseObserver) {
        var entity = authenService.register(CreateUserCommand.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .phone(request.getPhone())
                .fullName(request.getFullName())
                .build());
        var response = RegisterReponse.newBuilder()
                .setUuid(entity.id().toString())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
